package com.usb.notas.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase encargada unicamente de abrir la conexion hacia la base de datos MySQL.
 * Centralizar esto aqui evita repetir la misma cadena de conexion en cada DAO.
 */
public class ConexionBD {

    // Ajusta estos datos si tu MySQL usa otro puerto, usuario o contraseña.
    private static final String URL =
            "jdbc:mysql://localhost:3306/notas_academicas?useSSL=false&serverTimezone=UTC";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "root";

    /**
     * Abre y devuelve una nueva conexion a la base de datos.
     * Quien la use es responsable de cerrarla (idealmente con try-with-resources).
     */
    public static Connection obtenerConexion() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new SQLException("No se encontro el driver de MySQL. Revisa que el .jar este en Libraries.", e);
        }
        return DriverManager.getConnection(URL, USUARIO, CONTRASENA);
    }
}
