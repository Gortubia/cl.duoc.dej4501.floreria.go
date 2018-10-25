<%-- 
    Document   : ListarArticulos
    Created on : 15-oct-2018, 2:27:39
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
 </head >
 <body class="bg-dark"> 
     <jsp:include page="./tipoArticulos" flush="true"></jsp:include> 
     <jsp:include page="Menu.jsp"></jsp:include>
         <div class="container">
             <div class="card mb-3"> 
             <c:choose>
                 <c:when test="${sessionScope.listadoTipoArticulo==null}"> 
                     <div class="alert alert-warning" role="alert">
                         No se encuentran Articulos. Debe ir primero al ingreso de Articulos <a href="AddArticulo.jsp">Ingresar Articulos</a>
                     </div> 
                 </c:when> 
                 <c:otherwise>  
                     <!-- DataTables Card-->
                     <div class="card-header">
                         <i class="fa fa-user"></i> Listado de Articulos</div>
                     <div class="card-body">
                         <div class="table-responsive">
                             <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                 <thead>
                                     <tr> 
                                         <th>Codigo</th>
                                         <th>Descripción</th> 
                                     </tr>
                                 </thead>
                                 <tbody> 
                                     <c:forEach  items="${sessionScope.listadoTipoArticulo}" var="tipoArticulo">
                                         <tr>
                                             <td><c:out value="${tipoArticulo.id_tipoArticulo}"></c:out> </td>
                                             <td><c:out value="${tipoArticulo.descrip_tipoArticulo}"></c:out> </td> 
                                         </tr>
                                     </c:forEach>
                                 </tbody>
                             </table>
                         </div>
                     </div>
                     <div class="card-footer small text-muted">Floreria. Listado de Articulos</div>
                 </div>
             </div>

         </c:otherwise>
     </c:choose>
      <c:if test="${sessionScope.msgError!=null}">
         <fieldset>
             <div class="alert alert-warning" role="alert">
                 <legend>Mensajes</legend> 
                 <c:out value="${sessionScope.msgError}"></c:out>
                 <c:remove var="msgError"></c:remove>
                 </div>
             </fieldset>
     </c:if>
 </body>
</html>