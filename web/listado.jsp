<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.usb.notas.modelo.Estudiante" %>
<%@ page import="java.util.List" %>
<%
    List<Estudiante> estudiantes = (List<Estudiante>) request.getAttribute("estudiantes");
    if (estudiantes == null) estudiantes = java.util.Collections.emptyList();
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Registros de estudiantes</title>
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
        <h2>Registros almacenados</h2>

        <% if (estudiantes.isEmpty()) { %>
        <p class="hint">Todavía no hay estudiantes registrados.</p>
        <% } else { %>

        <div class="table-wrapper">
            <table class="data-table">
                <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>N1</th>
                    <th>N2</th>
                    <th>N3</th>
                    <th>N4</th>
                    <th>Promedio</th>
                    <th>Estado</th>
                    <th>Rendimiento</th>
                    <th>Acciones</th>
                </tr>
                </thead>
                <tbody>
                <% for (Estudiante e : estudiantes) {
                    String claseEstado = "Aprobado".equals(e.getEstado()) ? "value-ok" : "value-bad";
                %>
                <tr>
                    <td><%= e.getId() %></td>
                    <td><%= e.getNombre() %></td>
                    <td><%= e.getNota1() %></td>
                    <td><%= e.getNota2() %></td>
                    <td><%= e.getNota3() %></td>
                    <td><%= e.getNota4() %></td>
                    <td><%= e.getPromedio() %></td>
                    <td><span class="badge-small <%= claseEstado %>"><%= e.getEstado() %></span></td>
                    <td><%= e.getResultadoCualitativo() %></td>
                    <td class="row-actions">
                        <a href="<%= request.getContextPath() %>/estudiantes/editar/<%= e.getId() %>" class="btn btn-small btn-secondary">Editar</a>
                        <a href="<%= request.getContextPath() %>/estudiantes/eliminar/<%= e.getId() %>" class="btn btn-small btn-danger">Eliminar</a>
                    </td>
                </tr>
                <% } %>
                </tbody>
            </table>
        </div>
        <% } %>
    </section>

</main>

<footer class="footer">
    Universidad de San Buenaventura · Proyecto Integrador
</footer>

</body>
</html>
