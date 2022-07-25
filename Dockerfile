FROM openjdk:8
ADD target/atmproduct-0.0.1-SNAPSHOT.jar atmproduct-0.0.1-SNAPSHOT.jar
EXPOSE 9083
ENTRYPOINT ["java", "-jar", "atmproduct-0.0.1-SNAPSHOT.jar"]