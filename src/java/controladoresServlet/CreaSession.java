/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoresServlet;

import entidades.Camarero;
import entidades.Producto;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CreaSession extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Creamos una sesion, y la asociamos al usuario que nos visita
        //En la sesion se guardan objetos, listas, variables..
        HttpSession sesionRestaurante=request.getSession(true);
        //el producto es el objeto que vamos a mover
        Camarero ultimo_Camarero= new Camarero();
        ultimo_Camarero.setIdCamarero("2");
        ultimo_Camarero.setNombre("Pepe");
        ultimo_Camarero.setApellido("Garcia");
        //ultimo_Camarero.setEspecialidad("Especialidad");
        //Camarero ultimo_Camarero= new Camarero("1", "pepito", "grillo", "especialidad");
        //Producto miProducto = new Producto(1, "telefono", 300);
        //A traves de este atributo guardamos el objeto ultimocamarero
        sesionRestaurante.setAttribute("ejemploSession", ultimo_Camarero);
        //coloca el objeto en la session
        //sesionRestaurante.setAttribute("ejemploSesion", miProducto);
        //misession.setAttribute("producto", miproducto);
        PrintWriter pw = response.getWriter();
        pw.println("<html><body>Producto en session</body></html>");
        pw.println("<h2>"+sesionRestaurante.isNew()+"</h2>");
        pw.close();
    }


@Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
        public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
