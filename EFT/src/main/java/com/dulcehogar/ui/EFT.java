package com.dulcehogar.ui;

import com.dulcehogar.business.GestorSocios;
import com.dulcehogar.db.ConexionBD;
import java.sql.Connection;

/**
 * EFT S09
 * Grupo 3 
 * DANIEL CARLOS ALARCON POBLETE
 * ALEXANDRA GISSELE ASSLER LOPEZ 
 * ANDREA BELEN FARIAS SILVA 
 */

public class EFT {

    public static void main(String[] args) {
        
        ConexionBD conexionBD = new ConexionBD();
        Connection conexion = conexionBD.conectar();
        conexionBD.cerrarConexion(conexion);
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Crear instancia del gestor
                GestorSocios gestor = new GestorSocios();
                
                // Abrir la ventana de Login primero
                Login login = new Login(gestor);
                login.setLocationRelativeTo(null);
                
                // Establecer el listener para el login exitoso
                login.setLoginSuccessListener(new Login.LoginSuccessListener() {
                    
                    @Override
                    public void onLoginSuccess() {
                        // Cerrar la ventana de login
                        login.dispose();
                        
                        // Crear y mostrar el Menu después del login exitoso
                        Menu menu = new Menu(gestor);
                        menu.setLocationRelativeTo(null);
                        menu.setVisible(true);
                    }
                });
                
                login.setVisible(true);  // Mostrar la ventana de Login
            }
        });
    }
}