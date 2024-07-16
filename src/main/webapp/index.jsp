<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Capturar Endpoints</title>
</head>
<body>
    <h1>Capturar Endpoints</h1>
    <form action="captureEndpoints" method="post">
        <label for="endpoint">Endpoint:</label>
        <input type="text" id="endpoint" name="endpoint" required><br><br>

        <label for="method">Method:</label>
        <select id="method" name="method">
            <option value="GET">GET</option>
            <option value="POST">POST</option>
            <option value="PUT">PUT</option>
            <option value="DELETE">DELETE</option>
        </select><br><br>

        <label for="description">Descripción:</label>
        <textarea id="description" name="description" required></textarea><br><br>

        <input type="submit" value="Submit">
    </form>
</body>
</html>
