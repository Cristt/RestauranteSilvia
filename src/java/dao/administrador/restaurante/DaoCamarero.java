package dao.camarero.restaurante;

import Utilidades.ConexionRestaurante;
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

public class DaoCamarero {

    public static void insertarCamarero(String idcamarero, String nombre, String apellido, String especialidad) throws SQLException, ClassNotFoundException {

        Connection conexion = ConexionRestaurante.conexionRestaurante();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "insert into camarero (idcamarero,nombre,apellido,especialidad) values ";
        consultaSQL += "('" + idcamarero + "','" + nombre + "','" + apellido + "','" + especialidad + "')";
        sentencia.executeUpdate(consultaSQL);
        int filas=sentencia.executeUpdate(consultaSQL);
        System.out.println("nº filas afectadas: " +filas);
        sentencia.close();
        ConexionRestaurante.cerrarConexion();
        //antes de cerrar la conexion en conexRestaurante, cerrabamos la conexion desde este metodo
        //conexion.close();

    }

    public static ResultSet verCamareros() throws ClassNotFoundException, SQLException {
// pasara a ser clase de negocio
        Connection conexion = ConexionRestaurante.conexionRestaurante();
        Statement sentencia = conexion.createStatement();
        String consultaSQL = "select idcamarero,nombre,apellido,especialidad from camarero";
        ResultSet lista_camareros = sentencia.executeQuery(consultaSQL);
        //insertarCamarero(camata.getIdCamarero(), camata.getNombre(), camata.getApellido(), camata.getEspecialidad());
        ConexionRestaurante.cerrarConexion();
        return lista_camareros;

    }

    public static void procesarPeticionCamarero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Camarero camarero = new Camarero();
        //recojemos los datos del formulario
        camarero.setIdCamarero(request.getParameter("idcamarero"));
        camarero.setNombre(request.getParameter("nombre"));
        camarero.setApellido(request.getParameter("apellido"));
        camarero.setEspecialidad(request.getParameter("especialidad"));
        //llamamos al metodo insertarCamarero
        insertarCamarero(camarero.getIdCamarero(), camarero.getNombre(), camarero.getApellido(),camarero.getEspecialidad());
        response.sendRedirect("/Restaurante/mostrarServletCamarero");

    }
//faltan UPDATE y DELETE

    }





    

