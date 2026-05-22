# Car Search Engine — Backend

Full-stack vehicle search application — Java/Spring Boot REST API backed by PostgreSQL, deployed on AWS via Docker.

Final-sprint team project for the Keyin College Software Development diploma program (2024).

## Stack

- **Language:** Java 17
- **Framework:** Spring Boot, Spring Security
- **Database:** PostgreSQL
- **Deployment:** AWS Elastic Beanstalk, Docker
- **Build:** Maven

## Features

- User authentication with protected endpoints
- Secure data retrieval and session handling
- Criteria-based vehicle search backed by an optimized PostgreSQL schema
- Containerized deployment via Docker for consistent runtime environments

## Project structure

```
src/main/java/    Spring Boot application
src/main/resources/    Configuration and templates
pom.xml    Maven build configuration
Dockerfile    Container build
Dockerrun.aws.json    AWS Elastic Beanstalk deployment descriptor
```

## Run locally

Requires a running PostgreSQL instance and a configured `application.properties` (or environment variables) with database credentials.

```bash
./mvnw spring-boot:run
```

## Team

Two-person team project — Keyin College Final Sprint, 2024.
