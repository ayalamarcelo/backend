<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Lista de Películas</title>
</head>
<body>
    <h1>Lista de Películas</h1>
    <c:if test="${not empty peliculas}">
        <ul>
            <c:forEach var="pelicula" items="${peliculas}">
                <li>
                    <strong>Título:</strong> ${pelicula.titulo} |
                    <strong>Director:</strong> ${pelicula.director} |
                    <strong>Año:</strong> ${pelicula.anio} |
                    <strong>Género:</strong> ${pelicula.genero}
                </li>
            </c:forEach>
        </ul>
    </c:if>
    <c:if test="${empty peliculas}">
        <p>No hay películas disponibles.</p>
    </c:if>
    <a href="agregarPelicula.jsp">Agregar nueva película</a>
</body>
</html>
