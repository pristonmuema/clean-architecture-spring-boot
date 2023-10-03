# Clean Architecture with Spring Boot

Welcome to the PristonIT! This project demonstrates how we can archive clean architecture with Spring boot 
using Spring Boot 3, Spring Data JPA, and OpenAPI (Swagger) for API documentation.
I have utilized the power of Java 17 to build this project.



<p align="center">
     <a alt="Java">
        <img src="https://img.shields.io/badge/Java-v17-blue.svg" />
    </a>
    <a alt="Spring Boot">
        <img src="https://img.shields.io/badge/Spring%20Boot-v3.1.4-brightgreen.svg" />
    </a>
    <a alt="Maven">
        <img src="https://img.shields.io/badge/Maven-v3.x.x-lightgreen.svg" />
    </a>
    <a alt="MySQL">
        <img src="https://img.shields.io/badge/mysql-%2300f.svg?style=for-the-badge&logo=mysql&logoColor=white" />
    </a>
    
</p>

## Table of Contents

- [Key Features](#key-features)
- [Project Structure](#project-structure)
- [API Usage (Swagger UI Documentation)](#api-usage-swagger-ui-documentation)
- [Authors](#authors)

## Key Features:

- **Java 17**: Leveraging this LTS version of Java, improving readability and efficiency.
- **Spring Boot 3**: An upgraded version of Spring Boot, enhancing developer productivity with its auto-configuration
  feature. Generated using [Spring Initializr](https://start.spring.io/#!type=gradle-project&language=java&platformVersion=3.1.1&packaging=jar&jvmVersion=17&groupId=me.dio&artifactId=spring-boot-3-rest-api-template&name=spring-boot-3-rest-api-template&description=DIO%20Spring%20Boot%20RESTful%20API%20Template&packageName=me.dio&dependencies=web,data-jpa,h2,postgresql).
- **Spring Data JPA**: Simplifying the database access layer by reducing the boilerplate code.
- **OpenAPI (Swagger)**: Integrated with OpenAPI 3, enabling seamless API documentation for better understanding and
  testing.

## Project Structure:


The project is organized into several packages, each serving a specific purpose:
It is inspired by Uncle Bob's view on [Clean Architecture](https://blog.cleancoder.com/uncle-bob/2012/08/13/the-clean-architecture.html)

<p align="center">
  <img src="./assets/CleanArchitecture.jpg" alt="clean architecture diagram" />
</p>

*The Dependency rule*

It states that dependencies should always point inward toward the core of the application.

The goal of the Dependency Rule is to maintain a clear separation of concerns and ensure that the core business logic remains decoupled from external concerns. This makes the application more testable, adaptable to changes, and easier to maintain over time.

**My take on clean architecture package layering**

- `domain`: Where our entities are defined, using JPA (Jakarta) annotations for ORM with our SQL database.
  This is the inner layer that encapsulates Enterprise wide business rules.

- `application`: This package houses two packages which contains application specific business rules
  - `services`: Where all application services (Interfaces)
    are defined
  - `usecases`: Where all application use cases are defined


- `infra`: This is the outer layer of our application. It hosts all external services
  - `gateways`: Manages and routes requests between different microservices as well as facilitating
    communication between applications using different messaging protocols
    - `http`:
      - `clients`: Where all external http services resides
      - `controllers`: Where all APIs for the application are exposed
      - `models`: This defines all API pojos
    - `messaging`: Where all messaging protocols resides
      - `kafka`:
      - `mqtt`:
      - `rabbitMq`
  - `repository`: In this package, we handle data access using interfaces provided by Spring Data JPA.

- `utils`: Where our global utility helper classes resides.

- `CleanServiceApplication.java`: This is the main class to run our project. It initializes our Spring application and connects all the components together.


## API Usage (Swagger UI Documentation)

The API documentation can be found on Swagger UI. To view it, please visit: [Swagger UI](http://localhost:8080/swagger-ui.html).

## Contribution

I welcome contributions! If you encounter any issues or have suggestions for improvements,
don't hesitate to open an issue or submit a pull request.


## Authors

<table>
  <tr>
    <td align="center"><a href="https://github.com/pristonmuema"><img src="https://avatars.githubusercontent.com/u/35369901?v=4" width="100px;" alt=""/><br/><strong>Priston Muema</strong></a><br/><a href="https://www.linkedin.com/in/pristonmuema/">LinkedIn</a></td>
  </tr>
</table>
