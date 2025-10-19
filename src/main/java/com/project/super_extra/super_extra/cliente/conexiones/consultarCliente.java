package com.project.super_extra.super_extra.cliente.conexiones;

// Importación de la clase que gestiona la conexión con la base de datos
import com.project.super_extra.super_extra.cliente.conexiones.conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException; // Importación para el manejo de excepciones SQL

public class consultarCliente {

    public static void main(String[] args) {

        // Declaración de los objetos necesarios para realizar la conexión y la consulta
        Connection conectar = null;  // Objeto que representa la conexión con la base de datos
        Statement declaracion = null; // Objeto para ejecutar sentencias SQL simples
        ResultSet resultado = null;   // Objeto que almacena los resultados de la consulta

        try {
            // LLAMAR LA CLASE CONEXION PARA CONECTARSE
            // Se obtiene la conexión con la base de datos a través del método getConnection()
            conectar = conexion.getConnection();

            // CREAR LA DECLARACION
            // Se crea un objeto Statement que permitirá ejecutar consultas SQL
            declaracion = conectar.createStatement();

            // CREAR LA CONSULTA
            // Se define la instrucción SQL para seleccionar los datos de la tabla 'cliente'
            String sql = "select id_cliente, nombre, telefono, email, direccion from cliente";

            // EJECUTAR LA CONSULTA
            // Se ejecuta la consulta y se almacena el resultado en el objeto ResultSet
            resultado = declaracion.executeQuery(sql);

            // MOSTRAR LOS DATOS DE LA CONSULTA
            // Se recorre el conjunto de resultados fila por fila
            while (resultado.next()) {

                // Se obtienen los valores de cada columna del registro actual
                int idClienteResultado = resultado.getInt("id_cliente");
                String nombreResultado = resultado.getString("nombre");
                int telefonoResultado = resultado.getInt("telefono");
                String emailResultado = resultado.getString("email");
                String direccionResultado = resultado.getString("direccion");

                // Se muestran los datos en consola
                System.out.println("ID_CLIENTE: " + idClienteResultado);
                System.out.println("NOMBRE: " + nombreResultado);
                System.out.println("TELEFONO: " + telefonoResultado);
                System.out.println("EMAIL: " + emailResultado);
                System.out.println("DIRECCION: " + direccionResultado);
                System.out.println(" "); // Espacio en blanco para separar registros
            }

        } catch (Exception e) {
            // CAPTURA DE ERRORES
            // Si ocurre algún error (por ejemplo, fallo en la conexión o en la consulta), se muestra un mensaje
            System.out.println("Error: " + e);

        } finally {
            // CIERRE DE RECURSOS
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

