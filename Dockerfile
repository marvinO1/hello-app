FROM openjdk:8-alpine

WORKDIR .

COPY target/hello-app-0.1.0.jar hello-app-0.1.0.jar

CMD ["java", "-jar", "hello-app-0.1.0.jar", "--management.endpoints.web.exposure.include=*"]
