# Relational Persistence

This is a Java 8 project that implements the following [scenario](doc/scenario.md). All the information is stored in a [MySQL](https://www.mysql.com/) database using SpringData to manage it.

## Database diagram

![DB DIAGRAM](doc/img/diagram.jpg)

Notes:

* ```Mechanic``` and ```Crewmember``` extends from ```Employee```, because both have some attributes in common. **Mapped Superclass** approach has been applied.
* **N:M relationship** between ```Crewmember``` and ```Flight``` has been splitted in two 1:N relationships, using an intermediate table named ```fligth_crewmember``` that stores the relation having as columms:
  * *flight_id*: ID of the flight.
  * *employee_id*: ID of the mechanic.

## Deployment

Before deploy the application, is needed to has available a MySQL and a mongoDb databases, the most easy way is with [docker](https://www.docker.com/) executing the following commands:

```
$ docker run --rm -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -p 3306:3306 -d --name db-mysql mysql/mysql-server:8.0.23
$ docker run --rm -p 27017:27017 -d --name db-mongodb mongo:4.4.3
```

Or you can just execute the provided [docker-compose.yml](docker-compose.yml) file with the command:

```
$ docker-compose up -d
```

Load [Provincias.json](src/main/resources/Provincias.json) provided data in mongoDb database with the command:

```
$ mongoimport --host localhost:27017 --db test --collection provincia --file src/main/resources/Provincias.json
```

If the application is executed many times is needed to drop the database and create it at the end of each execution:

```
drop database test;
create database test;
```

Once MySQL and mongoDb instances are up and running, to show the databases stored information and the result of the requested queries execute:

```
$ mvn spring-boot:run
```

Notes:

* *spring.jpa.hibernate.ddl-auto* property has as value ```create``` so every time that the application will be executed, the information will be stored in the information and it will be available once the execution will be finished. 
* **DTOs (Data Transfer Objects)** has been used to retrieve the result of the requested queries.
* The starting point in order to understand the application is [RelationalPersistenceController](src/main/java/com/cloudapps/relational_persistence/controller/RelationalPersistenceController.java) class. It executes the main three parts of the application:
  * Populate the database.
  * Print database stored information.
  * Execute requested queries and print their result.

## Author

[David Rojo (@david-rojo)](https://github.com/david-rojo)
