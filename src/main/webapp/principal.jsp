
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PachAcademy</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
    </head>
    <body>
        <div class="container">
            <c:choose>
                <c:when test="${nombreUsuario != null}">
            <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">PachAcademy</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-item nav-link active" href="#">Home <span class="sr-only">(current)</span></a>
                        <a class="nav-item nav-link" href="UsuarioServlet?accion=listaDeUsuarios">Lista de Usuarios</a>
                        <a class="nav-item nav-link" href="CarreraServlet?accion=listaDeCarreras">Lista de Carreras</a> 
                        <a class="nav-item nav-link" href="AlumnoServlet?accion=listaDeAlumnos">Lista de Alumnos</a>                        
                    </div>
                    <div class="alert alert-success text-white bg-dark" role="alert">
                        <strong>
                             Estas logueado como: ${nombreUsuario}
                        </strong>
                        <a  href="${pageContext.request.servletContext.contextPath}/LoginServlet?accion=logout">Logout</a>
                    </div>
                </div>
            </nav>
            <h1>Hello World!</h1>
           
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.servletContext.contextPath}/index.jsp">
                        Iniciar Sesión 
                    </a>
                </c:otherwise>
            </c:choose>
        </div>
       
    </body>
</html>
