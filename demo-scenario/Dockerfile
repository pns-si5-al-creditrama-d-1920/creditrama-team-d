FROM maven:3-jdk-8
ENV PORT 8080
EXPOSE 8080

WORKDIR /opt

COPY . .

CMD ["mvn", "test"]
