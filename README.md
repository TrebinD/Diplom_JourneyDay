# Дипломный проект по профессии «Тестировщик ПО»
Дипломный проект представляет собой автоматизацию тестирования комплексного сервиса, взаимодействующего с СУБД и API Банка.
## Документация
1. [План автоматизации](./Plan.md)
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
6. В файле [DataHelper](./src/test/java/helper/SqlHelper.java) раскоментировать нужный метод setupSQL для базы данных.
7. Запустить тесты ./gradlew clean test
8. Запустить отчет ./gradlew allureserve 
9. Остановить приложение Ctrl + C в консоле
10. Остановить базы данных docker-compose stop