FROM openjdk:17-sdk-slim
ADD "./target/inventario-back-0.0.1-SNAPSHOT.jar" "app.jar"
ENV usuario="admin"
ENV password="admin123"
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]