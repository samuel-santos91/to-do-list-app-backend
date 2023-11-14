# to-do-list-app-backend

## Description
* This Spring Boot backend application serves as the backend for a to-do list app. 
* It provides RESTful APIs to manage tasks and integrates with a front-end interface.
### Purpose
* The purpose of this project was to practice building a backend with Spring Boot

## Features 
 - RESTful API for task management (CRUD operations);
 - Database integration (e.g., MySQL, PostgreSQL) for persistent data storage;
 - Error handling.

## Getting Started
### Prerequisites
 - Java Development Kit (JDK) 8 or higher installed;
 - Eclipse IDE or any Java development environment;
 - MySQL, PostgreSQL, or your preferred database.

### Installation
 - Clone this repository;
 - Import project into your IDE;
 - Configure the database connection application.properties;
 - Configure cors in WebConfig.java;
 - Run the application.

### Usage
 - Use your front-end interface to interact with the backend API.

### API Endpoints
 - GET /url/tasks: Retrieve all tasks.
 - GET /url/tasks/{taskId}: Retrieve a specific task by ID.
 - POST /url/tasks: Create a new task.
 - PATCH /url/tasks/{taskId}: Update a task.
 - DELETE /url/tasks/{taskId}: Delete a task.

