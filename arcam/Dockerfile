FROM openjdk:17-jdk-slim
COPY "./build/libs/arcam-0.0.1-SNAPSHOT.jar" "appNttdata.jar"
EXPOSE 8082
ENTRYPOINT ["java","-jar","appNttdata.jar"]