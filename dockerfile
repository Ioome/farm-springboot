FROM openjdk:8-jre
MAINTAINER sutton
WORKDIR /
ADD target/farm-springboot-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 9241 7397
ENTRYPOINT ["java", "-jar"]
CMD ["app.jar"]