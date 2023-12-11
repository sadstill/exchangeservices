# exchangeservices

# Микросервисное приложение для работы с курсом валют.

Here you can view the current exchange rate.

How to use it?
First of all do - mvn clean package -DskipTests u can skip this option and run container with my jar file
Run docker compose up
Open postman or a similar tool to interact with the API if u want to convert the course
Send a GET request to localhost:8080/currency-converter with json in body of request
If u want to check the course (CNY, USD, EUR) to rub, u should send a GET request to http://localhost:8080/currency-rates. U can do this at browser.

How json looks like?
{
  "sourceCurrency": "USD", // валюта, которую хотим поменять
  "amount": 1, // количество валюты, которую хотим поменять
  "targetCurrency": "EUR" // результирующая валюта
}
Реализован реактивный подход для выполнения запросов к стороннему API. + накаченый миграции liquibase и запуск скрипта на создание таблицы при первом запуске приложения. Приложение готово к запуску в контейнерах.



// TODO добавить kafka producer + consumer
