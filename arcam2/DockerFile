FROM openjdk:17-jdk-slim
COPY "./build/libs/arcam2-0.0.1-SNAPSHOT.jar" "appNttdata2.jar"
EXPOSE 8083
ENTRYPOINT ["java","-jar","appNttdata2.jar"]