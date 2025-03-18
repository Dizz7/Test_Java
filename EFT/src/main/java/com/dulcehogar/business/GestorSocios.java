package com.dulcehogar.business;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.dulcehogar.db.ConexionBD;
import java.util.ArrayList;
import java.util.List;

public class GestorSocios {
    
    private static final List<Socio> socios = new ArrayList<>();

     
    public void registrarSocio(Socio socio) {
        socios.add(socio);
    }

  public Socio buscarSocioPorNumero(int numeroSocio) {

    ConexionBD conexionBD = new ConexionBD();
    Connection conexion = null;
    Socio socio = null;

    try {
        conexion = conexionBD.conectar();


        String sql = "SELECT s.rut, s.nombre, s.ap_paterno, s.ap_materno, s.telefono, s.domicilio, s.comuna, s.ciudad, s.region, s.correo, c.cantidad_aportada " +
                     "FROM socios s " +
                     "JOIN cuentas c ON s.numero_socio = c.numero_socio " + 
                     "WHERE s.numero_socio = ?";

        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
            stmt.setInt(1, numeroSocio);

            try (ResultSet rs = stmt.executeQuery()) {

                if (rs.next()) {
                    String rut = rs.getString("rut");
                    String nombre = rs.getString("nombre");
                    String apPaterno = rs.getString("ap_paterno");
                    String apMaterno = rs.getString("ap_materno");
                    String telefono = rs.getString("telefono");
                    String domicilio = rs.getString("domicilio");
                    String comuna = rs.getString("comuna");
                    String ciudad = rs.getString("ciudad");
                    String region = rs.getString("region");
                    String correo = rs.getString("correo");
                    int cantidadAportada = rs.getInt("cantidad_aportada");

                    socio = new Socio(rut, nombre, apPaterno, apMaterno, telefono, domicilio, comuna, ciudad, region, correo, numeroSocio, cantidadAportada, null);
                }
            }
        }
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        conexionBD.cerrarConexion(conexion);
    }

    return socio;
}
  
   public boolean actualizarCuotaSocio(int numeroSocio, int monto) {
        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;
        boolean exito = false;

        try {
            conexion = conexionBD.conectar();
            
            String sql = "UPDATE cuentas SET cantidad_aportada = cantidad_aportada + ?, valor_cuota = ? WHERE numero_socio = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setInt(1, monto);
                stmt.setInt(2, monto);
                stmt.setInt(3, numeroSocio);

                int filasAfectadas = stmt.executeUpdate();
                if (filasAfectadas > 0) {
                    exito = true;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionBD.cerrarConexion(conexion);
        }

        return exito;
    }
  
   
    public int obtenerCuotaCancelada(int numeroSocio) {
        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;
        int cuotaCancelada = 0;

        try {
            conexion = conexionBD.conectar();
            String sql = "SELECT valor_cuota FROM cuentas WHERE numero_socio = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setInt(1, numeroSocio);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    cuotaCancelada = rs.getInt("valor_cuota");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionBD.cerrarConexion(conexion);
        }

        return cuotaCancelada;
    }
   
  
      public double obtenerTotalCuotasCanceladas(int numeroSocio) {
        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = null;
        double totalCuotasCanceladas = 0.0;

        try {
            conexion = conexionBD.conectar();
            String sql = "SELECT cantidad_aportada FROM cuentas WHERE numero_socio = ?";
            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setInt(1, numeroSocio);
                ResultSet rs = stmt.executeQuery();
                if (rs.next()) {
                    totalCuotasCanceladas = rs.getDouble("cantidad_aportada");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conexionBD.cerrarConexion(conexion);
        }

        return totalCuotasCanceladas;
    }
    
}