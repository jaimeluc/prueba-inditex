## Table of contents
* [General Info](#general-info)
* [Technologies](#technologies)
* [Libraries](#libraries)
* [Prerequisites](#prerequisites)
* [Setup](#setup)
* [High-Concurrency Management](#high-concurrency-management)
* [Execution](#execution)
* [Design Patterns](#design-patterns)
* [Testing](#testing)
* [Releases](#releases)


## General Info
This project is a technical test for Inditex, it consists of a hexagonal architecture application using Spring Boot.
The application retrieves the final price of a given product filtered by application date, brand identifier and product
identifier.

## Technologies
Project is created with:
* Spring Boot 3.3.3
* JUnit 4.13.2
* Swagger 
* Java 17
* Maven 3.8.1

## Libraries
* Lombok 1.18.20
* Mapstruct 1.5.3.Final

## Prerequisites
You must have installed: 
* OpenJDK 17
* Apache Maven 3.x.x or Maven Bundled in your IDE
* Docker Engine or Docker Desktop (optional)

## Setup
To run this project, there are two methods:

### a. Using maven commands:

1. Navigate to the project directory:

```
cd path/to/project/directory
```

2. Clean the project: 

```
mvn clean 
```

3. Compile the project: 

```
mvn compile
```

4. Run the tests: 

```
mvn test
```
5. Build the project:

```
mvn package
```

6. Run the Spring Boot application:

```
mvn spring-boot:run
```

#### Here's a shorter version with fewer commands:
1. Navigate to the project directory:

```
cd path/to/project/directory
```

2. Clean, compile, and package the project:

```
mvn clean package
```

3. Run the Spring Boot application:
```
mvn spring-boot:run
```

### b. Using Docker

In this case, you must have installed Docker Engine or Docker Desktop in your machine.

1. Navigate to the project directory:

```
cd path/to/project/directory
```

2. Build Docker image: 
```
docker build -t <application-name> .
```

3. Execute Docker container: 
```
docker run -p 8080:8080 <application-name>
```

## High-Concurrency Management 
To prepare this application for high-concurrency management I have used Kubernetes (with the creation of two manifest files in the root 
of the project; [deployment.yml](./deployment.yml) and [service.yml](./service.yml)), this allows us to do a horizontal scaling of applications in an efficient and automated way. Horizontal scaling consists of increasing the number of instances (replicas) of an application to handle larger workloads, instead of increasing the resources (CPU, memory) of a single instance, which would be vertical scaling.

You can **manually scale the application** by changing the number of replicas in [deployment.yml](./deployment.yml) or by using the following
command:
```
kubectl scale deployment inditex-app --replicas=<number_of_replicas>
```
### Automatic Scaling

Kubernetes supports automatic scaling of pods based on metrics such as CPU or memory usage using the Horizontal Pod Autoscaler (HPA).
HPA monitors pod metrics and automatically adjusts the number of replicas to maintain application performance.

To implement this easily we can create a hpa.yml file in the root of our project that would have the following content:

```yaml
apiVersion: autoscaling/v1
kind: HorizontalPodAutoscaler
metadata:
  name: inditex-app-hpa
spec:
  scaleTargetRef:
    apiVersion: apps/v1
    kind: Deployment
    name: inditex-app
minReplicas: 2
maxReplicas: 10
targetCPUUtilizationPercentage: 80
```
This HPA will adjust the number of replicas between 2 and 10, trying to keep the CPU utilization around 80%.

## Execution

Once the project is started we can test it by calling the endpoint. You can try it with an API platform like Postman.

Here’s a brief documentation for that endpoint:

**URI**: /price

**Method**: GET

**Description**: Retrieves the applicable price for a specific product at a given date and time.

**Query Parameters**:

   * brandId (int, required): The ID of the brand making the request.
   * applicationDate (string, required): The date and time for which the price is requested, in yyyy-MM-dd HH:mm:ss format.
   * productId (int, required): The ID of the product for which the price is requested.

**Request Example**:
```
GET /price?brandId=1&applicationDate=2020-06-15 21:00:00&productId=35455
```

**Response**: Returns the applicable price of the product for the specified date and time.


You can also try the application by entering SwaggerUI: http://localhost:8080/swagger-ui/index.html

## Design Patterns 

Below I briefly present and explain the patterns that I have used and the advantages that have led me to choose them:

* **Hexagonal Pattern**: The hexagonal pattern helps us to have maintainable, scalable and testable code. It is included in
  clean architectures, which separate business logic from infrastructure.


* **Vertical Slice Architecture**: Hexagonal architecture loses scalability and maintainability as the project grows, so we apply vertical slicing. We slice the architecture 
 and within each slice we will have the three layers (infrastructure, application, domain). I have decided to use this pattern to maintain scalability and maintainability
 as our project grows.  


* **Composite Pattern (Composite Key)**: Applying the Composite Pattern to a composite key allows for uniform management of the key components, 
 extensibility of the key structure, and simplification of client code. It’s a useful approach when dealing with complex key structures that require 
 consistent handling and potential future expansion.  


* **Adapter Pattern**: In Hexagonal Architecture, the Adapter Pattern is a key tool that allows the core business logic to remain 
 isolated from external systems. Adapters implement the ports defined by the core, translating and bridging the gap between the core's 
 needs and the external systems' specific interfaces. This approach enhances modularity, testability, and maintainability in your application. 
 The key benefits of the Adapter Pattern in Hexagonal Architecture include the decoupling of the application core from its external dependencies, 
 flexibility to integrate new technologies, enhanced testability, improved code maintainability, the ability to reuse business logic in 
 different contexts, and a clearer, more modular architecture. These benefits contribute to creating more robust, adaptable, and maintainable systems in the long term.  


* **Builder Pattern**: Lombok's @Builder annotation automatically generates a Builder class that can be used to implement the use of the Builder pattern.
 The Builder Pattern is ideal in situations where you need to construct complex objects with multiple configuration options, 
 avoid overloaded constructors, improve code readability, ensure object immutability, facilitate validation, and make class 
 evolution easier. By using Builder, you gain more control over the object creation process, which enhances code clarity, flexibility, and maintainability.  


* **Dependency Injection**: In order to ensure the Dependency Inversion Principle, we apply Constructor-based Dependency Injection. 
 It improves modularity, testability, and maintainability of the code by allowing dependencies to be injected from outside rather than being created internally.

  
## Testing

I have developed **integration tests**, they are in the class [PriceAPITests.java](./src/test/java/com/jaimelucas/inditex/prices/infrastructure/inputadapter/http/PriceAPITests.java),
for this I have used JUnit and MockMvc.

I have also included **unit tests**, they are included in the class [PriceDomainTest.java](./src/test/java/com/jaimelucas/inditex/prices/domain/PriceDomainTest.java)

To run the tests we can use the following command: 
```
mvn test
```

**Coverage** reached 85% of the lines of code.

## Releases
* Version 1.0.0 - Initial Release. Released August 28, 2024
* Version 1.0.1 - Minor changes in API documentation and README. Released August 29, 2024
