package Utilidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class VerificarLogin {

    public static boolean comprobarLogin(String usuario, String password) throws ClassNotFoundException, SQLException {
        
        boolean nRegistro = false;
        //esto viene del FORMULARIO
        String sql = "select * from logeados where usuario='" + usuario + "' AND password='" + password + "'";
        //reutilizamos el metodo conexionRestaurante, y lo guardamos en un objeto de su misma clase
        Connection con = ConexionRestaurante.conexionRestaurante();
        //Con un Statement valdría, esta frase carga la sentencia
        PreparedStatement comprobarLogin = con.prepareStatement(sql);
        //hay que usar un executeQuery porque es un select. porque tiene que devolver un conjunto de resultados (RESULTSET)
        //si devuelve resultado, devuelve true, el login es correcto
        ResultSet rs = comprobarLogin.executeQuery(sql);
        if (rs.next()) {
        //Aqui se cambia el estado de la variable
            nRegistro = true;

        }
        //devuelve el resultado del login
        return nRegistro;
    }
}
