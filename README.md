# Filmoteca
Proyecto backend para gestionar información sobre películas utilizando Java y MySQL.

## Estructura del Proyecto

```plaintext
backend/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── application/
│   │   │   │   └── services/
│   │   │   │       ├── IPersistencia.java
│   │   │   │       └── PeliculaService.java
│   │   │   ├── domain/
│   │   │   │   └── models/
│   │   │   │       ├── Accion.java
│   │   │   │       ├── Comedia.java
│   │   │   │       ├── Drama.java
│   │   │   │       └── Pelicula.java
│   │   │   └── infrastructure/
│   │   │       └── repository/
│   │   │           └── controllers/
│   │   │               ├── DatabaseConnection.java
│   │   │               ├── DatabaseInitializer.java
│   │   │               └── PeliculaDAO.java
│   │   └── resources/
│   │       └── db/
│   │           └── schema.sql
│   └── webapp/
│       └── WEB-INF/
│           └── index.jsp
├── .gitignore
├── backend.iml
├── pom.xml
├── README.md
└── Main.java

```

### Requisitos:

- Java 7 o superior
- MySQL
- Maven

### Configuración de la Base de Datos

Asegúrate de tener un servidor MySQL en funcionamiento.
Configura la conexión a la base de datos en el archivo src/main/resources/application.properties:

```dtd
# src/main/resources/application.properties
db.url=jdbc:mysql://localhost:3306/
db.username=tu_usuario
db.password=tu_contraseña
```

### Ejecución de Pruebas

El proyecto incluye pruebas unitarias para la clase PeliculaDAO. Las pruebas se encuentran en src/test/java/filmoteca/PeliculaDAOTest.java.
Para ejecutar las pruebas, usa el siguiente comando de Maven:

```dtd
mvn test
```