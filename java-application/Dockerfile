# Используем официальный образ Java для сборки
FROM maven:3.9.0-openjdk-17 AS build

# Устанавливаем рабочую директорию
WORKDIR /credit-score

# Копируем pom.xml и исходный код для зависимостей
COPY pom.xml .
COPY src ./src

# Собираем jar-файл
RUN mvn clean package -DskipTests

# Используем официальный образ Java для выполнения
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /credit-score

# Копируем jar-файл приложения из предыдущего этапа сборки
COPY --from=build /credit-score/target/demo-0.0.1-SNAPSHOT.jar credit-score.jar

# Запускаем приложение
ENTRYPOINT ["java", "-jar", "credit-score.jar"]