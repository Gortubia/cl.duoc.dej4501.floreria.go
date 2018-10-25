/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.presentacion;

import cl.duoc.dej4501.floreria.go.controller.PerfilController;
import cl.duoc.dej4501.floreria.go.entity.Perfil;
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
@WebServlet(name = "GuardarPerfilServlet", urlPatterns = {"/guardarPerfilServlet"})
public class GuardarPerfilServlet extends HttpServlet {

    PerfilController objPerfilController;
     
 
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
        HttpSession sesion = (HttpSession) request.getSession();
        
        String msgError = "";
        String perfil = ""; 

        if (validacion(request)) {
            msgError += "\n faltan datos de ingreso en el formulario.";
            sesion.setAttribute("msgError", msgError);            
        } else {
             try {
                perfil = request.getParameter("txtPerfil"); 
            } catch (Exception ex) {
                msgError += "\nPerfil no corresponde"+ex;
                flag=false;
            } 
             
            if(flag){
                
             Perfil objPerfil = new Perfil( perfil);
             objPerfilController = new PerfilController();
             
             if(objPerfilController.addPerfil(objPerfil)){
                 request.getSession().setAttribute("msgError", "Perfil Creado");
                }else{
                     request.getSession().setAttribute("msgError", "no se pudo guardar datos");
                     }
                
            } 
        }
        response.sendRedirect("AddPerfil.jsp");
        
         
        
        
    }
     
    private boolean validacion(HttpServletRequest request) {
        return request.getParameter("txtPerfil").isEmpty()   ;
    
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
