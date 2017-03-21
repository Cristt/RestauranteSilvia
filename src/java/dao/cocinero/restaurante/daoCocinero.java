
package dao.cocinero.restaurante;

import Utilidades.ConexionRestaurante;
import entidades.Cocinero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class daoCocinero {

    public static void insertarCocinero(int idCocinero, String nombre, String apellido) throws SQLException, ClassNotFoundException {

        Connection conexion = ConexionRestaurante.conexionRestaurante();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into cocinero (idcocinero,nombre,apellido) values ";
        consultaSQL += "('" + idCocinero + "','" + nombre + "','" + apellido + "')";
        sentencia.executeUpdate(consultaSQL);
        sentencia.close();
        conexion.close();

    }
    
    public static void procesarPeticionCocinero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Cocinero cooker = new Cocinero();
        cooker.setIdCocinero(Integer.parseInt(request.getParameter("idcocinero")));
        cooker.setNombre(request.getParameter("nombre"));
        cooker.setApellido(request.getParameter("apellido"));

        insertarCocinero(cooker.getIdCocinero(), cooker.getNombre(), cooker.getApellido());
        response.sendRedirect("/RestauranteSilvia/mostrarServletCocinero");

    }

    public static ResultSet verCocineros() throws ClassNotFoundException, SQLException {

        Connection conexion = ConexionRestaurante.conexionRestaurante();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "select idcocinero,nombre,apellido from cocinero";
        ResultSet lista_cocineros = sentencia.executeQuery(consultaSQL);
        return lista_cocineros;

    }

}
