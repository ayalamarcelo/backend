# Filmoteca
Proyecto backend para gestionar información sobre películas utilizando Java y MySQL.

## Estructura del Proyecto

```plaintext
filmoteca/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── filmoteca/
│   │   │       ├── Main.java
│   │   │       ├── database/
│   │   │       │   ├── DatabaseConnection.java
│   │   │       │   ├── PeliculaDAO.java
│   │   │       │   └── DatabaseInitializer.java
│   │   │       ├── domain/
│   │   │       │   └── models/
│   │   │       │       ├── Pelicula.java
│   │   │       │       ├── Accion.java
│   │   │       │       ├── Comedia.java
│   │   │       │       └── Drama.java
│   │   │       └── services/
│   │   │           └── PeliculaService.java
│   │   └── resources/
│   │       ├── application.properties
│   │       └── db/
│   │           └── schema.sql
│   └── test/
│       └── java/
│           └── filmoteca/
│               └── PeliculaDAOTest.java
├── pom.xml
└── README.md
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
db.url=jdbc:mysql://localhost:3306/filmoteca
db.username=tu_usuario
db.password=tu_contraseña
```

### Ejecución de Pruebas

El proyecto incluye pruebas unitarias para la clase PeliculaDAO. Las pruebas se encuentran en src/test/java/filmoteca/PeliculaDAOTest.java.
Para ejecutar las pruebas, usa el siguiente comando de Maven:

```dtd
mvn test
```