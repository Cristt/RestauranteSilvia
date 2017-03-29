
package dao.cocinero.restaurante;

import Utilidades.ConexionRestaurante;
import entidades.Cocinero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DaoCocinero {

    public static void insertarCocinero(int idcocinero, String nombre, String apellido) throws SQLException, ClassNotFoundException {

        Connection conexion = ConexionRestaurante.conexionRestaurante();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into cocinero (idcocinero,nombre,apellido) values ";
        consultaSQL += "('" + idcocinero + "','" + nombre + "','" + apellido + "')";
        sentencia.executeUpdate(consultaSQL);
        sentencia.close();
        conexion.close();
    }
    
    public static ResultSet verCocineros(int idcocinero, String nombre, String apellido) throws ClassNotFoundException, SQLException{
    
    Connection conexion=ConexionRestaurante.conexionRestaurante();
    Statement sentencia = conexion.createStatement();
    String consultaSQL = "select idcocinero,nombre,apellido from cocinero";
    ResultSet lista_cocineros=sentencia.executeQuery(consultaSQL);
    
    return lista_cocineros;

    }

    
    public static void actualizarCocinero(int idcocinero, String nombre) throws SQLException, ClassNotFoundException{
    
        Connection conexion = ConexionRestaurante.conexionRestaurante();
        String consultaSQL = "update camarero set nombre=? where idcamarero=?";
        PreparedStatement actualizar = conexion.prepareStatement(consultaSQL);
        actualizar.setString(1, nombre);
        actualizar.setInt(2, idcocinero);
        int filasAfectadas = actualizar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
        actualizar.close();
        conexion.close();
    }
    
     public static void borrarRegistro(int idcocinero) throws SQLException, ClassNotFoundException {
        Connection conexion = ConexionRestaurante.conexionRestaurante();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "delete from cocinero where idcocinero=?";
        PreparedStatement buscar = conexion.prepareStatement(consultaSQL);
        buscar.setInt(1, idcocinero);
        // el execute update solo devuelve el numero de filas afectadas
        int filasAfectadas = buscar.executeUpdate();
        System.out.println("Filas afectadas: " + filasAfectadas);
    }
    
    }
    
    /**public static void procesarPeticionCocinero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Cocinero cooker = new Cocinero();
        cooker.setIdCocinero(Integer.parseInt(request.getParameter("idcocinero")));
        cooker.setNombre(request.getParameter("nombre"));
        cooker.setApellido(request.getParameter("apellido"));

        insertarCocinero(cooker.getIdCocinero(), cooker.getNombre(), cooker.getApellido());
        response.sendRedirect("/RestauranteSilvia/mostrarServletCocinero");

    }**/


    
