FROM eclipse-temurin:21-alpine

VOLUME /tmp

EXPOSE 8080
ADD target/springboot-images-rotasdereciclagem.jar springboot-images-rotasdereciclagem.jar

ENTRYPOINT ["java","-jar","/app.jar", "springboot-images-rotasdereciclagem.jar"]
