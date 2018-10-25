/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.presentacion;

import cl.duoc.dej4501.floreria.go.controller.ArticuloController;
import cl.duoc.dej4501.floreria.go.controller.TipoArticuloController;
import cl.duoc.dej4501.floreria.go.entity.Articulo;
import cl.duoc.dej4501.floreria.go.entity.TipoArticulo;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "GetAllArticulosServlet", urlPatterns = {"/getAllArticulosServlet","/getArticulos"})
public class GetAllArticulosServlet extends HttpServlet {

    ArticuloController objArticuloController;
   
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
        
          objArticuloController = new ArticuloController();
        List<Articulo>listadoArticulos=objArticuloController.readElementos();
        
        if(!listadoArticulos.isEmpty())
        {
        request.getSession().setAttribute("listadoArticulos", listadoArticulos);
        response.sendRedirect("MantenedorProductos.jsp");
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
