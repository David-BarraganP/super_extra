package com.project.super_extra.super_extra.producto.conexiones;

import com.project.super_extra.super_extra.producto.conexiones.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class insertarProducto {

     public static void insertarProducto(

            // Método estático que recibe los datos del producto y los inserta en la base de datos

            int id_producto, // 1 usage
            String nombreProducto,
            String descripcion,
            String color,
            int precio_compra

    ) {

        // Declaración de los objetos necesarios para la conexión y ejecución del SQL
        Connection conectar = null;
        PreparedStatement declaracion = null;

        try {

            // LLAMAR A LA CLASE CONEXION PARA CONECTARSE
            // Se obtiene una conexión con la base de datos mediante la clase 'conexion'
            conectar = conexion.getConnection();

            // SENTENCIA SQL PARA INSERTAR DATOS
            // Se prepara la instrucción con parámetros (los signos de interrogación)
            String sql = "insert into producto(id_producto, nombre, descripcion, color, precio_compra) values(?,?,?,?,?)";

            // PREPARAR LA DECLARACION
            // Se crea un objeto PreparedStatement que permite insertar los valores de forma segura
            declaracion = conectar.prepareStatement(sql);

            // Asignar los valores a cada parámetro en el orden indicado en la consulta SQL
            declaracion.setInt(1, id_producto);
            declaracion.setString(2, nombreProducto);
            declaracion.setString(3, descripcion);
            declaracion.setString(4, color);
            declaracion.setInt(5, precio_compra);


            // EJECUTAR LA INSERCIÓN
            // Se ejecuta la sentencia y se obtiene el número de filas insertadas
            int filasInsertadas = declaracion.executeUpdate();

            // Si se insertaron filas correctamente, se muestra un mensaje en consola
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

    // MÉTODO PRINCIPAL PARA PROBAR LA INSERCIÓN DE CLIENTES
    public static void main(String[] args) {
        // Inserta varios registros  en la tabla 'cliente'
        //insertarCliente(2, "Andre ", 649873, "andres@gmail.com", "avenida marginal");
        //insertarCliente(3, "Edinson ", 649873, "edinson@gmail.com", "avenida marginal");
        insertarProducto(3,"nike","calzado", "rojo", 350000);
        insertarProducto(4,"nike","calzado", "rojo", 350000);
        
    }

}
