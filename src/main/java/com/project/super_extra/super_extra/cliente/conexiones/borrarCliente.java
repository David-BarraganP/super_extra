package com.project.super_extra.super_extra.cliente.conexiones;

// Importación de la clase 'conexion' para acceder a la base de datos
import com.project.super_extra.super_extra.cliente.conexiones.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class borrarCliente {

    // MÉTODO ESTÁTICO PARA ELIMINAR UN CLIENTE SEGÚN SU ID
    public static void BorrarCliente(int idclien) { // 1 usage

        // Declaración de los objetos necesarios para la conexión y la ejecución SQL
        Connection conectar = null;
        PreparedStatement declaracion = null;

        try {
            // OBTENER CONEXIÓN A LA BASE DE DATOS
            conectar = conexion.getConnection();

            // SENTENCIA SQL PARA BORRAR UN CLIENTE
            // Elimina de la tabla 'cliente' el registro cuyo ID coincida con el parámetro recibido
            String sql = "delete from cliente where id_cliente = ?";

            // PREPARAR LA SENTENCIA SQL
            declaracion = conectar.prepareStatement(sql);
            declaracion.setInt(1, idclien); // Asigna el valor del ID al parámetro de la consulta

            // EJECUTAR LA ELIMINACIÓN
            int eliminadas = declaracion.executeUpdate();

            // COMPROBAR SI SE ELIMINÓ ALGUNA FILA
            if (eliminadas > 0) {
                System.out.println("Persona de id: " + idclien + " Eliminada");
            } else {
                System.out.println("No se encontró ese id de cliente");
            }

        } catch (SQLException e) {
            // CAPTURA DE ERRORES DURANTE LA ELIMINACIÓN
            System.out.println("Error eliminando cliente: " + e);

        } finally {
            // CIERRE DE RECURSOS
            try {
                if (declaracion != null) declaracion.close(); // Cierra el PreparedStatement
                if (conectar != null) conectar.close();       // Cierra la conexión con la base de datos
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }

    // MÉTODO PRINCIPAL PARA PROBAR EL BORRADO DE CLIENTES
    public static void main(String[] args) {
        // Se elimina el cliente con ID = 4 de la tabla 'cliente'
        BorrarCliente(4);
    }
}

