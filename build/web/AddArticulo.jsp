<%-- 
    Document   : addArticulo
    Created on : 12-oct-2018, 23:41:23
    Author     : adolf
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

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

<body class="bg-dark">
    <jsp:include page="Menu.jsp"></jsp:include>
    <jsp:include page="./getAllTipoArticuloServlet" flush="true"></jsp:include>
    <jsp:useBean id="tipoArticulo" class="cl.duoc.dej4501.floreria.go.entity.TipoArticulo" scope="page"></jsp:useBean>

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
        <c:choose>
            <c:when test="${sessionScope.listadoTipoArticulo==null}"> 
                <div class="alert alert-warning" role="alert">
                    No se encuentran Tipo de articulos. Debe ir primero al ingreso de Tipo articulos <a href="AddTipoArticulo.jsp">Ingresar Tipo articulo</a>
                </div> 
            </c:when>
            <c:otherwise>
                <div class="card card-register mx-auto mt-5">
                    <div class="card-header">Registro de Articulos</div>
                    <div class="card-body">
                        <form  name="frmGuardarArticulo" method="POST" action="./guardarArticuloServlet">
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <label for="lblDescArt">Descripción de articulo</label> 
                                        <input class="form-control" name="txtdescrip_articulo" id="txtdescrip_articulo"  required="" maxlength="50"  type="text" placeholder="Descripción del articulo"/>
                                    </div>
                                    <div class="col-md-6">
                                        <label for="lblPrecio">Precio</label>
                                        <input class="form-control"   name="txtPrecio" id="txtPrecio" required="" maxlength="20"  type="text"  placeholder="Precio"/>
                                    </div> 
                                </div>
                            </div>
                            <div class="form-group">
                                <div class="form-row">
                                    <div class="col-md-6">
                                        <div class="form-group">
                                            <label for="ddlTipoArticulo">Tipo articulo</label>
                                            <select class="form-control" name="ddlTipoArticulo" id="ddlTipoArticulo" required="">
                                                <option value="">-seleccione-</option>
                                                <c:forEach items="${sessionScope.listadoTipoArticulo}" var="tipoArticulo">
                                                    <option value="${tipoArticulo.id_tipoArticulo}"><c:out value="${tipoArticulo.descrip_tipoArticulo}"></c:out></option>
                                                </c:forEach>
                                            </select>
                                        </div>  
                                    </div>
                                    <div class="col-md-6">
                                        <label for="lblStock">Stock</label>
                                        <input class="form-control"   name="txtStock" id="txtStock" required="" maxlength="20"  type="number"  placeholder="Stock"/>
                                    </div> 
                                </div>
                            </div> 
                            <div class="text-center">
                                <td><input class="btn btn-primary "  type="submit" value="Agregar"></td>
                            </div>
                        </c:otherwise>
                    </c:choose>

                </form>
            </div>
        </div> 
    </div> 


</body>

</html>
