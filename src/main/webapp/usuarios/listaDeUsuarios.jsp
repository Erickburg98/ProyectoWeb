
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <title>LanguageSchool</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>

    <body>
        <div class="container">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <a class="navbar-brand" href="#">LanguageSchool</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-item nav-link" href="CarreraServlet?accion=listaDeCarreras">Lista de Idiomas</a>
                        <a class="nav-item nav-link" href="ImpartenServlet?accion=listaDeGrupos&id=9999">Lista de Grupos</a>
                        <a class="nav-item nav-link" href="CarreraServlet?accion=Grafica">Grafica</a>
                        <a class="nav-item nav-link" href="CarreraServlet?accion=repGeneral">Rep. Idiomas</a>
                        <a class="nav-item nav-link" href="CarreraServlet?accion=repoC">Rep. Cursos</a>
                    </div>
                    <div class="alert alert-dark" role="alert">
                        <strong>
                            Estas logueado como: ${nombreUsuario}
                        </strong>
                        <a  href="${pageContext.request.servletContext.contextPath}/LoginServlet?accion=logout">Logout</a>
                    </div>
                </div>
            </nav>
            <div class="card border-dark mb-3" >
                <div class="card-header">
                    <h2>Datos personales de: ${nombreUsuario}</h2>
                </div>
                <div class="card-body text-primary">
                    <table class="table table-dark">
                        <thead>
                            <tr>
                                <th scope="col">ID</th>
                                <th scope="col">Foto</th>
                                <th scope="col">Nombre</th>
                                <th scope="col">Paterno</th>
                                <th scope="col">Materno</th>
                                <th scope="col">Email</th>
                                <th scope="col">Usuario</th>
                                <th scope="col">Delete</th>
                                <th scope="col">Actualizar</th>
                                <th scope="col">Impartir</th>
                                <th scope="col">Grupos</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${listaDeUsuarios}" var="usuarios">

                                <tr>
                                    <td >
                                        <c:out value="${usuarios.entidad.idMaestro}"/>
                                    </td>
                                    <td>
                                        <image height="50" class="rounded-circle" width="50" src="ImgUser?id=<c:out value="${usuarios.entidad.idMaestro}"/>" />
                                    </td>
                                    <td>
                                        <c:out value="${usuarios.entidad.nombre}"/>
                                    </td>
                                    <td>
                                        <c:out value="${usuarios.entidad.paterno}"/>
                                    </td>
                                    <td>
                                        <c:out value="${usuarios.entidad.materno}"/>
                                    </td>
                                    <td>
                                        <c:out value="${usuarios.entidad.email}"/>
                                    </td>
                                    <td>
                                        <c:out value="${usuarios.entidad.nombreUsuario}"/>
                                    </td>
                                    <td>
                                        <a class="btn btn-outline-danger"
                                           href="UsuarioServlet?accion=eliminar&id=<c:out value="${usuarios.entidad.idMaestro}"/>">
                                            Delete
                                        </a>
                                    </td>
                                    <td>
                                        <a class="btn btn-outline-info"
                                           href="UsuarioServlet?accion=actualizar&id=<c:out value="${usuarios.entidad.idMaestro}"/>
                                           ">
                                            Actualizar
                                        </a>
                                    </td>
                                    <td>
                                        <a class="btn btn-outline-success"
                                           href="UsuarioServlet?accion=impartir&id=<c:out value="${usuarios.entidad.idMaestro}"/>
                                           ">
                                            Impartir
                                        </a>
                                    </td>
                                    <td>
                                        <a class="btn btn-outline-warning"
                                           href="ImpartenServlet?accion=listaDeGrupos&id=<c:out value="${usuarios.entidad.idMaestro}"/>
                                           ">
                                            Grupos
                                        </a>
                                    </td>

                                </tr>

                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
         
    </body>
</html>
