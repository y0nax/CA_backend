FROM openjdk:11
EXPOSE 8080
ADD ./targe/archivo.jar app.jar
ENTRYPOINT ["java", "-jar", "app.jar"]
