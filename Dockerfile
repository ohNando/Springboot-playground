FROM openjdk:21
COPY target/market-simulation-0.0.1-SNAPSHOT.jar simulation.jar
ENTRYPOINT ["java","-jar","simulation.jar"]