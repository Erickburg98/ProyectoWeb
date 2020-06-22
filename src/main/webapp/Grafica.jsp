
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grafica Alumnos</title>
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"></script>
    </head>
    <body>
     <div class="container">
         <nav class="navbar navbar-expand-lg navbar-light bg-light">
                <a class="navbar-brand" href="#">Gesti&oacute;n de Carrera</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                    <div class="navbar-nav">
                        <a class="nav-item nav-link active" href="principal.jsp">Home <span class="sr-only">(current)</span></a>
                        <a class="nav-item nav-link" href="CarreraServlet?accion=listaDeCarreras">Lista de Carreras</a>
                    </div>
                    <div class="alert alert-success text-white bg-dark" role="alert">
                        <strong>
                             Estas logueado como: ${nombreUsuario}
                        </strong>
                        <a  href="${pageContext.request.servletContext.contextPath}/LoginServlet?accion=logout">Logout</a>
                    </div>
                </div>
            </nav>
        <div class="card border-dark mb-3" >
                <div class="card-header">
                    <h2>Grafica Alumnos por Carrera </h2>
                </div>
                
            <div class="card text-white bg-dark mb-3"> 
                <div class="card-body">      
                    <center>
                        <img src="grafica.png">  
                    </center>         

                </div>
            </div>
            </div>
        </div>
    </body>
</html>
