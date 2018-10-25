/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.presentacion;

import cl.duoc.dej4501.floreria.go.controller.TipoArticuloController;
import cl.duoc.dej4501.floreria.go.entity.TipoArticulo;
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
@WebServlet(name = "GetAllTipoArticuloServlet", urlPatterns = {"/getAllTipoArticuloServlet","/tipoArticulos"})
public class GetAllTipoArticuloServlet extends HttpServlet {
        
  TipoArticuloController   objTipoArticuloController;
    
   

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
             objTipoArticuloController = new TipoArticuloController();
        List<TipoArticulo>listadoTipoArticulo=objTipoArticuloController.readElementos();
        
        if(!listadoTipoArticulo.isEmpty())
        {
        request.getSession().setAttribute("listadoTipoArticulo", listadoTipoArticulo);
        response.sendRedirect("ListarArticulos.jsp");
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
