FROM openjdk:11
EXPOSE 8081
COPY target/tpAchatProject.jar tpAchatProject.jar
ENTRYPOINT ["java","-jar","/tpAchatProject.jar"]
