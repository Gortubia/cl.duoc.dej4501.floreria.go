/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.dej4501.floreria.go.presentacion;

import cl.duoc.dej4501.floreria.go.controller.ArticuloController;
import cl.duoc.dej4501.floreria.go.controller.TipoArticuloController;
import cl.duoc.dej4501.floreria.go.entity.Articulo;
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
@WebServlet(name = "GuardarArticuloServlet", urlPatterns = {"/guardarArticuloServlet"})
public class GuardarArticuloServlet extends HttpServlet {
 
    
    ArticuloController objArticuloController;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
    }
 
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
                desc_tipoArticulo = request.getParameter("txtdescrip_articulo"); 
            } catch (Exception ex) {
                msgError += "\nla edad no corresponde"+ex;
                flag=false;
            }
             
            int precio=0;
            try {
                precio = Integer.parseInt(request.getParameter("txtPrecio"));
            } catch (NumberFormatException ex) {
                msgError += "\nEl precio no corresponde"+ex;
                flag=false;
            }
            
            int tipoArticulo=0;
            try {
                tipoArticulo = Integer.parseInt(request.getParameter("ddlTipoArticulo"));
            } catch (NumberFormatException ex) {
                msgError += "\nEl Tipo articulo no corresponde"+ex;
                flag=false;
            }
            
            int stock=0;
            try {
                stock = Integer.parseInt(request.getParameter("txtStock"));
            } catch (NumberFormatException ex) {
                msgError += "\nEl stock no corresponde"+ex;
                flag=false;
            }
            
             
            if(flag){
                
             Articulo objArticulo = new Articulo(desc_tipoArticulo,precio,stock,tipoArticulo);
             objArticuloController = new ArticuloController();
             
             if(objArticuloController.agregarTipoArticulo(objArticulo)){
                 request.getSession().setAttribute("msgError", "Articulo Creado");
                }else{
                     request.getSession().setAttribute("msgError", "no se pudo guardar producto");
                     }
                
            } 
        }
        response.sendRedirect("AddArticulo.jsp");
        
         
        
        
    }
     
    private boolean validacion(HttpServletRequest request) {
        return request.getParameter("txtdescrip_articulo").isEmpty() 
                || request.getParameter("txtPrecio").isEmpty()
                || request.getParameter("ddlTipoArticulo").isEmpty()
                || request.getParameter("txtStock").isEmpty();
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
