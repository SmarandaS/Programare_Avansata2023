# ProgramareAvansata2023 - Lab 11 - Sandu Smaranda, 2B3

## Compulsory

--------

- [x] Create a Spring Boot project that will contain the REST services for comunicating with the server data.
- [x] Create a REST controller containing a method for:
  obtaining the list of the registered players, via a HTTP GET request.
- [x] Test your service using the browser and/or Postman.

----------

## Homework

----------

- [ ] Create REST services for:
  adding a new player, via a HTTP POST request.
  modifying the name of a player, via a HTTP PUT request.
  deleting a player, via a HTTP DELETE request.
- [ ] Create a REST service for obtaining the games that were recorded by the server.
- [ ]Create a simple client application that invokes the services above, using the support offered by Spring Boot.
- [ ]Document your services using Swagger or a similar tool.----------

## Bonus

---------

- [ ] Write a service that determines a (minimal?) group of players C such that, if they were to leave the game server, the remaining players would be divided into two groups A and B such that max(|A|,|B|) < 2n/3 (n is the total number of players) and no player in A has ever played with a player in B.
- [ ] Secure this service using JSON Web Tokens.
- [ ] Create a simple desktop application that sends multiple concurrent invocations to the service, in order to determine how many API requests per minute it can handle.
  You may also monitor other performance metrics, using your own implementation or Spring support.
