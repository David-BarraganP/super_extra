package com.project.super_extra.super_extra.cliente.conexiones;

// Importación de la clase 'conexion' (que permite conectarse a la base de datos)

import com.project.super_extra.super_extra.cliente.conexiones.conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class insertarCliente {

    public static void insertarCliente(

    // Método estático que recibe los datos del cliente y los inserta en la base de datos

    int id_cliente, // 1 usage
    String nombre,
    int telefono,
    String email,
    String direccion
    
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
            String sql = "insert into cliente(id_cliente, nombre, telefono, email, direccion) values(?,?,?,?,?)";

             // PREPARAR LA DECLARACION
            // Se crea un objeto PreparedStatement que permite insertar los valores de forma segura
            declaracion = conectar.prepareStatement(sql);

            // Asignar los valores a cada parámetro en el orden indicado en la consulta SQL
            declaracion.setInt(1, id_cliente);
            declaracion.setString(2, nombre);
            declaracion.setInt(3, telefono);
            declaracion.setString(4, email);
            declaracion.setString(5, direccion);

            
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
        insertarCliente(4, "Cliente a eliminar", 649873, "elimine@gmail.com", "avenida marginal");
    }
}
