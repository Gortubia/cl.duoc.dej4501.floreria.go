/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.presentacion;

import cl.duoc.dej4501.floreria.go.controller.UsuarioController;
import cl.duoc.dej4501.floreria.go.entity.Usuario;
import java.io.IOException; 
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adolf
 */
@WebServlet(name = "GuardarUsuarioServlet", urlPatterns = {"/guardarUsuarioServlet"})
public class GuardarUsuarioServlet extends HttpServlet {
    UsuarioController objUsuarioController;
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        
           boolean flag =true;
        HttpSession sesion = request.getSession();
        
        String msgError = "";
        String login = "";
        String pass = "";

        if (validacion(request)) {
            msgError += "\n faltan datos de ingreso en el formulario.";
            sesion.setAttribute("msgError", msgError);            
        } else {
             try {
                login = request.getParameter("txtLogin"); 
            } catch (Exception ex) {
                msgError += "\nla login no corresponde"+ex;
                flag=false;
            }
              try {
                pass = request.getParameter("txtPass"); 
            } catch (Exception ex) {
                msgError += "\nla pass no corresponde"+ex;
                flag=false;
            }
            
            int perfil=0;
            try {
                perfil = Integer.parseInt(request.getParameter("ddlPerfil"));
            } catch (NumberFormatException ex) {
                msgError += "\nperfil no corresponde"+ex;
                flag=false;
            }
            
          
            
             
            if(flag){
                
             Usuario objUsuario = new Usuario( login, pass, perfil);
             objUsuarioController = new UsuarioController();
             
             if(objUsuarioController.agregarUsuario(objUsuario)){
                 request.getSession().setAttribute("msgError", "Usuario Creado");
                }else{
                     request.getSession().setAttribute("msgError", "no se pudo guardar datos");
                     }
                
            } 
        }
        response.sendRedirect("AddUsuario.jsp");
        
         
        
        
    }
     
    private boolean validacion(HttpServletRequest request) {
        return request.getParameter("txtLogin").isEmpty() 
                || request.getParameter("txtPass").isEmpty()
                || request.getParameter("ddlPerfil").isEmpty() ;
    
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
