# The Best Matched Restaurants CLI

### What is it?

The Best Matched Restaurants CLI is a command-line application that allows users to search for the best restaurants based on their criteria. It utilizes Spring Boot, a popular Java framework for building RESTful APIs and microservices, to provide a user-friendly CLI interface. The application adheres to clean architecture principles and leverages hexagonal architecture (ports and adapters) for a well-structured and maintainable codebase.

### Features

- Search for restaurants by name, rating, price, distance, and cuisine type.
- Display the 5 best-matched restaurants based on the specified criteria.
- User-friendly interface for easy navigation and input.

### Technology Stack

- Programming Language: Java
- Framework: Spring Boot
- Architecture: Clean Architecture, Hexagonal Architecture (Ports and Adapters)

### Installation

#### Prerequisites:

- Java 11 or higher
- Maven (Optional)

#### Option 1: With Maven Installed

1. Clone the project repository.
2. Open a terminal and navigate to the project directory.
3. Run the following command to build and run the application:

```Bash
mvn spring-boot:run
```

#### Option 2: Without Maven 

1. Clone the project repository.
2. Open a terminal and navigate to the project directory.
3. Run the following command to build and run the application:

```Bash
./mvnw spring-boot:run
```

### Running Tests

#### Option 1: With Maven Installed

1. Ensure you have Maven installed.
2. Navigate to the project directory in your terminal.
3. Run the following command to execute unit and integration tests:

```Bash
mvn test
```

#### Option 2: Without Maven

1. Open a terminal and navigate to the project directory.
2. Run the following command to execute unit and integration tests:

```Bash
./mvnw test
```

### Architecture Overview
The application follows clean architecture principles, separating business logic from external dependencies and concerns. It also employs hexagonal architecture, defining clear ports (interfaces) for application interactions and implementing adapters to connect to external systems. This modular approach promotes code reusability, testability, and maintainability.

### Contributions
We welcome contributions from the community. Feel free to fork the repository, suggest improvements, and submit pull requests.
