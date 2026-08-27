<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="Modelo.Estudiante" %>
<%
    Estudiante estudiante = (Estudiante) request.getAttribute("estudiante");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Editar estudiante</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>

<header class="topbar">
    <div class="topbar-inner">
        <h1>Gestión de Notas Académicas</h1>
        <nav>
            <a href="<%= request.getContextPath() %>/estudiantes/" class="nav-link">Registrar</a>
            <a href="<%= request.getContextPath() %>/estudiantes/listado" class="nav-link active">Consultar registros</a>
        </nav>
    </div>
</header>

<main class="container">

    <section class="card">
        <h2>Editar registro</h2>
        <p class="hint">Modifica el nombre o las notas y guarda los cambios.</p>

        <% if (error != null) { %>
        <p class="error" style="margin-bottom: 12px;"><%= error %></p>
        <% } %>

        <form action="<%= request.getContextPath() %>/controlador?accion=actualizar&id=<%= estudiante.getId() %>" method="post" class="form-grid">

            <div class="field full">
                <label for="nombre">Nombre del estudiante</label>
                <input type="text" id="nombre" name="nombre" value="<%= estudiante.getNombre() %>">
            </div>

            <div class="field">
                <label for="nota1">Nota 1</label>
                <input type="number" step="0.1" min="0" max="5" id="nota1" name="nota1" value="<%= estudiante.getNota1() %>">
            </div>

            <div class="field">
                <label for="nota2">Nota 2</label>
                <input type="number" step="0.1" min="0" max="5" id="nota2" name="nota2" value="<%= estudiante.getNota2() %>">
            </div>

            <div class="field">
                <label for="nota3">Nota 3</label>
                <input type="number" step="0.1" min="0" max="5" id="nota3" name="nota3" value="<%= estudiante.getNota3() %>">
            </div>

            <div class="field">
                <label for="nota4">Nota 4</label>
                <input type="number" step="0.1" min="0" max="5" id="nota4" name="nota4" value="<%= estudiante.getNota4() %>">
            </div>

            <div class="actions full">
                <a href="<%= request.getContextPath() %>/controlador?accion=listado" class="btn btn-secondary">Cancelar</a>
                <button type="submit" class="btn btn-primary">Guardar cambios</button>
            </div>
        </form>
    </section>

</main>

<footer class="footer">
    Universidad de San Buenaventura · Proyecto Integrador
</footer>

</body>
</html>