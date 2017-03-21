package dao.administrador.restaurante;

import dao.camarero.restaurante.*;
import Utilidades.ConexionRestaurante;
import entidades.Administrador;
import entidades.Camarero;
import entidades.Cocinero;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class daoAdministrador {


    public static void insertarAdministrador(String usuario,String password,String nombre_administrador,String apellido_administrador) throws ClassNotFoundException, SQLException{
        
        Connection conexion = ConexionRestaurante.conexionRestaurante();
        String consultaSQL = "insert into logeados (usuario,password,nombre_administrador,apellido_administrador) values ";
        consultaSQL += "('" + usuario + "','" + password + "','" + nombre_administrador + "','" + apellido_administrador + "')";
        Statement sentencia = conexion.createStatement();
        int filas=sentencia.executeUpdate(consultaSQL);
        System.out.println("nº filas afectadas: " +filas);
        sentencia.close();
        ConexionRestaurante.cerrarConexion();
        //antes de cerrar la conexion en conexRestaurante, cerrabamos la conexion desde este metodo
        //conexion.close();
    }
    public static void procesarPeticionAdministrador(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Administrador administrador = new Administrador();
        //recojemos los datos del formulario
        administrador.setUsuario(request.getParameter("usuario_administrador"));
        administrador.setPassword(request.getParameter("password_administrador"));
        administrador.setNombre_administrador(request.getParameter("nombre_administrador"));
        administrador.setApellido_administrador(request.getParameter("apellido_administrador"));
        //llamamos al metodo insertarCamarero
        insertarAdministrador(administrador.getUsuario(), administrador.getPassword(), administrador.getNombre_administrador(),administrador.getApellido_administrador());
        response.sendRedirect("/RestauranteSilvia/mostrarServletAdministrador");

    }
     
}

   
//faltan UPDATE y DELETE

    





    

