# Relational Persistence

This is a Java 8 project that implements the following [scenario](doc/scenario.md). All the information is stored in a [MySQL](https://www.mysql.com/) database using SpringData to manage it.

## Deployment

Before deploy the application, is needed to has an available MySQL database, the most easy way is with [docker](https://www.docker.com/) executing the following command:

```
$ docker run --rm -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -p 3306:3306 -d --name relational-persistence mysql:8.0.22
```
