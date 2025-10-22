
package com.project.super_extra.super_extra.venta.conexiones;

import com.project.super_extra.super_extra.venta.conexiones.conexion;
// Importación de la clase que gestiona la conexión con la base de da

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarventa {

    // MÉTODO ESTÁTICO PARA ACTUALIZAR LOS DATOS DE UN CLIENTE EXISTENTE
    public static void Actualizar(int id_venta, // ID DE LA VENTA QUE DESEAMOS ACTUALIZAR
                                  String nuevaFecha, // NUEVA FECHA DE VENTA
                                  int nuevoIdCliente, //NUEVO CLIENTE 
                                  int nuevoTotal // NUEVO VALOR DE LA VENTE
                                  ) { //NUEVO USUARIO QUE REALIZO LA VENTA
        
        // Declaración de las variables necesarias para la conexión y la ejecución SQL

        Connection conectar = null;
        PreparedStatement declaracion = null;

        try {

            //Conexion con base de datos
            conectar = conexion.getConnection();

            // ACTUALIZACION DE DATOS
            // se actualizan los campos fecha, total y
            String sql = "update venta set fecha=?, id_cliente=?, total=?  where id_venta=?";
            //// ASIGNAR LOS VALORES A CADA PARÁMETRO
            declaracion = conectar.prepareStatement(sql);
            declaracion.setString(1, nuevaFecha);
            declaracion.setInt(2, nuevoIdCliente);
            declaracion.setInt(3, nuevoTotal);
            declaracion.setInt(4, id_venta);
            

            // ejecutar la actualizacion
            int actualiza = declaracion.executeUpdate();
            // COMPROBAR SI SE ACTUALIZARON FILAS
            if (actualiza > 0) {
                System.out.println("Actualizacion exitosa! " + actualiza + " fila(s)");
            } else {
                System.out.println("No existe ID de esa venta");
            }

        } catch (SQLException e) {
            // CAPTURA DE ERRORES DE SQL

            System.out.println("Error de actualizacion: " + e);
        } finally {
            try {
                if (declaracion != null) declaracion.close();
                if (conectar != null) conectar.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando conexión: " + e);
            }
        }
    }

    public static void main(String[] args) {
        // MÉTODO PRINCIPAL PARA PROBAR LA ACTUALIZACIÓN DE CLIENTES
        Actualizar(1, "2025-10-1", 2, 4000 );
                
    }
} 
