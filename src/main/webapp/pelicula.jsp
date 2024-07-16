<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Detalles de la Película</title>
</head>
<body>
    <h1>Detalles de la Película</h1>
    <c:if test="${not empty pelicula}">
        <p><strong>Título:</strong> ${pelicula.titulo}</p>
        <p><strong>Director:</strong> ${pelicula.director}</p>
        <p><strong>Año:</strong> ${pelicula.anio}</p>
        <p><strong>Género:</strong> ${pelicula.genero}</p>
    </c:if>
    <c:if test="${empty pelicula}">
        <p>No se encontró la película.</p>
    </c:if>
    <a href="pelicula">Volver a la lista de películas</a>
</body>
</html>
