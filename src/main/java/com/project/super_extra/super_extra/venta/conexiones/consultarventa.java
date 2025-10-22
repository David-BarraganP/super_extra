package com.project.super_extra.super_extra.venta.conexiones;

import com.project.super_extra.super_extra.venta.conexiones.conexion;
// Importación de la clase que gestiona la conexión con la base de datos

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class consultarventa {

    public static void main(String[] args) {

        // Declaración de los objetos necesarios para realizar la conexión y la consulta
        Connection conectar = null;
        Statement declaracion = null;
        ResultSet resultado = null;

        try {
            // LLAMAR LA CLASE CONEXION PARA CONECTARSE
            // Se obtiene la conexión con la base de datos a través del método getConnection()
            conectar = conexion.getConnection();

            // CREAR LA DECLARACION
            //  // Se crea un objeto Statement que permitirá ejecutar consultas SQL
            declaracion = conectar.createStatement();

            // CREAR LA CONSULTA
            // // Se define la instrucción SQL para seleccionar los datos de la tabla 'cliente'
            String sql = "select id_venta, fecha, id_cliente, total  from venta";

            // EJECUTAR LA CONSULTA
            // Se ejecuta la consulta y se almacena el resultado en el objeto ResultSet
            resultado = declaracion.executeQuery(sql);

            // MOSTRAR LOS DATOS DE LA CONSULTA
            // Se recorre el conjunto de resultados fila por fila
            while (resultado.next()) { 

                // Se obtienen los valores de cada columna del registro actual

                int idventaResultado = resultado.getInt("id_venta");
                String fechaResultado = resultado.getString("fecha");
                int idclienteResultado = resultado.getInt("id_cliente");
                int totalResultado = resultado.getInt("total");
                

                // Se muestran los datos en consola

                System.out.println("id_venta: " + idventaResultado);
                System.out.println("fecha: " + fechaResultado);
                System.out.println("id_cliente: " + idclienteResultado);
                System.out.println("total: " + totalResultado);
                System.out.println(" "); // Espacio en blanco para separar registros
            }

        } catch (Exception e) {

            // Si ocurre algún error (por ejemplo, fallo en la conexión o en la consulta), se muestra un mensaje
            System.out.println("Error: " + e);

        } finally {

            // Se cierran el ResultSet, el Statement y la Connection en caso de haber sido abiertos
            try {
                if (resultado != null) resultado.close();
                if (declaracion != null) declaracion.close();
                if (conectar != null) conectar.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
}
