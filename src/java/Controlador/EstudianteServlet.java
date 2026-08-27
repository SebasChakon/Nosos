package Controlador;

import Modelo.EstudianteDAO;
import Modelo.Estudiante;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.SQLException;

public class EstudianteServlet extends HttpServlet {

    private final EstudianteDAO dao = new EstudianteDAO();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        String accion = request.getParameter("accion");
        if (accion == null) accion = "";

        try {
            switch (accion) {

                case "listado":
                    request.setAttribute("estudiantes", dao.listarTodos());
                    request.getRequestDispatcher("listado.jsp").forward(request, response);
                    break;

                case "editar":
                    int idEditar = Integer.parseInt(request.getParameter("id"));
                    Estudiante estudiante = dao.buscarPorId(idEditar);
                    request.setAttribute("estudiante", estudiante);
                    request.getRequestDispatcher("editar.jsp").forward(request, response);
                    break;

                case "eliminar":
                    int idEliminar = Integer.parseInt(request.getParameter("id"));
                    dao.eliminar(idEliminar);
                    response.sendRedirect("controlador?accion=listado");
                    break;

                case "calcular":
                    procesarCalculoOGuardado(request, response, false);
                    break;

                case "registrar":
                    procesarCalculoOGuardado(request, response, true);
                    break;

                case "actualizar":
                    int idActualizar = Integer.parseInt(request.getParameter("id"));
                    procesarActualizacion(request, response, idActualizar);
                    break;

                default:
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
            }
        } catch (SQLException e) {
            throw new ServletException("Error al acceder a la base de datos", e);
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Id invalido");
        }
    }

    private void procesarCalculoOGuardado(HttpServletRequest request, HttpServletResponse response,
                                           boolean guardar) throws ServletException, IOException, SQLException {

        Estudiante estudiante = new Estudiante();
        String error = leerYValidarFormulario(request, estudiante);

        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("estudiante", estudiante);
            request.getRequestDispatcher("index.jsp").forward(request, response);
            return;
        }

        estudiante.evaluar();

        if (guardar) {
            dao.registrar(estudiante);
            request.setAttribute("estudiante", new Estudiante());
        } else {
            request.setAttribute("estudiante", estudiante);
        }

        request.setAttribute("resultado", estudiante);
        request.setAttribute("guardado", guardar);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

    private void procesarActualizacion(HttpServletRequest request, HttpServletResponse response, int id)
            throws ServletException, IOException, SQLException {

        Estudiante estudiante = new Estudiante();
        String error = leerYValidarFormulario(request, estudiante);
        estudiante.setId(id);

        if (error != null) {
            request.setAttribute("error", error);
            request.setAttribute("estudiante", estudiante);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
            return;
        }

        estudiante.evaluar();
        dao.actualizar(estudiante);
        response.sendRedirect("controlador?accion=listado");
    }

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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ServletException e) {
            throw e;
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
}