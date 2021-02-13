#!/bin/sh

mongoimport --host localhost:27017 --db test --collection provincia --file src/main/resources/Provincias.json