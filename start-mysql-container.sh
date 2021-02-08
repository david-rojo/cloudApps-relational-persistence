#!/bin/sh

docker run --rm -e MYSQL_ROOT_HOST=% -e MYSQL_ROOT_PASSWORD=password -e MYSQL_DATABASE=test -p 3306:3306 -d --name relational-persistence mysql/mysql-server:8.0.23