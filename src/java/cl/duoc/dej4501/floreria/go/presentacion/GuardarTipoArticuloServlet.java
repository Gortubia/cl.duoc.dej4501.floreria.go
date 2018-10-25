/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.presentacion;

import cl.duoc.dej4501.floreria.go.controller.TipoArticuloController;
import cl.duoc.dej4501.floreria.go.entity.TipoArticulo;
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
@WebServlet(name = "GuardarTipoArticuloServlet", urlPatterns = {"/guardarTipoArticuloServlet"})
public class GuardarTipoArticuloServlet extends HttpServlet {

     TipoArticuloController objTipoArticuloController;

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
        String desc_tipoArticulo = "";

        if (validacion(request)) {
            msgError += "\n faltan datos de ingreso en el formulario.";
            sesion.setAttribute("msgError", msgError);            
        } else {
             try {
                desc_tipoArticulo = request.getParameter("txtTipoArt"); 
            } catch (Exception ex) {
                msgError += "\nla edad no corresponde"+ex;
                flag=false;
            }
             
            if(flag){
                
             TipoArticulo objTipoArticulo = new TipoArticulo(desc_tipoArticulo);
             objTipoArticuloController = new TipoArticuloController();
             
             if(objTipoArticuloController.agregarTipoArticulo(objTipoArticulo)){
                 request.getSession().setAttribute("msgError", "Articulo Creado");
                }else{
                     request.getSession().setAttribute("msgError", "no existe informacion");
                     }
                
            } 
        }
        response.sendRedirect("Home.jsp");
        
         
        
        
    }
    
    
    private boolean validacion(HttpServletRequest request) {
        return request.getParameter("txtTipoArt").isEmpty();
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
