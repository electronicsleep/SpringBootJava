FROM alpine:latest

RUN mkdir -p /usr/src/app

RUN apk update && apk upgrade
RUN apk add openjdk11-jre
ADD build/libs/SpringBootJava.jar /usr/src/app

WORKDIR /usr/src/app
EXPOSE 8080
CMD ["java", "-jar", "SpringBootJava.jar"]
