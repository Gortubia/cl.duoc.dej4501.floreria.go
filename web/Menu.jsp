<%-- 
    Document   : Mune
    Created on : 13-oct-2018, 13:17:28
    Author     : adolf
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Floreria</title>
        <link rel="icon" href="./images/flor.ico">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
        <script type="text/javascript" src="js/prototype.js"></script>
        <script type="text/javascript" src="js/validation.js"></script> 
           <!-- Custom styles for this template -->
    <link href="./css/business-casual.min.css" rel="stylesheet">
    </head>
    <body  >
         <jsp:include page="/menu" flush="true"/>
        <jsp:useBean id="usuarioConectado" class="cl.duoc.dej4501.floreria.go.entity.Usuario" scope="session"/>
        <jsp:useBean id="objMenuPadre" class="cl.duoc.dej4501.floreria.go.entity.Menu" scope="page"></jsp:useBean>
        <jsp:useBean id="objMenuHijo" class="cl.duoc.dej4501.floreria.go.entity.Menu" scope="page"></jsp:useBean> 
        <h4 style="color: dodgerblue">Usuario: <c:out value="${usuarioConectado.login_usuario}"/></h4>
        <a style="color:  darkorange" href=".\cerrarSesion">Cerrar Sesion</a>
        
        <h1 class="site-heading text-center text-white d-none d-lg-block">
      <span class="site-heading-upper text-primary mb-3">Tienda floreria</span>
      <span class="site-heading-lower">Compra de flores web</span>
    </h1> 
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark py-lg-4" id="mainNav">
         <div class="container" id="menu">
            <a class="navbar-brand text-uppercase text-expanded font-weight-bold d-lg-none" href="#">Libreria</a>
              <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
                </button>
              <div class="collapse navbar-collapse" id="navbarResponsive">
                  <div id="menu">
            <ul class="navbar-nav mx-auto">
                <c:forEach items="${listadoMenu}" var="objMenuPadre">                    
                    <c:if test="${objMenuPadre.padre_menu==0}">
                        <li class="nav-item px-lg-4">
                            <a class="verSub" style="color: darkorange"  href="javascript:;"><c:out value="${objMenuPadre.nombre_menu}"></c:out></a>
                                <ul class="subMenu">                                    
                                <c:forEach items="${listadoMenu}" var="objMenuHijo"> 
                                    <c:if test="${objMenuHijo.id_menu!=0 && objMenuPadre.id_menu==objMenuHijo.padre_menu}">                                                             
                                        <li class="nav-item px-lg-4">
                                            <a class="nav-link text-uppercase text-expanded" href="<c:out value="${objMenuHijo.destino_menu}"/>"><c:out value="${objMenuHijo.nombre_menu}"></c:out></a>
                                        </li>                       
                                     </c:if>
                                 </c:forEach>
                              </c:if>
                        </ul>
                    </li>
                </c:forEach>
            </ul>
        </div> 
                </div>
            </div>
        </nav>
     
        

        <script type="text/javascript">
            $$('.subMenu').each(function(e) {
                var menu = e.previous().innerHTML,
                        menOpen = 'Movimientos';
                if (menu !== menOpen) {
                    e.hide();
                }
            });
            $$('.verSub').each(function(e) {
                e.observe('click', function() {
                    e.next().toggle();
                });
            });
        </script>   
    </body>
</html>
