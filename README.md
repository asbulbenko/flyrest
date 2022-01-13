# flyrest
Project REST api app using Kotlin + SpringBoot + JPA + Flyway 


In Spring Initilzr page i have select
- Spring WEB
- Spring Data JPA
- Spring Dev Tools
- Flyway Migration
- MySQL Driver

I've wrapped app and DB into docker-compose, for easier launch (Docker should be up and running).
Navigate to the project folder in Terminal window and run `docker-compose up`

DB has Tasks table with populated entries during start-up

Following REST calls could be used:
- GET 

 `curl "http://localhost:8080/api/v1/tasks"`

 `curl "http://localhost:8080/api/v1/tasks/1"`

 `curl "http://localhost:8080/api/v1/tasks/title/Second Task"`

- POST

`curl --location --request POST 'http://localhost:8080/api/v1/tasks/' 
--header 'Content-Type: application/json' 
--data-raw '{
    "title": "Additional created task",
    "status": 1,
    "priority": 1,
    "description": "1111 task"
}'`

- PUT 

`curl --location --request PUT 'http://localhost:8080/api/v1/tasks/2' 
--header 'Content-Type: application/json' 
--data-raw '{
    "title": "blah blah task",
    "status": 1,
    "priority": 3,
    "description": "blah task"
}'`

- DELETE

`curl -X DELETE "http://localhost:8080/api/v1/tasks/1"`

