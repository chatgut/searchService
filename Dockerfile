FROM maven:3.9.1-eclipse-temurin as build
COPY . /app
WORKDIR /app
RUN mvn clean package

FROM eclipse-temurin:20-jdk
COPY --from=build /app/target/*.jar /app/searchService.jar

EXPOSE 8080

CMD ["java", "-jar", "app/searchService.jar"]