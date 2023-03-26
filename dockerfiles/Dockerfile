FROM --platform=linux/x86_64 eclipse-temurin:17-alpine

WORKDIR /app

COPY build/libs/tasks-manager-*-all.jar tasks-manager.jar

EXPOSE 8080

CMD java -jar tasks-manager.jar