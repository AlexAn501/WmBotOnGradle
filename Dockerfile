FROM adoptopenjdk/openjdk11:ubi
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java", "-Dspring.profiles.active=application", "-Dbot.username=${BOT_NAME}", "-Dbot.token=${BOT_TOKEN}", "-Dspring.datasource.password=${BOT_DB_PASSWORD}", "-Dspring.datasource.username=${BOT_DB_USERNAME}", "-jar", "/app.jar"]