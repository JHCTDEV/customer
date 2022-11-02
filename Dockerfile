FROM openjdk:17
EXPOSE 8081
ARG JAR_FILE=./target/Customer-0.0.1-SNAPSHOT.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]