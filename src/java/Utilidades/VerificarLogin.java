package Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class VerificarLogin {

    public static boolean comprobarLogin(String usuario, String password) throws ClassNotFoundException, SQLException {
        
        boolean nRegistro = false;
        
        String sql = "select * from logeados where usuario='" + usuario + "' AND password='" + password + "'";
        
        Connection con = ConexionRestaurante.conexionRestaurante();
       
        PreparedStatement comprobarLogin = con.prepareStatement(sql);

        ResultSet rs = comprobarLogin.executeQuery(sql);
        if (rs.next()) {

            nRegistro = true;

        }
   
        return nRegistro;
    }
}
