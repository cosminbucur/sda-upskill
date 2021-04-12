# Final project

Scenario - WeatherLady

## Brief description of the system

As part of the project, a system should be created to collect data from one or preferably two weather services and
provide the average (the result should be a given weather value calculated as the arithmetic average of the results
returned by each service) values calculated on the basis of the responses returned. The system should be constructed
using two microservices:

microservice #1 - which will be responsible for fetching the data from external services

microservice #2 - which will be responsible for calculating weather metrics based on the microservice #1 responses

## Main system functions

- Downloading weather data from relevant web services
- Downloaded data should be saved to the database
- The application should use the city date and location to retrieve average values
- Average results should be saved in the database
- (Optional) access to the system should be limited to the authenticated and authorized users only

## Technologies

- Spring framework including: web, jpa, security
- Rest template for network communication
- JDBC or Hibernate
- Domain logic divided into layers, e.g. Repository, Service, Web
- JSON data serialization/deserialization tool, eg Gson, Jackson
- Unit testing tools

## Functionalities

### API

The user should be able to use one of the following endpoint:

- fetching weather values
- adding specific locations to the database
- displaying currently added locations

### Fetching weather data

Fetching weather data from external services Under this endpoint, the user should be able to fetch data from e.g. the
following systems:

https://weatherstack.com/documentation
https://openweathermap.org/api

### Supported parameters

One of the microservices should be responsible for retrieving the following values:

- temperature
- pressure
- humidity
- wind direction and speed

Values taken from external websites should be saved additionally to the database before being returned as a response.
Before requesting the data to external services, the local database should be checked if the data already exists.

The second microservice should be responsible for retrieving the data based on the another microservice and should
calculate average weather metrics based on algorithms. Results should be saved in the database as well. As a response
calculated values should be returned.

### Available download configurations

The user can indicate the following values via the application:

### DATE

The request may indicate the date on which the weather is to be checked. If the user does not enter the date in the
agreed format, the weather for tomorrow should be checked.

### LOCATION

The request may indicate the location for which the values should be returned. The location should be able to be
communicated as city name or a geographic coordinate. Before using it, the location should be saved in the database.

### (Optional) Security

Only authenticated and authorized users should be able to use the created web service. Please choose any authentication
mechanism like for example JWT.

---

## Optional functionalities

### Adding a location

- The user should be able to add a location to the database by entering the following values as a request body:

- id
- longitude and latitude
- region
- country name

Additionally, as part of the task, the user should ensure appropriate validation:

- id - optional: UUID format
- longitude and latitude according to geographical values (latitude: -90 -> S, 90 -> N, longitude: -180 -> W, 180 -> E)
- city name - cannot be empty
- region - optional: may be null
- country name - cannot be empty If incorrect data are entered, the appropriate response should be returned.

### Display of available locations

By selecting the menu option, the user should be able to request all available locations entered into the database.

### Config web service

Create a separate web service which will be responsible for delivering 3rd party api keys which are necessary for the
external services. During the request the main REST API, proper external service config should be fetched from another
microservice. Please ensure a safe communication approach with created config web service.

## Edit location

As part of the new endpoint, the user should be able to edit the currently added locations. Validation should also be
included in the edit.

## Location search

The user should be able to find information about a specific location by searching for it, e.g. by name.

## Statistic data

The user should be able to request statistical data on selected weather values from a specific time period, e.g. month,
year. Data for this purpose should be fetched directly from the database.

## Unit tests

The implemented functionalities should be covered with unit tests in accordance with commonly used methodologies and
practices.

## Additional requirements

The program should meet the following criteria:

- functionality
- code quality (transparency, maintainability, structure)
- use of the latest technologies (at least the latest stable version of JDK, the latest stable versions of libraries)
- user experience
- reliability

The task is formulated very generally on purpose. If something is not specified, it can be implemented in a way that is
convenient for you. There are no preferred solutions or technologies other than those listed.