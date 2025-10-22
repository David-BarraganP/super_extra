package com.project.super_extra.super_extra.producto.conexiones;

// Importación de la clase 'conexion' para poder establecer la conexión con la base de datos


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class actualizarProducto {

        // MÉTODO ESTÁTICO PARA ACTUALIZAR LOS DATOS DE UN CLIENTE EXISTENTE
        public static void Actualizar(
                int id_Producto,      // ID del producto que desea actualizar
                String nuevoNombre,  // Nuevo nombre del producto
                String nuevaDescripcion,   // Descripcion del producto
                String nuevoColor,   // color del calzado
                int nuevoPrecio )  // Precio del producto
         {

            // Declaración de las variables necesarias para la conexión y la ejecución SQL
            Connection conectar = null;
            PreparedStatement declaracion = null;

            try {
                // OBTENER LA CONEXIÓN A LA BASE DE DATOS
                conectar = conexion.getConnection();

                // CONSULTA SQL PARA ACTUALIZAR LOS DATOS DEL CLIENTE
                // Se actualizan los campos nombre, teléfono, email y dirección donde el ID coincida
                String sql = "update producto set nombre=?, description=?, color=?, precio=?  where id_producto=?";

                // PREPARAR LA SENTENCIA SQL
                // Se utiliza PreparedStatement para evitar inyecciones SQL y manejar los parámetros de forma segura
                declaracion = conectar.prepareStatement(sql);

                // ASIGNAR LOS VALORES A CADA PARÁMETRO
                declaracion.setString(1, nuevoNombre);
                declaracion.setString(2, nuevaDescripcion);
                declaracion.setString(3, nuevoColor);
                declaracion.setInt(4, nuevoPrecio);
                declaracion.setInt(5, id_Producto);

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
            Actualizar(1, "nike venus", "Comodos y livianos", "rojo", 12378);
        }
}

