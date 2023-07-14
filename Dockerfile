FROM openjdk:11
EXPOSE 8081
COPY target/java-app.jar tpAchatProject.jar
ENTRYPOINT ["java","-jar","/tpAchatProject.jar"]
