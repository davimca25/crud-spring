## User Management API

This is a RESTful API developed with Java and Spring Boot, designed for efficient user management with a focus on security and clean architecture.
 Technologies

    Java 17+

    Spring Boot 3

    Spring Security (with JWT Authentication)

    Spring Data JPA (for database persistence)

    Bean Validation (for input data integrity)

    PostgreSQL

    MapStruct (for object mapping)

    Maven

  ## Features

    Authentication: Secure login and authorization using JWT (JSON Web Tokens).

    DTO Pattern: Use of Data Transfer Objects to ensure robust communication between the API and the client, separating the internal entity structure from the external response.

    Efficient Mapping: MapStruct implementation to handle entity-to-DTO conversion with high performance.

    Persistence: Data storage using PostgreSQL for reliability.

 ## Testing
 The project uses **JUnit 5** and **H2 Database** for automated tests. This allows for fast, isolated testing of the repository layer and service logic without the need for a persistent database during the build process.

 ## How to Run

    Clone this repository:
    git clone https://github.com/USERNAME/auth-api-spring.git

    Configure your database settings in src/main/resources/application.properties.

    Set the secret environment variable for JWT in your IDE (Run > Edit Configurations > Environment variables).

    Run the project:
    mvn spring-boot:run

 ## Security Practices

    Environment Variables: Sensitive data, such as the JWT secret key, is managed via environment variables to avoid hardcoding secrets in the source code.

    Principle of Least Privilege: Implementation of proper security filters and route protection.
