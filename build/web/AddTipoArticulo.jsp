<%-- 
    Document   : addTipoArticulo
    Created on : 12-oct-2018, 23:43:32
    Author     : adolf
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Floreria</title>
        
        <link rel="icon" href="./images/flor.ico">
        <!-- Bootstrap core CSS-->
        <link href="css/bootstrap.min.css" rel="stylesheet">
        <!-- Custom fonts for this template-->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css">
        <!-- Custom styles for this template-->
        <link href="css/sb-admin.css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    </head> 
   
    <body>  
         <jsp:include page="Menu.jsp" flush="true"/>  
        <div class="container">
            <div class="card card-login mx-auto mt-5">
                <div class="card-header">Agregar Tipo articulo</div>
                <div class="card-body">
                    <form name="frmGuardar" method="POST" action="./guardarTipoArticuloServlet">
                        <div class="form-group">
                            <label for="frTipoArt">Tipo articulo</label>
                            <input class="form-control" name="txtTipoArt" id="txtTipoArt" type="text" required=""  placeholder="Descripción del articulo">
                        </div> 

                        <div class="text-center">
                            <td><input class="btn btn-primary "  type="submit" value="Grabar"></td>
                        </div>
                    </form>

                </div>
            </div>
        </div>
        <c:if test="${sessionScope.msgError != null}"> 
            <div class="alert alert-success" role="alert"  >
                <c:if test="${sessionScope.msgError!=null}"> 
                    <fieldset><legend>Mensajes</legend>
                        <c:out value="${sessionScope.msgError}"></c:out>
                        <c:remove var="msgError"></c:remove>
                        </fieldset> 
                </c:if>
            </c:if>
         
         <section class="page-section clearfix">
      <div class="container">
        <div class="intro">
          <img class="intro-img img-fluid mb-3 mb-lg-0 rounded" src="img/intro.jpg" alt="">
          <div class="intro-text left-0 text-center bg-faded p-5 rounded">
            <h2 class="section-heading mb-4">
              <span class="section-heading-upper">Flores frescas</span>
              <span class="section-heading-lower">Variedad de flores</span>
            </h2>
            <p class="mb-3">Every cup of our quality artisan coffee starts with locally sourced, hand picked ingredients. Once you try it, our coffee will be a blissful addition to your everyday morning routine - we guarantee it!
            </p>
            <div class="intro-button mx-auto">
              <a class="btn btn-primary btn-xl" href="#">Visit Us Today!</a>
            </div>
          </div>
        </div>
      </div>
    </section>
                
            <jsp:include page="MenuPie.jsp" flush="true"></jsp:include>
    </body>
</html>