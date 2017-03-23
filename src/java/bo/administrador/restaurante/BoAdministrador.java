/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.administrador.restaurante;

import static dao.administrador.restaurante.DaoAdministrador.insertarAdministrador;
import entidades.Administrador;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author admin
 */
public class BoAdministrador {
        public static void procesarInsertarPeticionAdministrador(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

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
