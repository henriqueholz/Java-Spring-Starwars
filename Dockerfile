FROM openjdk:17
ARG JAR_FILE=out/artifacts/api_crud_jar/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]