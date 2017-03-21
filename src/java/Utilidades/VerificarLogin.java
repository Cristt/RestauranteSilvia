package Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class VerificarLogin {

    public static boolean comprobarLogin(String usuario, String password) throws ClassNotFoundException, SQLException {
        
        boolean nRegistro = false;
        String sql = "select * from logeados where usuario='" + usuario + "' AND password='" + password + "'";
        Connection con = ConexionRestaurante.conexionRestaurante();
        PreparedStatement comprobarLogin = con.prepareStatement(sql);
        //hay que usar un executeQuery porque es un select. porque tiene que devolver un conjunto de resultados (RESULTSET)
        //si devuelve resultado, devuelve true, el login es correcto
        ResultSet rs = comprobarLogin.executeQuery(sql);

        if (rs.next()) {

            nRegistro = true;

        }
        
        return nRegistro;
    }
}
