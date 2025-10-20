package com.project.super_extra.super_extra.venta.conexiones;
import com.mysql.cj.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;

public class conexion {

    public static Connection getConnection() { // 3 usages
        Connection miConexion = null;
        var base  = "super_extra";
        var url = "jdbc:mysql://localhost:3306/" + base;
        var user = "root";
        var pass = "";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            miConexion = DriverManager.getConnection(url, user, pass);

        } catch (Exception e) {
            System.out.println("Error de conexion a la base de datos" + e);
        }

        return miConexion;
    }

    public static void main() {
        var conexion = conexion.getConnection();
        if (conexion != null) {
            System.out.println("Conexion correcta");
        } else {
            System.out.println("Error en la conexion");
        }
    }
}
