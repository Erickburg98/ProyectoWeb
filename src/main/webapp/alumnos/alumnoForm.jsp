
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LanguageSchool</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
        <div class="container">
            <nav class="navbar navbar-expand-md bg-dark navbar-dark">
                <a class="navbar-brand" href="#">LanguageSchool</a>

            </nav>
            <div class="card border-dark mb-3" >
                <div class="card-header">
                    <h2>Datos del Alumno</h2>
                </div>

                <div class="card bg-secondary text-white">      
                    <div class="card-body">
                        <form name="frmUsuario"
                              id="frmUsuario"
                              method="post"
                              action="AlumnoServlet?accion=guardar"
                              enctype="multipart/form-data">
                            <div class="form-group row" >

                                <div class="col-sm-6">
                                    <input type="hidden" name="id"
                                           id="id" class="form-control"
                                           value="<c:out value="${usuario.entidad.idAlumnos}" />"/>
                                </div>
                            </div>
                            <div class="form-group row" >
                                <label class="col-sm-2 col-form-label">Nombre's</label>
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
                                <label class="col-sm-2 col-form-label">A. Paterno</label>
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
                                <label class="col-sm-2 col-form-label">A. Materno</label>
                                <div class="col-sm-6">
                                    <input type="text" name="txtMaterno"
                                           id="txtMaterno" class="form-control"
                                           maxlength="30"
                                           required="required" 
                                           placeholder="Materno"
                                           value="<c:out value="${usuario.entidad.materno}" />"/>
                                </div>
                            </div>

                            <div class="form-group row" >
                                <label class="col-sm-2 col-form-label">Email</label>
                                <div class="col-sm-6">
                                    <input type="email" name="txtEmail"
                                           id="txtEmail" class="form-control"
                                           maxlength="30"
                                           required="required" 
                                           placeholder="Email"
                                           value="<c:out value="${usuario.entidad.email}" />"/>
                                </div>
                            </div>

                            <div class="form-group row" >
                                <label class="col-sm-2 col-form-label">Foto</label>
                                <div class="col-sm-6">
                                    <input type="file" name="txtFoto"
                                           id="txtFoto" class="form-control"
                                           required="required" 
                                           value="<c:out value="${usuario.entidad.foto}" />"/>
                                </div>
                            </div>   

                            <div class="form-group row" >
                                <label class="col-sm-2 col-form-label">Usuario</label>
                                <div class="col-sm-6">
                                    <input type="text" name="txtNombreUsuario"
                                           id="txtNombreUsuario" class="form-control"
                                           maxlength="30"
                                           required="required" 
                                           placeholder="Nombre del Usuario"
                                           value="<c:out value="${usuario.entidad.nombreUsuario}" />"/>
                                </div>
                            </div>
                            <div class="form-group row" >
                                <label class="col-sm-2 col-form-label">Clave</label>
                                <div class="col-sm-6">
                                    <input type="password" name="txtClaveUsuario"
                                           id="txtClaveUsuario" class="form-control"
                                           maxlength="30"
                                           required="required" 
                                           placeholder="Clave del usuario"
                                           value="<c:out value="${usuario.entidad.claveUsuario}" />"/>
                                </div>
                            </div>
                            <div class="form-group row" >
                                <div class="col-sm-6">
                                    <input type="submit" name="btnEnviar"
                                           id="btnEnviar" class="btn btn-dark"
                                           value="Guardar Alumno"/>
                                </div>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
