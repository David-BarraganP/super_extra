package com.project.super_extra.super_extra.cliente.conexiones;

// Importación de la clase 'conexion' para poder establecer la conexión con la base de datos
import com.project.super_extra.super_extra.cliente.conexiones.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarCliente {

    // MÉTODO ESTÁTICO PARA ACTUALIZAR LOS DATOS DE UN CLIENTE EXISTENTE
    public static void Actualizar(
        int id_cliente,      // ID del cliente que se desea actualizar
        String nuevoNombre,  // Nuevo nombre del cliente
        int nuevoTelefono,   // Nuevo número de teléfono
        String nuevoEmail,   // Nuevo correo electrónico
        String nuevoDireccion // Nueva dirección
    ) {

        // Declaración de las variables necesarias para la conexión y la ejecución SQL
        Connection conectar = null;
        PreparedStatement declaracion = null;

        try {
            // OBTENER LA CONEXIÓN A LA BASE DE DATOS
            conectar = conexion.getConnection();

            // CONSULTA SQL PARA ACTUALIZAR LOS DATOS DEL CLIENTE
            // Se actualizan los campos nombre, teléfono, email y dirección donde el ID coincida
            String sql = "update cliente set nombre=?, telefono=?, email=?, direccion=?  where id_cliente=?";

            // PREPARAR LA SENTENCIA SQL
            // Se utiliza PreparedStatement para evitar inyecciones SQL y manejar los parámetros de forma segura
            declaracion = conectar.prepareStatement(sql);

            // ASIGNAR LOS VALORES A CADA PARÁMETRO
            declaracion.setString(1, nuevoNombre);
            declaracion.setInt(2, nuevoTelefono);
            declaracion.setString(3, nuevoEmail);
            declaracion.setString(4, nuevoDireccion);
            declaracion.setInt(5, id_cliente);

            // EJECUTAR LA ACTUALIZACIÓN
            int actualiza = declaracion.executeUpdate();

            // COMPROBAR SI SE ACTUALIZARON FILAS
            if (actualiza > 0) {
                System.out.println("Actualizacion exitosa! " + actualiza + " fila(s)");
            } else {
                System.out.println("No existe ID de ese cliente");
            }

        } catch (SQLException e) {
            // CAPTURA DE ERRORES DE SQL
            System.out.println("Error de actualizacion: " + e);

        } finally {
            // CIERRE DE RECURSOS
            try {
                if (declaracion != null) declaracion.close();
                if (conectar != null) conectar.close();
            } catch (SQLException e) {
                System.out.println("Error cerrando conexión: " + e);
            }
        }
    }

    // MÉTODO PRINCIPAL PARA PROBAR LA ACTUALIZACIÓN DE CLIENTES
    public static void main(String[] args) {
        // Actualiza el cliente con ID = numero del id, modificando sus datos
        Actualizar(1, "David", 123456, "dvd@gmail.com", "yopal centro");
    }
}
