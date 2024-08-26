## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Design Patterns](#design-patterns)


## General info
This project is a technical test for Inditex, it consists of a hexagonal architecture application using Spring Boot.

## Technologies
Project is created with:
* Spring Boot: 3.3.3
* JDK: 17
* Maven 3.8.1
* Swagger OpenAPI 3.0

## Setup
To run this project, install it locally using maven commands:

1. Navigate to the project directory:

```
$ cd path/to/project/directory
```

2. Clean the project: 

```
$ mvn clean 
```

3. Compile the project: 

```
$ mvn compile
```

4. Run the tests: 

```
$ mvn test
```
5. Build the project:

```
$ mvn package
```

6. Run the Spring Boot application:

```
$ mvn spring-boot:run
```

#### Here's a shorter version with fewer commands:
1. Navigate to the project directory:

```
$ cd path/to/project/directory
```

2. Clean, compile, and package the project:

```
$ mvn clean package
```

3. Run the Spring Boot application:
```
$ mvn spring-boot:run
```

Once the project is started we can test it by calling the endpoint **GET:/localhost:8080/price?brandId=1&applicationDate=2020-06-15 21.00.00&productId=35455** using an API platform such as Postman.
You can also try the application by entering SwaggerUI: http://localhost:8080/swagger-ui/index.html

## Design Patterns 
* **Hexagonal Pattern**: The hexagonal pattern helps us to have maintainable, scalable and testable code. It is included in
  clean architectures, which separate business logic from infrastructure.
* **Vertical Slice Architecture**: Hexagonal architecture loses scalability and maintainability as the project grows, so we apply vertical slicing. We slice the architecture and within each slice we will have the three layers (infrastructure, application, domain). I have decided to use this pattern to maintain scalability and maintainability as our project grows.
* **Composite Pattern (Composite Key)**: Applying the Composite Pattern to a composite key allows for uniform management of the key components, extensibility of the key structure, and simplification of client code. It’s a useful approach when dealing with complex key structures that require consistent handling and potential future expansion.
* **Adapter Pattern**: In Hexagonal Architecture, the Adapter Pattern is a key tool that allows the core business logic to remain isolated from external systems. Adapters implement the ports defined by the core, translating and bridging the gap between the core's needs and the external systems' specific interfaces. This approach enhances modularity, testability, and maintainability in your application. The key benefits of the Adapter Pattern in Hexagonal Architecture include the decoupling of the application core from its external dependencies, flexibility to integrate new technologies, enhanced testability, improved code maintainability, the ability to reuse business logic in different contexts, and a clearer, more modular architecture. These benefits contribute to creating more robust, adaptable, and maintainable systems in the long term.
* **Builder Pattern**: Lombok's @Builder annotation automatically generates a Builder class that can be used to implement the use of the Builder pattern. The Builder Pattern is ideal in situations where you need to construct complex objects with multiple configuration options, avoid overloaded constructors, improve code readability, ensure object immutability, facilitate validation, and make class evolution easier. By using Builder, you gain more control over the object creation process, which enhances code clarity, flexibility, and maintainability.




