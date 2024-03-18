# relex-internship-task: Farm journal

Функциональные требования: [Google docs](https://docs.google.com/document/d/1-h_AQc1MPJCHW9XGbx3_KjizWNBjQbOkM65U6OwJSBM/edit?usp=sharing)

## Использование технологии:
- Spring Boot
- Gradle (Kotlin DSL)
- PostgreSQL
- Spring Data
- Spring Security
- Lombok
- MapStruct
- jsonwebtoken-jjwt

## Развертка
Выполнена с помощью docker compose. Для запуска достаточо ввести:
```
docker compose up
```

## REST API endpoints
### /auth

Регистрация, авторизация, включение и выключение пользователей

### /harvest

Добавление новых записей о сборе

### /product

Добавление новых продуктов, редактирование и получение списка существующих

### /rating

Добавление и просмотр списка записей рейтинга