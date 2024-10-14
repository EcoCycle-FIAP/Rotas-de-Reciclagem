FROM eclipse-temurin:21-alpine

VOLUME /tmp

EXPOSE 8080

ARG JAR_FILE=target/rotasdereciclagem-0.0.1-SNAPSHOT.jar

ADD ${JAR_FILE} app.jar
ADD targetDocker/springboot-images-rotasdereciclagem.jar springboot-images-rotasdereciclagem.jar

ENTRYPOINT ["java","-jar","/app.jar", "springboot-images-rotasdereciclagem.jar"]
