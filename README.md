# Relational Persistence

This is a Java 8 project that implements the following [scenario](doc/scenario.md). All the information is stored in a [MySQL](https://www.mysql.com/) database using SpringData to manage it.

## Database diagram

![DB DIAGRAM](doc/img/diagram.jpg)

Notes:

* ```Mechanic``` and ```Crewmember``` extends from ```Employee```, because both have some attributes in common.
* N:M relationship between ```Crewmember``` and ```Flight``` has been splitted in two 1:N relationship, using an intermediate table named ```fligth_crewmember``` that stores the relation having as columms:
  * *flight_id*: ID of the flight.
  * *employee_id*: ID of the mechanic.

## Deployment

Before deploy the application, is needed to has an available MySQL database, the most easy way is with [docker](https://www.docker.com/) executing the following command:

```
$ docker run --rm -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -p 3306:3306 -d --name relational-persistence mysql/mysql-server:8.0.23
```
