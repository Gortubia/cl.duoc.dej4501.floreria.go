<%-- 
    Document   : login
    Created on : 10-oct-2018, 21:13:47
    Author     : adolf
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html> 
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./images/flor.ico">

    <title>Signin</title>

    <!-- Bootstrap core CSS -->
   <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">

    <!-- Custom styles for this template -->
    <link href="./css/signin.css" rel="stylesheet">
  </head>

  <body class="text-center">
    <form class="form-signin" name="formIngreso" action="./validaUsuarioServlet" method="post">
      <img class="mb-4" src="./images/marmota.jpg" alt="" width="72" height="122"> 
      <h1 class="h3 mb-3 font-weight-normal">Por favor ingrese</h1>
      <label for="inputLogin" class="sr-only">Login:</label>
      <input type="txt"  name="txtLogin" class="form-control" placeholder="Login" required autofocus>
      <label for="inputPassword" class="sr-only">Password</label>
      <input type="password"   name="txtPass" class="form-control" placeholder="Password" required>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Ingresar</button>
      
      <div>
         <div class="form-group">
          <div class="form-row">
               <div class="col-md-12">
                 <c:if test="${sessionScope.msgError!=null}">
            <div class="alert alert-warning" role="alert">
            <fieldset><legend>Mensajes</legend>
                <c:out value="${sessionScope.msgError}"></c:out>
                <c:remove var="msgError"></c:remove>
            </div>

                </fieldset>
        </c:if>
               </div> 
                  </div>
              </div>
      </div>
     <p class="mt-5 mb-3 text-muted">&copy; 2017-2018</p>
    </form>
      
      
        
        
         
     
     
    
      
  </body>
</html>
