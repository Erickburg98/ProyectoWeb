
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Lista de Idiomas</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <a class="navbar-brand" href="#">Gestión de Carreras</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                    </div>
                    <div class="alert alert-dark"  role="alert">
                        <strong>
                             Estas logueado como: ${nombreUsuario}
                        </strong>
                        <a  href="${pageContext.request.servletContext.contextPath}/LoginServlet?accion=logout">Logout</a>
                    </div>
                </div>
            </nav>
            <div class="card border-dark mb-3" >
                        <div class="card-header">
                        <h2>Lista de Idiomas</h2>
                        </div>
                        <div class="card-body text-primary">
            <table class="table table-dark" >
                <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nombre</th>
                        <th scope="col">Niveles</th>
                        <th scope="col">Cupos</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${listaDeCarreras}" var="carreras">
                        <tr>
                            <td>
                                <c:out value="${carreras.entidad.idIdiomas}"/>
                            </td>
                            <td>
                                <c:out value="${carreras.entidad.nombre}"/>
                            </td>
                            <td>
                                <c:out value="${carreras.entidad.niveles}"/>
                            </td>
                            <td>
                                <c:out value="${carreras.entidad.cupos}"/> 
                            </td>

                        </tr>

                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>
