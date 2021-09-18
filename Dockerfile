FROM openjdk:8u302-slim-buster
ADD target/*.jar /app/app.jar
CMD ["java", "-jar", "app.jar"]