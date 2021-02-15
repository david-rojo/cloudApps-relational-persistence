# Relational Persistence scenario

The starting point of this practice is the previous scenario, related to a flights and airplanes managemente application. Description about the information to store in database is the following:

* *Airplane:* registration code (String type), manufacturer, model and flown hours.
* *Airport:* IATA code (is a 3 letter value but a String type can be used), name, city and country.
* *Crew member:* employee code (String type), name, surnames, position (pilot, co-pilot, flight attendant,...) and name of the company he works.
* *Flight:* flight code, company, airplane of the flight, departure and arrival airports, departure date and time, duration (hours as not integer value). Also is request to store the flight crew.
* *Responsible Mechanic of the Revision:* employeeCode (String type), name, surnames, enterprise name, incorporation year to enterprise and previous formation (University degree, Master degre...)
* *Revision:* revised airplane, start date, end date, number of hours spent, responsible mechanic of the revision, revision type (annual, monthly,...), description of done job and the airport where revision took place.

It is requested the implementation of next requirements with Java and Spring Data (Java 8) using a MySQL database. To facilitate the development of the practice, *the practice 1 code can be used as starting point.*

## Evolution

The use of [Flyway](https://flywaydb.org/) in the application is requested, taking in account that creation of the tables and the data insertion will be done in version 1 of the database. So DataLoader, don't insert any data.

## Hybrid Database

It is requested the inclusion of two JSON attributes and also data migration to these fields in two different entities. These transformations will be done with a Flyway script, migrating the database to version 2. Any data or field won't be deleted.

Taking in account that information about crew is variable because every flight can has different number of crew members, it is requested to create a new JSON field that stores the IDs of the crew members in the entity that represent the flights information.

Also is requested to transform the revisions information moving this information to a new JSON field in Airplane entity.

Based in the result of the evolution, it is requested to implement following queries, showing their result in DataLoader:

* Per each plane, show name and surnames of the mechanics responsible of its revisions.
* For each crew member, show his name and surnames with its total number of flights and the sum of hours of these flights.

To solve this section next functions can be used: JSON_OBJECT, JSON_ARRAYAGG and JSON_TABLE

## Aggregate Framework

To work with mongoDb aggregation framework it is requested to include in the practice a conexion with mongoDb, transforming the application persistence layer into a polyglot layer. In this case, although is not related with previous sections, it is requested to add the provinces data json file [provincias.json](src/main/resources/Provincias.json) provided. In order to correct the scenario, the collection must be named ```provincia``` and the connection details must be:

```
spring.data.mongodb.host=localhost
spring.data.mongodb.port=27017
spring.data.mongodb.database=test
```

Also is requested to implement following queries, that their result must be shown in DataLoader:

* List the data of all provinces.
* List showing, per each autonomous community, its number of provinces (Ceuta and Melilla are considered as members of autonomous community "without community").
