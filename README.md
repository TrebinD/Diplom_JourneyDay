# Дипломный проект по профессии «Тестировщик ПО»
Дипломный проект представляет собой автоматизацию тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.
## Документация
1. [План автоматизации](./Plan.md)
2. [Отчет по итогам тестирования](./Report.md);
3. [Отчет по итогам автоматизации](./Summary.md);
## Что потребуется для запуска тестов:
1. Клонировать [репозиторий](https://github.com/TrebinD/Diplom_JourneyDay)
2. Установить [Docker](https://www.docker.com/products/docker-desktop/) 
3. Установить [IntelliJ IDEA](https://www.jetbrains.com/ru-ru/idea/)
4. Установить [Git](https://git-scm.com/)
## Шаги запуска приложения:
1. Запустить Docker
2. Запустить Idea
3. Открыть проект, клонированный из репозитория 
4. Ввести команду в консоле Idea : docker-compose up -d
5. Запустить aqa-shop.jar для конкретной базы данных:
 - Для базы данных MySql:
   >java "-Dspring.datasource.url=jdbc:mysql://localhost:3306/app" -jar artifacts/aqa-shop.jar 
 - Для базы данных Postgres:
   >java "-Dspring.datasource.url=jdbc:postgresql://localhost:5432/app" -jar artifacts/aqa-shop.jar
6. Запустить тесты для определенной базы данных:

> Для MySql - ./gradlew clean test -DurlDB="jdbc:mysql://localhost:3306/app"

> Для Postgres - ./gradlew clean test -DurlDB="jdbc:postgresql://localhost:5432/app"

7. Запустить отчет ./gradlew allureServe 
8. Остановить приложение Ctrl + C в консоле
9. Остановить базы данных docker-compose stop