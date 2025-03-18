package com.dulcehogar.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class IniciarSesion {

    public boolean Inicio(String rut, String password) {
        // Establece la conexión a la base de datos
        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = conexionBD.conectar();

        if (conexion == null) {
            System.err.println("No se pudo establecer la conexión con la base de datos.");
            return false; // Si no hay conexión, retorna false
        }

        // Consulta SQL para validar el usuario y la contraseña
        String sql = "SELECT * FROM usuario WHERE rut = ? AND password = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            // Establece los parámetros de la consulta
            stmt.setString(1, rut);
            stmt.setString(2, password);

            // Ejecuta la consulta y obtiene los resultados
            ResultSet rs = stmt.executeQuery();

            // Si se encuentra un resultado, es un inicio de sesión exitoso
            if (rs.next()) {
                System.out.println("Inicio de sesión exitoso.");
                return true; // Usuario y contraseña correctos
            } else {
                System.out.println("Usuario o contraseña incorrectos.");
                return false; // Usuario o contraseña incorrectos
            }
        } catch (SQLException e) {
            System.err.println("Error al ejecutar la consulta");
            e.printStackTrace();
            return false; // En caso de error, retorna false
        } finally {
            // Cierra la conexión
            conexionBD.cerrarConexion(conexion);
        }
    }
}