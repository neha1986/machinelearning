FROM openjdk:17
COPY ./target/machinelearning-0.0.1-SNAPSHOT .
CMD ["java","-jar","machinelearning-0.0.1-SNAPSHOT"]
