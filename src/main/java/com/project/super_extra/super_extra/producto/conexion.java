package com.project.super_extra.super_extra.producto.conexiones;


import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {

      // Método que devuelve la conexión a la base de datos
    public static Connection getConnection() { // 3 usages
        Connection miConexion = null;
        var base  = "super_extra";
        var url = "jdbc:mysql://localhost:3306/" + base;
        var user = "root";
        var pass = "";

        try {

            // CARGAR EL DRIVER DE MYSQL
            // Se carga la clase del controlador JDBC que permite a Java comunicarse con MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            miConexion = DriverManager.getConnection(url, user, pass);

            // ESTABLECER LA CONEXIÓN
            // Se crea la conexión utilizando la URL, usuario y contraseña definidos
        } catch (Exception e) {

            // Si ocurre un error (por ejemplo, el servidor no está disponible o los datos son incorrectos)
            System.out.println("Error de conexion a la base de datos" + e);
        }

        // Devuelve la conexión (si fue exitosa) o null (si falló)
        return miConexion;
    }

    public static void main() {

        // Se llama al método getConnection() para intentar conectarse
        var Conexion = conexion.getConnection();

        // Verifica si la conexión fue exitosa      
        if (Conexion != null) {
            System.out.println("Conexion correcta");
        } else {
            System.out.println("Error en la conexion");
        }
    }
}
