FROM openjdk:11
VOLUME /tmp
EXPOSE 8080
ARG JAR_FILE=target/Gestion_des_produits_pharmaceutique.jar
ADD ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]