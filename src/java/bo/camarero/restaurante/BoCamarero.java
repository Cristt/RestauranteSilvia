/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bo.camarero.restaurante;

import dao.camarero.restaurante.DaoCamarero;
import static dao.camarero.restaurante.DaoCamarero.insertarCamarero;
import entidades.Camarero;
import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BoCamarero {
    
    
    public static void procesarInsertarPeticionCamarero(HttpServletRequest request, HttpServletResponse response) throws SQLException, ClassNotFoundException, IOException {

        Camarero camarero = new Camarero();
        //recojemos los datos del formulario
        
        camarero.setIdCamarero(request.getParameter("idcamarero"));
        camarero.setNombre(request.getParameter("nombre"));
        camarero.setApellido(request.getParameter("apellido"));
        camarero.setEspecialidad(request.getParameter("especialidad"));
        //llamamos al metodo insertarCamarero
        DaoCamarero.insertarCamarero(camarero.getIdCamarero(), camarero.getNombre(), camarero.getApellido(),camarero.getEspecialidad());
        response.sendRedirect("/Restaurante/mostrarServletCamarero");

    }
    
}
