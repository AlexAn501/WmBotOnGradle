FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
ENV BOT_NAME=world_mac
ENV BOT_TOKEN=5518341246:AAFKeTlse8fVQ9sGxyd4-rK
ENV BOT_DB_USERNAME=postgr
ENV BOT_DB_PASSWORD=postgr
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=application", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "/app.jar"]