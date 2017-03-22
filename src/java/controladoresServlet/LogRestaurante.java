package controladoresServlet;

import Utilidades.VerificarLogin;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogRestaurante extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {

        /*recojemos parametros del formulario de LOGIN.html*/
        //login_usuario y login_password contienen implicitos los valores de "root" , "root"
        String user_login = request.getParameter("login_usuario"); //Esta es la clave que devuelve un valor
        String pass_login = request.getParameter("login_password");

        /* COMENTADO PARA HACER EL VERIFICAR LOGIN 
         HttpSession sesion_login=request.getSession();
         //a traves de los atributos usuario y password_sesion en el objeto sesion_login
         //login_usuario y login_password contienen implicitos los valores de "root" , "root", aunque cambien su valor
         sesion_login.setAttribute("login_usuario", user_login);
         sesion_login.setAttribute("login_password", pass_login);*/
        boolean verificarUsuario = VerificarLogin.comprobarLogin(user_login, pass_login);

        if (verificarUsuario == true) {
            //colocamos la variable log en la sesion
            boolean log = true;
            HttpSession sesion_login = request.getSession();
            //Lo guardo en la sesion
            sesion_login.setAttribute("login_usuario", user_login);
            sesion_login.setAttribute("login_password", pass_login);
            //la variable log nos sirve para comprobar en el resto de servlets si el usuario esta logeado en otros servlet
            sesion_login.setAttribute("ok", log);

            response.sendRedirect("/RestauranteSilvia/altas.htm");
        } else {

            response.sendRedirect("/RestauranteSilvia/login.html");
            System.out.println("Valor " + verificarUsuario);
        }

        /* BORRADO PARA HACER EL VERIFICAR LOGIN
         //Aqui compruebo los valores recibidos del formulario (los que el usuario va a meter)
         //el valor puede ser user, o pass
         if(user_login.contains("root") && pass_login.contains("root")){
         response.sendRedirect("/RestauranteSilvia/registroCamarero.html");
         }else{
         response.sendRedirect("/RestauranteSilvia/login.html");
         }*/
        /*response.setContentType("text/html;charset=UTF-8");
         try (PrintWriter out = response.getWriter()) {
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<title>Servlet LogRestaurante</title>");            
         out.println("</head>");
         out.println("<body>");
         out.println("<h1>Servlet LogRestaurante at " + request.getContextPath() + "</h1>");
         out.println("</body>");
         out.println("</html>");
         }
         */
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LogRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LogRestaurante.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
