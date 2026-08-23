<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="com.usb.notas.modelo.Estudiante" %>
<%
    Estudiante estudiante = (Estudiante) request.getAttribute("estudiante");
    if (estudiante == null) estudiante = new Estudiante();
    Estudiante resultado = (Estudiante) request.getAttribute("resultado");
    Boolean guardado = (Boolean) request.getAttribute("guardado");
    String error = (String) request.getAttribute("error");
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gestión de Notas Académicas</title>
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/styles.css">
</head>
<body>

<header class="topbar">
    <div class="topbar-inner">
        <h1>Gestión de Notas Académicas</h1>
        <nav>
            <a href="<%= request.getContextPath() %>/estudiantes/" class="nav-link active">Registrar</a>
            <a href="<%= request.getContextPath() %>/estudiantes/listado" class="nav-link">Consultar registros</a>
        </nav>
    </div>
</header>

<main class="container">

    <section class="card">
        <h2>Formulario de registro</h2>
        <p class="hint">Ingresa el nombre del estudiante y sus cuatro notas (escala 0.0 a 5.0).</p>

        <% if (error != null) { %>
        <p class="error" style="margin-bottom: 12px;"><%= error %></p>
        <% } %>

        <form action="<%= request.getContextPath() %>/estudiantes/calcular" method="post" class="form-grid">

            <div class="field full">
                <label for="nombre">Nombre del estudiante</label>
                <input type="text" id="nombre" name="nombre"
                       value="<%= estudiante.getNombre() == null ? "" : estudiante.getNombre() %>"
                       placeholder="Ej: Ana María Rojas">
            </div>

            <div class="field">
                <label for="nota1">Nota 1</label>
                <input type="number" step="0.1" min="0" max="5" id="nota1" name="nota1"
                       value="<%= estudiante.getNota1() == 0 ? "" : estudiante.getNota1() %>" placeholder="0.0 - 5.0">
            </div>

            <div class="field">
                <label for="nota2">Nota 2</label>
                <input type="number" step="0.1" min="0" max="5" id="nota2" name="nota2"
                       value="<%= estudiante.getNota2() == 0 ? "" : estudiante.getNota2() %>" placeholder="0.0 - 5.0">
            </div>

            <div class="field">
                <label for="nota3">Nota 3</label>
                <input type="number" step="0.1" min="0" max="5" id="nota3" name="nota3"
                       value="<%= estudiante.getNota3() == 0 ? "" : estudiante.getNota3() %>" placeholder="0.0 - 5.0">
            </div>

            <div class="field">
                <label for="nota4">Nota 4</label>
                <input type="number" step="0.1" min="0" max="5" id="nota4" name="nota4"
                       value="<%= estudiante.getNota4() == 0 ? "" : estudiante.getNota4() %>" placeholder="0.0 - 5.0">
            </div>

            <div class="actions full">
                <button type="submit" formaction="<%= request.getContextPath() %>/estudiantes/calcular" class="btn btn-secondary">Calcular</button>
                <button type="submit" formaction="<%= request.getContextPath() %>/estudiantes/registrar" class="btn btn-primary">Guardar</button>
            </div>
        </form>
    </section>

    <% if (resultado != null) { %>
    <section class="card result-card">
        <h2>Resultado</h2>

        <% if (Boolean.TRUE.equals(guardado)) { %>
        <p class="feedback">El estudiante <strong><%= resultado.getNombre() %></strong> fue guardado correctamente en la base de datos.</p>
        <% } else { %>
        <p class="feedback feedback-preview">Vista previa del cálculo (aún no se ha guardado). Presiona <strong>Guardar</strong> para registrarlo.</p>
        <% } %>

        <div class="result-grid">
            <div class="result-item">
                <span class="label">Promedio</span>
                <span class="value"><%= resultado.getPromedio() %></span>
            </div>
            <div class="result-item">
                <span class="label">Estado</span>
                <span class="value <%= "Aprobado".equals(resultado.getEstado()) ? "value-ok" : "value-bad" %>"><%= resultado.getEstado() %></span>
            </div>
            <div class="result-item full">
                <span class="label">Rendimiento</span>
                <span class="value badge"><%= resultado.getResultadoCualitativo() %></span>
            </div>
        </div>
    </section>
    <% } %>

</main>

<footer class="footer">
    Universidad de San Buenaventura · Proyecto Integrador
</footer>

</body>
</html>
