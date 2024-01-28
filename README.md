# IrvaBank 
Welcome to IrvaBank! This is a SpringBoot project that provides functionalities for controlling transfer operations. Below are important details about the configuration and usage of the project.

## Dependencies
The project IrvaBank utilizes a set of dependencies and technologies, each serving a specific purpose. Here's a description of each:

1) Spring Boot Starter Data JPA (Version: 3.2.2): Provides support for data access using Hibernate.
2) H2 Database (Version: Not specified): In-memory database for development and testing.
3) Spring Boot Starter Validation (Version: 3.2.2): Supports data validation.
4) Spring Boot Starter Web (Version: 3.2.2): Starter for creating web applications with Spring MVC.
5) Lombok (Version: Not specified): Reduces boilerplate code in Java classes, enhancing code conciseness.
6) Spring Boot Starter Test (Version: 3.2.2): Starter for testing in Spring Boot projects.
7) Springdoc OpenAPI (Version: 2.0.3): Enables automatic generation of Swagger documentation for Spring Boot APIs. The specific version 2.0.3 is used for this project.

The project is based on the Spring Boot framework, providing a robust and efficient foundation for building Java applications. Additionally, the project utilizes Maven for dependency management, and the Java version specified is 21.

Overall, these dependencies and technologies contribute to the development of a secure, well-tested, and documented Spring Boot application for the IrvaBank project.

## Project Execution
To run the project, use your favorite IDE or execute the following command in the command line:

bash
```sh
./mvnw spring-boot:run
```
After initialization, the application will be available at http://localhost:8080/.

Note: Make sure to adjust the settings as needed, especially in a production environment. Refer to the official Spring Boot documentation for more details on deployment and advanced configuration.

## Database Access

After running the application, you can access the H2 Database console at http://localhost:8080/h2-console/. The database configurations can be found in the application.properties file and can be edited through environment variables. Example:

properties
```sh
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.h2.console.enabled=true
```

## Swagger Documentation (Springdoc OpenAPI)
The Swagger documentation is available at http://localhost:8080/swagger-ui/index.html after running the application.

![image](https://drive.google.com/uc?export=view&id=1BZ4YgqbR2ikdauoRgtTWQrq7FGsXW17k)

