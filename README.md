# Spring Boot Rest API with File Upload and CRUD Operations

This repository contains a simple Spring Boot application that serves as a REST API for managing student data and allows file uploads. The application provides endpoints for performing CRUD operations on student records and uploading files.

## Table of Contents

1. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Installation](#installation)
2. [Project Structure](#project-structure)
3. [Usage](#usage)
   - [Running the Application](#running-the-application)
   - [Endpoints](#endpoints)
4. [File Upload](#file-upload)
5. [CRUD Operations](#crud-operations)
6. [Contributing](#contributing)
7. [License](#license)

## Getting Started

### Prerequisites

- Java JDK 8 or higher
- Maven
- Git

### Installation

1. Clone the repository:

   ```bash
   git clone https://github.com/your-username/boot-rest-api.git
   ```

2. Navigate to the project directory:

   ```bash
   cd boot-rest-api
   ```

3. Build the project:

   ```bash
   mvn clean install
   ```

## Project Structure

The project structure is organized as follows:

- **`src/main/java/com/bootapi/bootrestapi`**: Contains the main application files.
  - **`BootRestApiApplication.java`**: Main class to run the Spring Boot application.
  - **`controller`**: Contains controllers for handling HTTP requests.
    - **`FileController.java`**: Handles file upload requests.
    - **`PageController.java`**: Manages CRUD operations for student data.
  - **`entities`**: Defines the data entities, e.g., `Student` and `Address`.
  - **`helper`**: Contains utility classes, e.g., `UploadData` for file upload.
  - **`service`**: Provides service classes, e.g., `StudentService` for business logic.
  - **`dao`**: Data access objects, e.g., `StudentRepo` for database interaction.

- **`src/main/resources`**: Contains application properties and static resources.
  - **`static/image`**: Default directory for storing uploaded files.

## Usage

### Running the Application

Run the Spring Boot application using the following command:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

### Endpoints

- File Upload: `POST /upload`
- CRUD Operations:
  - Get All Students: `GET /student`
  - Get Student by ID: `GET /student/{id}`
  - Add Student: `POST /student`
  - Delete Student: `DELETE /student/{id}`
  - Update Student: `PUT /student/{id}`

## File Upload

To upload a file, send a `POST` request to `/upload` with the file attached as a form parameter named "file". Successful uploads will return a response with "File Uploaded Successfully." 

Example using cURL:

```bash
curl -X POST -F "file=@/path/to/your/file.jpg" http://localhost:8080/upload
```

## CRUD Operations

The CRUD endpoints allow you to interact with student data. Use tools like Postman or cURL to make HTTP requests.

Examples:
- Get all students: `GET http://localhost:8080/student`
- Get student by ID: `GET http://localhost:8080/student/{id}`
- Add new student: `POST http://localhost:8080/student`
- Delete student by ID: `DELETE http://localhost:8080/student/{id}`
- Update student by ID: `PUT http://localhost:8080/student/{id}`

## Contributing

Feel free to contribute by opening issues or submitting pull requests. Follow the [CONTRIBUTING.md](CONTRIBUTING.md) guidelines.

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.