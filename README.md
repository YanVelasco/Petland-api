# Petland API

## Overview
The Petland API is a Java-based application developed using the Spring Boot framework. It provides a platform for managing pet services, including pet registration, customer services, and product management.

## Technologies
- Java: The programming language used to develop the application.
- Spring Boot: A framework that simplifies the setup and development of Spring applications.
- Maven: A project management and comprehension tool used for managing project builds.
- JPA/Hibernate: Used for mapping Java objects to database records.
- PostgreSQL: The database management system used to store the application's data.

## Features
- **Pet Registration**: Allows for the registration of pets with details such as name, date of birth, and species. Pets are registered with a unique ID for easy identification and management.
- **Customer Services**: Allows for the registration of customer services, including the type of service, status, description, date and time realized, whether it's an emergency, the associated registration entity, the service entity, and the patient animal entity.
- **Product Management**: Allows for the management of products available for sale. Each product is registered with a unique ID and can be associated with one or more customer services.

## Running the Application
1. Clone the repository to your local machine using the git clone command.
2. Navigate to the project directory using the cd command.
3. Run the command `mvn spring-boot:run` to start the application.
4. The application will be available at http://localhost:8080.

## API Endpoints
- **/animal**: Endpoint for managing pet registration. Supports GET, POST, PUT, and DELETE operations.
- **/customerservice**: Endpoint for managing customer services. Supports GET, POST, PUT, and DELETE operations.
- **/product**: Endpoint for managing products. Supports GET, POST, PUT, and DELETE operations.

## Database Schema
The application uses three main entities: `AnimalEntity`, `CustomerServiceEntity`, and `ProductEntity`.

- **AnimalEntity**: Represents the pets in the system. Each pet has a unique ID, name, date of birth, species, and a `RegistrationEntity`.
- **CustomerServiceEntity**: Represents the customer services in the system. Each service has a unique ID, type, status, description, date and time realized, a boolean indicating whether it's an emergency, a `RegistrationEntity`, a `ProductEntity`, an `AnimalEntity`, and a value.
- **ProductEntity**: Represents the products in the system. Each product has a unique ID, name, description, price, and a `RegistrationEntity`.

## Contributing
Contributions are welcome. Please fork the project and create a Pull Request. Make sure your changes pass all tests before submitting the Pull Request.

## License
This project is licensed under the MIT license. This means you can copy, modify, distribute, and even sell the software, as long as you include the original license in any copies of the software you distribute.