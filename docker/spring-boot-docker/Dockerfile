FROM openjdk:11
COPY /target/spring-boot-docker-0.0.1-SNAPSHOT.jar app/app.jar
COPY run.sh /run.sh
EXPOSE 8089
CMD ["java","-jar","app/app.jar"]