
FROM eclipse-temurin:21-jdk


WORKDIR /app

COPY . /app


RUN apt-get update && apt-get install -y ant && apt-get clean


RUN ant compile

CMD ["ant", "run", "-Dargs=int add 100 200"]
