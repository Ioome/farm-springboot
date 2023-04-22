FROM openjdk:8-jre
MAINTAINER pdai
WORKDIR /
ADD target/farm-springboot-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar"]
CMD ["app.jar"]