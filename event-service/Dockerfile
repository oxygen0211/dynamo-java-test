FROM java:8

ADD target/event-service-0.0.1-SNAPSHOT-jar-with-dependencies.jar /etc
ADD credentials /root/.aws/credentials

CMD ["java", "-jar", "/etc/event-service-0.0.1-SNAPSHOT-jar-with-dependencies.jar"]