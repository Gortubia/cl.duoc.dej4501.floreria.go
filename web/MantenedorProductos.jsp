<%-- 
    Document   : MantenedorProductos
    Created on : 13-oct-2018, 15:08:25
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
     <jsp:useBean id="articulo" class="cl.duoc.dej4501.floreria.go.entity.Articulo" scope="page" ></jsp:useBean>
     <jsp:include page="./getArticulos" flush="true"></jsp:include> 
     <jsp:include page="Menu.jsp"></jsp:include>
         <div class="container">
             <div class="card mb-3"> 
             <c:choose>
                 <c:when test="${sessionScope.listadoArticulos==null}"> 
                     <div class="alert alert-warning" role="alert">
                         No se encuentran productos. Debe ir primero al ingreso de productos <a href="AddArticulo.jsp">Ingresar Productos</a>
                     </div> 
                 </c:when> 
                 <c:otherwise>  
                     <!-- DataTables Card-->
                     <div class="card-header">
                         <i class="fa fa-user"></i>Administrador de Productos</div>
                     <div class="card-body">
                         <div class="table-responsive">
                             <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                 <thead>
                                     <tr> 
                                         <th>Codigo</th>
                                         <th>Descripción</th> 
                                         <th>Precio</th> 
                                         <th>Tipo articulo</th> 
                                         <th>modificar</th> 
                                         <th>eliminar</th> 
                                     </tr>
                                 </thead>
                                 <tbody> 
                                     <c:forEach  items="${sessionScope.listadoArticulos}" var="articulo">
                                         <tr>
                                             <td><c:out value="${articulo.id_articulo}"></c:out> </td>
                                             <td><c:out value="${articulo.descrip_articulo}"></c:out> </td>
                                             <td><c:out value="${articulo.precio}"></c:out> </td>
                                             <td><c:out value="${articulo.descrip_tipoArticulo}"></c:out> </td>
                                             
                                             <c:url value="/modificarArticuloServlet" var="modificar">
                                                 <c:param name="codigo" value="${articulo.id_articulo}"></c:param>
                                             </c:url>
                                             <td><input type="button" class="btn btn-warning" name="btnModificar" value="Modificar" onclick="window.location.href = '${modificar}'"> </td>
                                             
                                             <c:url value="/eliminarProductoServlet" var="elimina">
                                                 <c:param name="codigo"  value="${articulo.id_articulo}"></c:param>
                                             </c:url>
                                             <td><input type="button" class="btn btn-danger" name="btnEliminar" value="Eliminar" onclick="window.location.href = '${elimina}'"> </td>
                                         </tr>
                                     </c:forEach>
                                 </tbody>
                             </table>
                         </div>
                     </div>
                     <div class="card-footer small text-muted">Floreria. Listado de productos</div>
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