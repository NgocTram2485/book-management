# Book Management

## Overview

Welcome to Book Management! This application does amazing things and is powered by Java and MySQL.

## Prerequisites

Before you start, make sure you have the following installed on your machine:

- [Docker](https://docs.docker.com/get-docker/)
- [Java](https://www.oracle.com/java/technologies/downloads/)

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/NgocTram2485/book-management
```

### 2. Set Up MySQL with Docker
```bash
# Pull the MySQL Docker image
docker pull mysql:latest

# Run MySQL container
docker run --rm -d --name database -p 3306:3306 -e MYSQL_ROOT_PASSWORD=secret mysql:8.0.31 || true

# Create Database
docker exec -it database mysql -u root -psecret -e "CREATE DATABASE book_management;" || true
```

### 3. Initialize database
Please check the [migrations](MIGRATIONS.md).


### 4. Run application
```bash
# Start the application with the provided run.sh script
sh run.sh
```