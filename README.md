<h1 align="center">Proyecto Backend</h1>

<p>Este proyecto es una aplicación backend desarrollada en Java utilizando Servlet, Apache Tomcat y MySQL. 
El propósito del proyecto es proporcionar una API para gestionar películas, que incluye operaciones CRUD con Postman.</p>


## Estructura del proyecto
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
│   │   │   │   │   └── PeliculaService.java
│   │   │   │   │  
│   │   │   │   ├── infrastructure.repository/
│   │   │   │   │   ├── controllers/
│   │   │   │   │   │   └── PeliculaController.java
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

### Requisitos

- [x] JDK 17
- [x] Apache Tomcat 9.0
- [x] MySQL
- [x] Maven

### Configuración del Entorno
##### Base de Datos

 1. Crear una base de datos en MySQL(Copiar la de la carpeta resources)
 2. Clonar repositorio (Se recomienda hacer un FORK)
 3. Configurar Apache Tomcat para desplegar la aplicación.

> [!TIP]
> Cambiar puerto en Apache Tomcat

```dtd
Connector port=”8090″ protocol=”HTTP/1.1″ connectionTimeout=”20000″ redirectPort=”8443″
```


### Uso
#### Desplegar la aplicación en Apache Tomcat.
##### Endpoints:

* GET /peliculas/{id}: Obtiene una película por ID.
* POST /peliculas Crea una nueva película.
* PUT /peliculas/{id}: Actualiza una película existente.
* DELETE /peliculas/{id}: Elimina una película por ID.
