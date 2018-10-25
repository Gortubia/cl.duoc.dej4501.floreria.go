<%-- 
    Document   : addPerfil
    Created on : 10-oct-2018, 21:29:11
    Author     : adolf
--%>
 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="es">

<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="Gustavo ortubia">
  <title>Floreria</title>
  <!-- Bootstrap core CSS--> 
    <!-- Custom styles for this template-->
  <link href="css/sb-admin.css" rel="stylesheet">
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
</head>

<body >
    <jsp:include page="Menu.jsp"></jsp:include>
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
                <div class="card card-register mx-auto mt-5">
                    <div class="card-header">Registro de Perfil</div>
                    <div class="card-body">
                        <form  name="frmGuardarPerfil" method="POST" action="./guardarPerfilServlet">
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <label for="lblperfil">Nombre Perfil</label> 
                                        <input class="form-control" name="txtPerfil" id="txtPerfil"  required="" maxlength="50"  type="text" placeholder="Nombre Perfil"/>
                                    </div> 
                                </div>
                          </div>
                        <div class="text-center">
                          <td><input class="btn btn-primary "  type="submit" value="Agregar"></td>
                        </div>
                </form>
            
        </div> 
    </div> 
</body>

</html>
