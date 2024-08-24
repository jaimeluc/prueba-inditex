## Table of contents
* [General info](#general-info)
* [Technologies](#technologies)
* [Setup](#setup)
* [Patterns](#patterns)

## General info
This project is a technical test for Inditex, it consists of a hexagonal architecture using Spring Boot.

## Technologies
Project is created with:
* Spring Boot: 3.3.3
* JDK: 17

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

## Patterns 
* Vertical Slice Architecture
* Hexagonal Pattern
* Composite Pattern (Composite Key)
* Adapter Pattern

