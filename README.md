spring-reactive-mongodb
=========================
Demo project for Spring Boot(Spring 5), Reactive Web and Reactive Data MongoDB

Prerequisites
-------------
- Java 1.8
- MongoDB installed

Reactive Web
------------
[Spring-webflux](https://docs.spring.io/spring-framework/docs/5.0.x/spring-framework-reference/web-reactive.html#webflux) alongside with [Reactor Netty](http://projectreactor.io/) and [Reactive-Stream](http://www.reactive-streams.org/) enabling reactive capabilities to the entire stack:
- Non-Blocking network operations on the jvm
- Support for asynchronous stream processing with non-blocking backpressure

Reactive Data Mongo
-------------------
Providing interface to interact with Spring Data Mongo in a reactive way, here we're using:
- **ReactiveMongoRepository** in lieu of MongoRepository
- **ReactiveMongoTemplate** and not MongoTemplate as before Spring 5
- **EnableReactiveMongoRepositories** instead of EnableMongoRepositories
- **AbstractReactiveMongoConfiguration** and not AbstractMongoConfiguration

Tasks list
----------
- [x] Core files with spring-boot
- [x] MongoDB configurations
- [x] Article's Model, Repository and Service
- [ ] Article's CRUD operations
- [ ] Build a reactive API + test for the Article model

Run
---
1. Start mongod process
2. ```./mvnw clean install```
3. ```./mvnw spring-boot:run```