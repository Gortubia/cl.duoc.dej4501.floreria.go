<%-- 
    Document   : MantenedorPerfil
    Created on : 10-oct-2018, 21:14:02
    Author     : adolf
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
     <link rel="icon" href="./images/flor.ico">
    <title>Floreria</title>
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
       
        <jsp:useBean   id="perfil" class="cl.duoc.dej4501.floreria.go.entity.Perfil" scope="page" ></jsp:useBean>
        <jsp:include page="./getPerfiles" flush="true"></jsp:include> 
        <div class="container">
        <c:if test="${sessionScope.msgError != null}"> 
            <div class="alert alert-success" role="alert"  >
                <c:if test="${sessionScope.msgError!=null}"> 
                    <fieldset><legend>Mensajes</legend>
                        <c:out value="${sessionScope.msgError}"></c:out>
                        <c:remove var="msgError"></c:remove>
                        </fieldset> 
                </c:if>
            </div>
        </c:if>
        <!-- Example DataTables Card-->
          <div class="card mb-3">
            <div class="card-header">
              <i class="fa fa-user"></i> Listado de Perfil</div>
            <div class="card-body">
                <div  class="dropdown-item">  <input type="button" class="btn btn-primary" name="btnAgregar" value="Agregar Perfil"  onclick="window.location.href = 'AddPerfil.jsp'">  </div>
              <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">

                  <thead>
                    <tr> <th>Id perfil</th> 
                         <th>Tipo perfil</th>   
                         <td colspan="1">Acciones</td> 
                    </tr>
                  </thead>

                  <tbody>
                   <c:forEach items="${sessionScope.listadoPerfil}" var="perfil">
                            <tr>
                                <td><c:out value="${perfil.id_perfil}"></c:out> </td>  
                                <td><c:out value="${perfil.tipo_perfil}"></c:out> </td>   
                                 
                                <c:url value="./eliminarPerfil" var="eliminar">
                                    <c:param name="codigo" value="${perfil.id_perfil}"></c:param>
                                </c:url>
                                <td><input type="button" class="btn btn-danger" name="btnEliminar" value="Eliminar" onclick="window.location.href = '${eliminar}'"> </td>
                           
                                 
                            </tr>
                        </c:forEach>
                   
                         
                           
                                
                    </tbody>
                </table>
              </div>
            </div>
            <div class="card-footer small text-muted"> Listado de perfil</div>
          </div>
         </div>     
    </body>
</html>
