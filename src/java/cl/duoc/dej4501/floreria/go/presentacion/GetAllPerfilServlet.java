/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.presentacion;

import cl.duoc.dej4501.floreria.go.controller.PerfilController; 
import cl.duoc.dej4501.floreria.go.entity.Perfil; 
import java.io.IOException; 
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 

/**
 *
 * @author adolf
 */
@WebServlet(name = "GetAllPerfilServlet", urlPatterns = {"/getAllPerfilServlet", "/getPerfiles"})
public class GetAllPerfilServlet extends HttpServlet {
    PerfilController objPerfilController;
    

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
        
        objPerfilController = new PerfilController();
        List<Perfil>listadoPerfil=objPerfilController.getAllPerfil();
        
        if(!listadoPerfil.isEmpty())
        {
        request.getSession().setAttribute("listadoPerfil", listadoPerfil);
        response.sendRedirect("AddUsuario.jsp");
        } 
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
