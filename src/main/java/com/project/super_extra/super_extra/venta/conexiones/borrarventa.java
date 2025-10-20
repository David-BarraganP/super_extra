package com.project.super_extra.super_extra.venta.conexiones;

import com.project.super_extra.super_extra.venta.conexiones.conexion;
// Importación de la clase que gestiona la conexión con la base de da

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class borrarventa {
    // MÉTODO ESTÁTICO PARA ELIMINAR UN CLIENTE SEGÚN SU ID

    public static void BorrarPersona(int idperso) { // 1 usage

        // Declaración de los objetos necesarios para la conexión y la ejecución SQL
        Connection conectar = null;
        PreparedStatement declaracion = null;

        try {
            // OBTENER CONEXIÓN A LA BASE DE DATOS
            conectar = conexion.getConnection();

            // Elimina de la tabla 'cliente' el registro cuyo ID coincida con el parámetro recibido
            String sql = "delete from venta where id_venta = ?";

            // PREPARAR LA SENTENCIA SQL
            declaracion = conectar.prepareStatement(sql);
            declaracion.setInt(1, id_venta);

            //EJECUTAR LA ELIMINACIÓN
            int eliminadas = declaracion.executeUpdate();

            // COMPROBAR SI SE ELIMINÓ ALGUNA FILA
            if (eliminadas > 0) {
                System.out.println("venta de id: " + id_venta + " Eliminada");
            } else {
                System.out.println("No se encontró ese id de persona");
            }

        } catch (SQLException e) {
            // CAPTURA DE ERRORES DURANTE LA ELIMINACIÓN
            System.out.println("Error eliminando venta: " + e);

        } finally {
            try {
                if (declaracion != null) declaracion.close(); // Cierra el PreparedStatement
                if (conectar != null) conectar.close(); // Cierra la conexión con la base de datos
            } catch (SQLException e) {
                System.out.println(e);
            }
        }
    }
    // MÉTODO PRINCIPAL PARA PROBAR EL BORRADO DE CLIENTES
    public static void main(String[] args) {
        borrarventa(id_venta 12); // Se elimina el cliente con ID = 4 de la tabla 'cliente'
    }
}
