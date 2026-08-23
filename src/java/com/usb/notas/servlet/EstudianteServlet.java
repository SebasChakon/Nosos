package com.usb.notas.servlet;

import com.usb.notas.dao.EstudianteDAO;
import com.usb.notas.modelo.Estudiante;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

/**
 * Controlador principal de la aplicacion.
 * Mapea todas las rutas bajo /estudiantes/* y decide, segun la ruta,
 * si mostrar el formulario, calcular, guardar, listar, editar o eliminar.
 */
@WebServlet("/estudiantes/*")
public class EstudianteServlet extends HttpServlet {

    private final EstudianteDAO dao = new EstudianteDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ruta = request.getPathInfo(); // ej: null, "/", "/listado", "/editar/3", "/eliminar/3"

        try {
            if (ruta == null || ruta.equals("/")) {
                // Formulario de registro (pagina principal)
                request.getRequestDispatcher("/index.jsp").forward(request, response);

            } else if (ruta.equals("/listado")) {
                request.setAttribute("estudiantes", dao.listarTodos());
                request.getRequestDispatcher("/listado.jsp").forward(request, response);

            } else if (ruta.startsWith("/editar/")) {
                int id = Integer.parseInt(ruta.substring("/editar/".length()));
                Estudiante estudiante = dao.buscarPorId(id);
                request.setAttribute("estudiante", estudiante);
                request.getRequestDispatcher("/editar.jsp").forward(request, response);

            } else if (ruta.startsWith("/eliminar/")) {
                int id = Integer.parseInt(ruta.substring("/eliminar/".length()));
                dao.eliminar(id);
                response.sendRedirect(request.getContextPath() + "/estudiantes/listado");

            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (SQLException e) {
            throw new ServletException("Error al acceder a la base de datos", e);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Id invalido");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String ruta = request.getPathInfo();

        try {
            if (ruta != null && ruta.equals("/calcular")) {
                procesarCalculoOGuardado(request, response, false);

            } else if (ruta != null && ruta.equals("/registrar")) {
                procesarCalculoOGuardado(request, response, true);

            } else if (ruta != null && ruta.startsWith("/actualizar/")) {
                int id = Integer.parseInt(ruta.substring("/actualizar/".length()));
                procesarActualizacion(request, response, id);

            } else {
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
            }
        } catch (SQLException e) {
            throw new ServletException("Error al acceder a la base de datos", e);
        }
    }

    /**
     * Construye el estudiante desde el formulario, valida, calcula
     * y opcionalmente lo guarda en la base de datos, segun "guardar".
     */
    private void procesarCalculoOGuardado(HttpServletRequest request, HttpServletResponse response,
                                           boolean guardar) throws ServletException, IOException, SQLException {

        Estudiante estudiante = new Estudiante();
        String error = leerYValidarFormulario(request, estudiante);

        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("estudiante", estudiante);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
            return;
        }

        estudiante.evaluar();

        if (guardar) {
            dao.registrar(estudiante);
            request.setAttribute("estudiante", new Estudiante()); // limpia el formulario
        } else {
            request.setAttribute("estudiante", estudiante); // mantiene lo que escribio el usuario
        }

        request.setAttribute("resultado", estudiante);
        request.setAttribute("guardado", guardar);
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }

    /**
     * Procesa la edicion de un estudiante existente.
     */
    private void procesarActualizacion(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException, SQLException {

        Estudiante estudiante = new Estudiante();
        String error = leerYValidarFormulario(request, estudiante);
        estudiante.setId(id);

        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("estudiante", estudiante);
            request.getRequestDispatcher("/editar.jsp").forward(request, response);
            return;
        }

        estudiante.evaluar();
        dao.actualizar(estudiante);
        response.sendRedirect(request.getContextPath() + "/estudiantes/listado");
    }

    /**
     * Lee los parametros del formulario, los guarda en el objeto estudiante
     * y devuelve un mensaje de error si algo no es valido (o null si todo bien).
     */
    private String leerYValidarFormulario(HttpServletRequest request, Estudiante estudiante) {
        estudiante.setNombre(request.getParameter("nombre"));

        try {
            estudiante.setNota1(Double.parseDouble(request.getParameter("nota1")));
            estudiante.setNota2(Double.parseDouble(request.getParameter("nota2")));
            estudiante.setNota3(Double.parseDouble(request.getParameter("nota3")));
            estudiante.setNota4(Double.parseDouble(request.getParameter("nota4")));
        } catch (NumberFormatException | NullPointerException e) {
            return "Las cuatro notas son obligatorias y deben ser valores numericos.";
        }

        return estudiante.validar();
    }
}
