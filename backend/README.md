# The Best Matched Restaurants Application

### What is it?

The Best Matched Restaurants application is a comprehensive solution that allows users to search for the best restaurants based on their criteria. It consists of a backend built with Spring Boot and a frontend built with React and TypeScript. The application adheres to clean architecture principles and leverages hexagonal architecture (ports and adapters) for a well-structured and maintainable codebase.

### Features

- Search for restaurants by name, rating, price, distance, and cuisine type.
- Display the 5 best-matched restaurants based on the specified criteria.
- User-friendly interface for easy navigation and input.

### Technology Stack

- Programming Language: Java (backend), TypeScript (frontend)
- Framework: Spring Boot (backend), React (frontend)
- Architecture: Clean Architecture, Hexagonal Architecture (Ports and Adapters)

### Installation

#### Prerequisites:

- Java 11 or higher (for the backend)
- Node.js and npm (for the frontend)
- Maven (Optional, for backend)

#### Backend Setup

1. Clone the project repository.
2. Open a terminal and navigate to the `backend` directory.
3. Run the following command to build and run the application:

##### Option 1: With Maven Installed

```bash
mvn spring-boot:run
```

##### Option 2: Without Maven

```bash
./mvnw spring-boot:run
```

### Frontend Setup

1. Open a terminal and navigate to the `frontend` directory.
2. Install the necessary dependencies by running:

```bash
npm install
```

3. Start the React application with:

```bash
npm run start
```
### Running Tests

#### Backend Tests

1. Navigate to the `backend` directory in your terminal.
2. Run the following command to execute unit and integration tests:

##### Option 1: With Maven Installed

```bash
mvn test
```

##### Option 2: Without Maven

```bash
./mvnw test
```

#### Frontend Tests

1. Navigate to the `frontend` directory in your terminal.
2. Run the following command to execute tests:

```bash
npm run test
```

### Architecture Overview

The application follows clean architecture principles, separating business logic from external dependencies and concerns. It also employs hexagonal architecture, defining clear ports (interfaces) for application interactions and implementing adapters to connect to external systems. This modular approach promotes code reusability, testability, and maintainability.

#### Backend

- Hexagonal Architecture: The backend is structured to separate the business logic from the presentation layer (API and CLI). This allows for multiple interfaces, such as a CLI and a REST API, to serve the same core functionality without being tightly coupled. Running the backend server will start the CLI application and simultaneously provide an API route to achieve the same functionality as the CLI, made possible by the reusable components thanks to the hexagonal architecture.

#### Frontend

- Hexagonal Architecture in Frontend: The frontend is built with React and TypeScript, utilizing hexagonal architecture to separate concerns and make it easy to swap out libraries or frameworks in the future. This includes replacing request libraries (like axios or fetch) without impacting the business logic.

### Running the Full Application

To run the full application, follow these steps:

- Open a terminal and navigate to the backend directory.
- Start the backend server using Maven or the Maven Wrapper.

1) Start the Backend

```bash
cd backend
mvn spring-boot:run
```

Or without Maven:

```bash
cd backend
./mvnw spring-boot:run
```

2) Start the Frontend:

- Open a new terminal and navigate to the frontend directory.
- Start the React application.

```bash
cd frontend
npm install
npm run start
```





