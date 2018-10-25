<%-- 
    Document   : home
    Created on : 10-oct-2018, 21:13:26
    Author     : adolf
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="./images/flor.ico">
    <title>Floreria</title>

    <!-- Bootstrap core CSS -->
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
     <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
   
    <!-- Custom fonts for this template -->
    <link href="https://fonts.googleapis.com/css?family=Raleway:100,100i,200,200i,300,300i,400,400i,500,500i,600,600i,700,700i,800,800i,900,900i" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="./css/business-casual.min.css" rel="stylesheet">

  </head>

  <body>
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
      <!-- Navigation -->
      <jsp:include page="Menu.jsp" flush="true"/> 


      <section class="page-section clearfix">
          <div class="container">
              <div class="intro">
                  <img class="intro-img img-fluid mb-3 mb-lg-0 rounded" src="img/ramode12.jpg" alt="">
                  <div class="intro-text left-0 text-center bg-faded p-5 rounded">
                      <h2 class="section-heading mb-4">
                          <span class="section-heading-upper">Flores frescas</span>
                          <span class="section-heading-lower">Ramo extendido con 12 rosas e hypericum</span>
                      </h2>
                      <p class="mb-3">Bello ramo extendido con 12 rosas ecuatorianas de tallo largo, color a elección, acompañadas con hipericum, envuelto en papel metalizado y con un moño.
                      </p>
                      <div class="intro-button mx-auto">
                          <a class="btn btn-primary btn-xl" href="#">$30.900</a>
                      </div>
                  </div>
              </div>
          </div>
      </section>

      <section class="page-section cta">
          <div class="container">
              <div class="row">
                  <div class="col-xl-9 mx-auto">
                      <div class="cta-inner text-center rounded">
                          <h2 class="section-heading mb-4">
                              <span class="section-heading-upper">No me olvides</span>
                              <span class="section-heading-lower">Empresa</span>
                          </h2>
                          <p class="mb-0">Nuestra misión no solo es entregar bellos arreglos florales a domicilio, sino que entendemos nuestro trabajo como un medio de comunicación para trasmitir emociones; cada vez que usted compra con nosotros no solo obtiene productos de primera calidad sino que un servicio integral donde cada detalle cuenta para entregar el mensaje que usted está enviando, puede ser un mensaje de amor, agradecimiento, felicitaciones o condolencias, en cualquier caso nuestra empresa pondrá todos nuestros esfuerzos en satisfacer ese deseo, cuidamos de cada detalle, para que nuestros clientes logren transmitir este mensaje con un regalo único y bello que signifique un recuerdo inolvidable.</p>
                      </div>
                  </div>
              </div>
          </div>
      </section>

 <jsp:include page="MenuPie.jsp" flush="true"/> 

  </body>

</html>
