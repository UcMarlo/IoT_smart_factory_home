FROM adoptopenjdk/openjdk11:alpine-jre
WORKDIR /opt/app

ARG JAR_FILE=target/smart.jar

# cp spring-boot-web.jar /opt/app/app.jar
COPY ${JAR_FILE} app.jar

# java -jar /opt/app/app.jar
ENTRYPOINT ["java","-jar","app.jar"]

EXPOSE 8080