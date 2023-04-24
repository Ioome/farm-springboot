FROM openjdk:8-jre
MAINTAINER sutton
WORKDIR /
ADD target/farm-springboot-0.0.1-SNAPSHOT.jar app.jar
#q: 这个是什么意思？ a: 暴露端口 q: 这个是容器的端口吗？ a: 是的
#q: 这个端口 和  yml 中的port 有什么关系？ a: 没有关系，这个是容器的端口，yml中的是应用的端口
EXPOSE 9241 7397 8080
ENTRYPOINT ["java", "-jar"]
CMD ["app.jar"]