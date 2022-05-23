FROM maven:3-openjdk-11 AS builder

WORKDIR /university/src/

COPY src ./
COPY pom.xml ../

RUN mvn -f /university/pom.xml install -DskipTests

FROM openjdk

WORKDIR /app
COPY --from=builder /university/target/*.jar university.jar

ENTRYPOINT ["java", "-jar", "/app/university.jar"]
