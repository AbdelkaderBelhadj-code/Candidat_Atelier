FROM openjdk:8
EXPOSE 8082
ADD target/Candidate-0.0.1-SNAPSHOT.jar Candidate.jar
ENTRYPOINT ["java", "-jar", "Candidate.jar"]
