FROM maven:3.9-eclipse-temurin-25 AS build
WORKDIR /workspace

COPY . .
RUN mvn -B -DskipTests package

RUN set -eu; \
    JAR="$(find userrestservice/target -maxdepth 1 -type f -name '*.jar' ! -name '*.original' | head -n 1)"; \
    test -n "$JAR"; \
    cp "$JAR" /workspace/app.jar

FROM eclipse-temurin:25-jre
WORKDIR /app
COPY --from=build /workspace/app.jar app.jar
EXPOSE 10000
ENTRYPOINT ["java", "-jar", "app.jar"]
