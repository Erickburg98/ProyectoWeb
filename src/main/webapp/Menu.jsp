<%-- 
    Document   : Menu
    Created on : 18 jun 2020, 15:15:23
    Author     : burgos
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>LanguageSchool</title>
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
            <div class="card text-white bg-dark mb-3">
                <div class="card-body"> 
                    <div class="card text-dark bg-white mb-3">
                        <h5>Maestros</h5>
                    </div>
                    <form method="post" action="LoginServlet" name="frmLogin">
                        <div class="form-group">
                            <input type="hidden" name="accion" value="logout2"/>
                        </div>
                        <div class="form-group row" >
                            <div class="col-sm-6">
                                <button type="submit" name="submit" class="btn btn -info">
                                    Iniciar Sesion
                                </button>
                            </div>
                        </div>
                    </form>
                    <form method="post" action="LoginServlet" name="frmLogin">
                        <div class="form-group">
                            <input type="hidden" name="accion" value="login"/>
                            <input type="hidden" name="newMaestro" value="si"/>
                        </div>
                        <div class="form-group row" >
                            <div class="col-sm-6">
                                <button type="submit" name="submit" class="btn btn -info">
                                    Nuevo Maestro
                                </button>
                            </div>
                        </div>
                    </form>
                </div>
                <div class="card-body"> 
                     <div class="card text-dark bg-white mb-3">
                        <h5>Alumnos</h5>
                    </div>
                    <form method="post" action="LoginServletAlumno" name="frmLogin">
                        <div class="form-group">
                            <input type="hidden" name="accion" value="logout2"/>
                        </div>
                        <div class="form-group row" >
                            <div class="col-sm-6">
                                <button type="submit" name="submit" class="btn btn -info">
                                    Iniciar Sesion
                                </button>
                            </div>
                        </div>
                    </form>
                    <form method="post" action="LoginServletAlumno" name="frmLogin">
                        <div class="form-group">
                            <input type="hidden" name="accion" value="login"/>
                            <input type="hidden" name="newAlumno" value="si"/>
                        </div>
                        <div class="form-group row" >
                            <div class="col-sm-6">
                                <button type="submit" name="submit" class="btn btn -info">
                                    Nuevo Alumno
                                </button>
                            </div>
                        </div>
                    </form>

                </div>
            </div>
        </div>

        <div class="container">

            <div class="card text-white bg-dark mb-3">
                <div class="card-body">
 <div id="demo" class="carousel slide" data-ride="carousel">

            <!-- Indicators -->
            <ul class="carousel-indicators">
                <li data-target="#demo" data-slide-to="0" class="active"></li>
                <li data-target="#demo" data-slide-to="1"></li>
                <li data-target="#demo" data-slide-to="2"></li>
                <li data-target="#demo" data-slide-to="3"></li>
                <li data-target="#demo" data-slide-to="4"></li>
                <li data-target="#demo" data-slide-to="5"></li>
                <li data-target="#demo" data-slide-to="6"></li>
                <li data-target="#demo" data-slide-to="7"></li>
                <li data-target="#demo" data-slide-to="8"></li>
                <li data-target="#demo" data-slide-to="9"></li>
                <li data-target="#demo" data-slide-to="10"></li>
                <li data-target="#demo" data-slide-to="11"></li>
                <li data-target="#demo" data-slide-to="12"></li>
                <li data-target="#demo" data-slide-to="13"></li>
                <li data-target="#demo" data-slide-to="14"></li>
            </ul>

            <!-- The slideshow -->
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img src="errores/1.png" height="150" class="rounded" width="1100" alt="Los Angeles">
                </div>
                <div class="carousel-item">
                    <img src="errores/2.jpg" height="150" class="rounded" width="1100" alt="Chicago">
                </div>
                <div class="carousel-item">
                    <img src="errores/3.jpeg" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/4.png" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/5.jpg" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/6.jpg" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/7.png" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/8.jpeg" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/9.jpg" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/11.jpg" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/12.jpg" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/13.jpg" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/14.jpg" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/15.jpg" height="150" class="rounded" width="1100" alt="New York">
                </div>
                <div class="carousel-item">
                    <img src="errores/16.jpeg" height="150" class="rounded" width="1100" alt="New York">
                </div>
            </div>

            <!-- Left and right controls -->
            <a class="carousel-control-prev" href="#demo" data-slide="prev">
                <span class="carousel-control-prev-icon"></span>
            </a>
            <a class="carousel-control-next" href="#demo" data-slide="next">
                <span class="carousel-control-next-icon"></span>
            </a>

        </div>
                </div>
            </div>
        </div>


    </body>
</html>
