package com.project.super_extra.super_extra.venta.conexiones;

// Importación de la clase 'conexion' (que permite conectarse a la base de datos)

import com.project.super_extra.super_extra.venta.conexiones.conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class Insertarventa {
  // Método estático que recibe los datos del cliente y los inserta en la base de datos

    public static void Insertarventa(
        int id_venta, // 1 usage
        String fecha,
        int id_cliente,
        int total
        ) {

     // Declaración de los objetos necesarios para la conexión y ejecución del SQL


        Connection conectar = null;
        PreparedStatement declaracion = null;
        
        // LLAMAR A LA CLASE CONEXION PARA CONECTARSE
        // Se obtiene una conexión con la base de datos mediante la clase 'conexion
        try {
            conectar = conexion.getConnection();
            String sql = "insert into venta(id_venta, fecha, id_cliente, total ) values(?,?,?,?)";
            //INSERTAR DATOS EN SQL
            //SE PREPARA LA INSTRUCCION CON PARAMETROS 
            // Asignar los valores a cada parámetro en el orden indicado en la consulta SQL
            declaracion = conectar.prepareStatement(sql);
            declaracion.setInt(1, id_venta);
            declaracion.setString(2, fecha);
            declaracion.setInt(3, id_cliente);
            declaracion.setInt(4, total);
            

            // Se ejecuta la sentencia y se obtiene el número de filas insertadas
            int filasInsertadas = declaracion.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println(filasInsertadas + " filas insertadas");
            }
            // CAPTURAR CUALQUIER ERROR SQL
        } catch (SQLException e) {
            System.out.println("Error insertando datos" + e);

             // CERRAR LOS RECURSOS (PreparedStatement y Connection)
        } finally {
            try {
                if (declaracion != null) declaracion.close();
                if (conectar != null) conectar.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }
        // MÉTODO PRINCIPAL PARA PROBAR LA INSERCIÓN DE VENTAS
    public static void main(String[] args) {
        // Inserta varios registros  en la tabla "VENTAS"
        Insertarventa(2, "2025-10-21", 1, 6000);
    }
}