/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.cocinero.restaurante;

import static dao.cocinero.restaurante.daoCocinero.insertarCocinero;
import entidades.Cocinero;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoCocinero {
        public static void procesarPeticionCocinero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Cocinero cooker = new Cocinero();
        cooker.setIdCocinero(Integer.parseInt(request.getParameter("idcocinero")));
        cooker.setNombre(request.getParameter("nombre"));
        cooker.setApellido(request.getParameter("apellido"));

        insertarCocinero(cooker.getIdCocinero(), cooker.getNombre(), cooker.getApellido());
        response.sendRedirect("/RestauranteSilvia/mostrarServletCocinero");

    }
}
