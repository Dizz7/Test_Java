package com.dulcehogar.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConexionBD {
 
    private static final String URL = "jdbc:mysql://localhost:3307/DulceHogar";
    private static final String USUARIO = "root";
    private static final String PASSWORD = "dulcehogar";
    
    public Connection conectar() {
        Connection conexion = null;
        
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion = DriverManager.getConnection(URL, USUARIO, PASSWORD);
            System.out.println("Conexión Exitosa a la base de datos");
                    
            
            
        } catch(ClassNotFoundException e){
            System.err.println("Error: no se encontró Driver de MYSQL");
            e.printStackTrace();
            
        } catch(SQLException e){
            System.err.println("Error al conectar con la bbdd");
            e.printStackTrace();
            
        }
        
        return conexion;    
    }
    
    public void cerrarConexion(Connection conexion){
        try{
           if (conexion != null && !conexion.isClosed()){
               conexion.close();
               System.out.println("Conexión Cerrada");
           }
            
            
        
        } catch(SQLException e){
            System.err.println("Error al cerrar la conexión con la bbdd");
            e.printStackTrace();
            
        }
        
        
    }
    
}
