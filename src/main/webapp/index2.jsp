<%-- 
    Document   : index2
    Created on : 20 jun 2020, 22:27:06
    Author     : burgos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Inicar Sesion</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" />
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" ></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" ></script>

        <meta http-equiv="cache-control" content="max-age=0, must-revalidate, no-cache, no-store, private">
        <meta http-equiv="expires" content="-1">
        <meta http-equiv="pragma" content="no-cache">

    </head>
    <body>
        <div class="container">
            
                <div class="card-header">
                    <h1>Login LanguageSchool</h1>
                </div>
            <div class="card text-white bg-dark mb-3" >
                <div class="card-body">
            <c:choose>
                <c:when test="${nombreUsuario == null}">
                    <form method="post" action="LoginServletAlumno" name="frmLogin">

                        <div class="form-group">
                            <input type="hidden" name="accion" value="login"/>
                            <input type="hidden" name="newAlumno" value="no"/>
                        </div>

                        <div class="form-group row">
                            <label for="username" class="col-sm-2 col-form-label" >Nombre de Usuario :</label>
                            <div class="col-sm-6">
                                <input 
                                    type="text"
                                    id="username" 
                                    name="txtUsuario"
                                    class="form-control"/>
                            </div>
                        </div>

                        <div class="form-group row" >
                            <label for="password" class="col-sm-2 col-form-label" >Clave de Usuario :</label>
                            <div class="col-sm-6">
                            <input 
                                type="password"
                                id="password" 
                                name="txtPassword"
                                class="form-control"/>
                            </div>
                        </div>
                        
                        <div class="form-group row" >
                             <div class="col-sm-6">
                        <button type="submit" name="submit" class="btn btn -info">
                            Login
                        </button>
                             </div>
                        </div>
                    </form>
                </c:when>
                <c:otherwise>
                    <div class="alert alert-success" role="alert">
                        <strong>
                            Estas logueado como: ${nombreUsuario}
                        </strong>
                    </div>
                </c:otherwise>
            </c:choose>


        </div>
        </div>
        </div>
            
    </body>
</html>