# Relational Persistence scenario (pending to update with P2 scenario)

It is requested to implement the persistence layer for a airplane maintenance application. In particular, it will be taken in account airplanes, flights, crew members, airports, mechanics and the revisions done to each airplane.

Implementation will be done with Java and Spring Data (Java 8) using a MySQL database.

Database will manage the following entities, with the specified data for each other:

* *Airplane:* registration code (String type), manufacturer, model and flown hours.
* *Airport:* IATA code (is a 3 letter value but a String type can be used), name, city and country.
* *Crew member:* employee code (String type), name, surnames, position (pilot, co-pilot, flight attendant,...) and name of the company he works.
* *Flight:* flight code, company, airplane of the flight, departure and arrival airports, departure date and time, duration (hours as not integer value). Also is request to store the flight crew.
* *Responsible Mechanic of the Revision:* employeeCode (String type), name, surnames, enterprise name, incorporation year to enterprise and previous formation (University degree, Master degre...)
* *Revision:* revised airplane, start date, end date, number of hours spent, responsible mechanic of the revision, revision type (annual, monthly,...), description of done job and the airport where revision took place.

## Structure

It is requested to create needed entities that model this proposed scenario and also populate database with test information. Is needed to provide the code that show the proper information storage.

## Queries

Taking in account previous described scenario, is requested to implement the following queries, showing the result of their execution by console. All queries must return some result:

* Per each plane, show name and surnames of the mechanics responsible of its revisions.
* Given the name of a city and a date, retrieve the flights that have landed (arrival) in the airports of its city in this date, ordered by time.
* Given the employee code of a crew member, show his name, surnames and the cities where he has taken off with the take off date.
* For each crew member, show his name and surnames with its total number of flights and the sum of hours of these flights.
