FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp

WORKDIR /code

COPY /build/libs/market-0.0.1.jar /code/app.jar

ENTRYPOINT [ "java", "-jar", "-Dspring.profiles.active=pnd","/code/app.jar" ]