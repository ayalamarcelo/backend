<h1 align="center">Movie Hub</h1>

<p>This project is a backend application developed in Java using Servlet, Apache Tomcat and MySQL. The purpose of the project is to provide an API for managing movies, including CRUD operations with Postman.</p>


## Project Structure
```
backend/
├── .idea/
├── cmarttomcat/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── org/
│   │   │   │   ├── application.services/
│   │   │   │   │   ├── adapters
│   │   │   │   │   │     └── IRepository
│   │   │   │   │   └── services
│   │   │   │   │         └── IRepository
│   │   │   │   ├── domain.models/
│   │   │   │   │   └── MovieService.java
│   │   │   │   │  
│   │   │   │   ├── infrastructure.repository/
│   │   │   │   │   ├── controllers/
│   │   │   │   │   │   └── MovieController.java
│   │   │   │   │   └── database
│   │   │   │   │       ├── DatabaseConnection.java
│   │   │   │   │       └── MySqlRepositoryImpl.java
│   │   │   │   │       
│   │   └── resources/
│   │        └── movies_db.sql
│   │           
│   └── webapp/
│       └── WEB-INF/
│            └── index.jsp
├── .gitignore
├── backend.iml
├── pom.xml
└── README.md
```

### Requirements

- [x] JDK 17
- [x] Apache Tomcat 9.0
- [x] MySQL
- [x] Maven

### Environment Configuration
#### Database

1. Create a database in MySQL (Copy the one from the resource folder)
2. Clone repository (It is recommended to do a FORK)
3. Configure Apache Tomcat to deploy the application.

> [!TIP]
> Change port in Apache Tomcat

```dtd
Connector port=”8090″ protocol=”HTTP/1.1″ connectionTimeout=”20000″ redirectPort=”8443″
```

### Use
#### Deploy the application to Apache Tomcat.
##### Endpoints:

* GET /movies/{id}: Gets a movie by ID.
* POST /movies Create a new movie.
* PUT /movies/{id}: Update an existing movie.
* DELETE /movies/{id}: Delete a movie by ID.

> [!TIP]
> For PUTs on postman: 
> 1. Select: Body
> 2. Select: Rows
> 3. Paste a JSON on rows:
> 4. {
     "id":1,
     "title":"The Lord of the Rings",
     "director": "Peter Jackson",
     "genre": "Fantasy"
     }

