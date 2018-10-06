FROM java:8

#Author of the Docker File
MAINTAINER Segun Oladapo

EXPOSE 8080

ADD /target/three-options-trip-0.0.1-SNAPSHOT.jar three-options-trip-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "three-options-trip-0.0.1-SNAPSHOT.jar"]