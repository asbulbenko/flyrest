FROM adoptopenjdk:11-jre-hotspot
COPY build/libs/flyrest-0.0.1-SNAPSHOT.jar flyrest-1.0.jar
ENTRYPOINT ["java","-jar","/flyrest-1.0.jar"]
