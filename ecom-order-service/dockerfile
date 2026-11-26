FROM eclipse-temurin:21-jdk
WORKDIR /app
COPY target/ecom-order-service-0.0.1-SNAPSHOT.jar ecom-order-service.jar
EXPOSE 8080
ENTRYPOINT [ "java","-jar","ecom-order-service.jar" ]