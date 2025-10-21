package super_extra.venta.conexiones;

import super_extra.conexiones.Conexion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertarPersonas {

    public static void InsertarPersonas(int id_venta, // 1 usage
                                        String fecha,
                                        int id_cliente,
                                        int total
                                        int id_usuario) {

        Connection conectar = null;
        PreparedStatement declaracion = null;

        try {
            conectar = Conexion.getConnection();
            String sql = "insert into persona(idpersona, nombre, apellido, celular) values(?,?,?,?)";

            // preparar declaracion
            declaracion = conectar.prepareStatement(sql);
            declaracion.setInt(1, idPersona);
            declaracion.setString(2, fecha);
            declaracion.setInt(3, id_cliente);
            declaracion.setInt(4, total);
            declaracion.setInt(5, id_usuario);

            // ejecutar la insert
            int filasInsertadas = declaracion.executeUpdate();

            if (filasInsertadas > 0) {
                System.out.println(filasInsertadas + " filas insertadas");
            }

        } catch (SQLException e) {
            System.out.println("Error insertando datos" + e);

        } finally {
            try {
                if (declaracion != null) declaracion.close();
                if (conectar != null) conectar.close();
            } catch (SQLException e) {
                System.out.println(e);
            }
        }

    }

    public static void main(String[] args) {
        insertarVentas(4, "Maria", "Perez", 649873);
    }
}