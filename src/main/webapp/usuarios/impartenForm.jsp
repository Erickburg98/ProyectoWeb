<%-- 
    Document   : impartenForm
    Created on : 18 jun 2020, 22:02:45
    Author     : burgos
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Impartir Curso</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <a class="navbar-brand" href="#">Impartir Curso</a>

            </nav>
            <div class="card border-dark mb-3" >
                <div class="card-header">
                    <h2>Impartir Curso</h2>
                </div>

                <div class="card text-white bg-dark mb-3">      
                    <div class="card-body">
                        <form name="frmUsuario"
                              id="frmUsuario"
                              method="post"
                              action="ImpartenServlet?accion=guardar"
                              enctype="multipart/form-data">

                            <div class="form-group row" >
                                <label class="col-sm-2 col-form-label">Id Maestro</label>
                                <div class="col-sm-6">
                                    <input type="text" name="txtId"
                                           id="txtId" class="form-control"
                                           maxlength="30"
                                           required="required" 
                                           placeholder="idMaestro"
                                           value="<c:out value="${usuario.entidad.idMaestro}" />"/>
                                </div>
                            </div>

                            <div class="form-group row" >
                                <label class="col-sm-2 col-form-label">Nombre</label>
                                <div class="col-sm-6">
                                    <input type="text" name="txtNombre"
                                           id="txtNombre" class="form-control"
                                           maxlength="30"
                                           required="required" 
                                           placeholder="Nombre"
                                           value="<c:out value="${usuario.entidad.nombre}" />"/>
                                </div>
                            </div>

                            <div class="form-group row" >
                                <label class="col-sm-2 col-form-label">Paterno</label>
                                <div class="col-sm-6">
                                    <input type="text" name="txtPaterno"
                                           id="txtPaterno" class="form-control"
                                           maxlength="30"
                                           required="required" 
                                           placeholder="Paterno"
                                           value="<c:out value="${usuario.entidad.paterno}" />"/>
                                </div>
                            </div>

                            <div class="form-group row" >
                                <label class="col-sm-2 col-form-label">Idioma</label>
                                <div class="col-sm-6">
                                 <select name="txtIdioma" id="txtIdioma" class="custom-select">
                                    <option value="Ingles US">Ingles US</option>
                                    <option value="Frances">Frances</option>
                                    <option value="Portugues">Portugues</option>
                                    <option value="Ruso">Ruso</option>
                                    <option value="Italiano">Italiano</option>
                                    <option value="Aleman">Aleman</option>
                                    <option value="Ingles UK">Ingles UK</option>
                                    <option value="Holandes">Holandes</option>
                                    <option value="Arabe">Arabe</option>
                                    <option value="Chino">Chino</option>
                                    <option value="Hindi">Hindi</option>
                                    <option value="Bengalí">Bengalí</option>
                                    <option value="Japonés">Japonés</option>
                                    <option value="Panyabí">Panyabí</option>
                                    <option value="Turco">Turco</option>
                                    </select>
                                </div>
                            </div>

                            <div class="form-group row" >
                                <label class="col-sm-2 col-form-label">Nivel</label>
                                <div class="col-sm-6">
                                    <input type="text" name="txtNivel"
                                           id="txtNivel" class="form-control"
                                           maxlength="30"
                                           required="required" 
                                           placeholder="Nivel"/>
                                </div>
                            </div>

                            <div class="form-group row" >
                                <div class="col-sm-6">
                                    <input type="submit" name="btnEnviar"
                                           id="btnEnviar" class="btn btn-primary"
                                           value="Impartir Curso"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
