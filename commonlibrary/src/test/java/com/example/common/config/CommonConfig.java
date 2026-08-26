package com.example.common.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

@Configuration
@ComponentScan(basePackages = {"com.example.common", "com.example.common.dao", "com.example.common.dao.impl",
        "com.example.common.service", "com.example.common.service.impl"})
@EnableTransactionManagement
public class CommonConfig {

    @Bean
    public DataSource commonDataSource() {

        return DataSourceBuilder.create()
                .driverClassName("org.h2.Driver")
                //.url("jdbc:h2:mem:commondb;DB_CLOSE_DELAY=-1")
                .url("jdbc:h2:mem:commondb;DB_CLOSE_DELAY=-1;INIT=CREATE SCHEMA IF NOT EXISTS MYSCHEMA\\;SET SCHEMA MYSCHEMA")
                .username("sa")
                .password("")
                .build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            DataSource dataSource) {

        LocalContainerEntityManagerFactoryBean emf =
                new LocalContainerEntityManagerFactoryBean();

        emf.setDataSource(dataSource);

        /*
         * No @Entity classes.
         * We only use native SQL.
         */
        emf.setPackagesToScan();

        HibernateJpaVendorAdapter vendorAdapter =
                new HibernateJpaVendorAdapter();

        vendorAdapter.setShowSql(true);
        vendorAdapter.setGenerateDdl(false);

        emf.setJpaVendorAdapter(vendorAdapter);

        Map<String, Object> properties = new HashMap<>();

        properties.put(
                "hibernate.dialect",
                "org.hibernate.dialect.H2Dialect");

        properties.put(
                "hibernate.hbm2ddl.auto",
                "none");

        properties.put(
                "hibernate.show_sql",
                "true");

        emf.setJpaPropertyMap(properties);

        return emf;
    }

    @Bean
    public PlatformTransactionManager transactionManager(
            EntityManagerFactory entityManagerFactory) {

        return new JpaTransactionManager(
                entityManagerFactory);
    }
    
    @Bean
    public DataSourceInitializer dataSourceInitializer(
            DataSource dataSource) {

        ResourceDatabasePopulator populator =
                new ResourceDatabasePopulator();

        populator.addScript(
                new ClassPathResource("db/schema-h2.sql"));

        populator.addScript(
                new ClassPathResource("db/data-h2.sql"));

        DataSourceInitializer initializer =
                new DataSourceInitializer();

        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(populator);

        return initializer;
    }

}