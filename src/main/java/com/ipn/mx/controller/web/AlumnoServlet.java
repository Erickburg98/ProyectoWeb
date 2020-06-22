package com.ipn.mx.controller.web;

import com.ipn.mx.modelo.dao.AlumnoDAO;
import com.ipn.mx.modelo.dto.AlumnoDTO;
import com.ipn.mx.utilerias.Utilerias;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;

@WebServlet(name = "AlumnoServlet", urlPatterns = {"/AlumnoServlet"})
@MultipartConfig(maxFileSize = 16000000)
public class AlumnoServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("listaDeAlumnos")) {
            listaDeAlumnos(request, response);
        } else if (accion.equals("nuevo")) {
            agregarAlumno(request, response);
        } else if (accion.equals("guardar")) {
            almacenarAlumno(request, response);
        } else if (accion.equals("eliminar")) {
            eliminarAlumno(request, response);
        } else if (accion.equals("actualizar")) {
            actualizarAlumno(request, response);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    private void listaDeAlumnos(HttpServletRequest request, HttpServletResponse response) {
        AlumnoDAO dao = new AlumnoDAO();
        AlumnoDTO dto = new AlumnoDTO();
        dto.getEntidad().setIdAlumnos(Integer.parseInt(request.getParameter("id")));
        try {
            Collection lista = dao.readOne(dto);
            request.setAttribute("listaDeAlumnos", lista);
            RequestDispatcher vista = request.getRequestDispatcher("/alumnos/listaDeAlumnos.jsp");
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void agregarAlumno(HttpServletRequest request, HttpServletResponse response) {
        RequestDispatcher vista = request.getRequestDispatcher("/alumnos/alumnoForm.jsp");
        try {
            vista.forward(request, response);
        } catch (ServletException | IOException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void eliminarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException {
        AlumnoDAO dao = new AlumnoDAO();
        AlumnoDTO dto = new AlumnoDTO();
        dto.getEntidad().setIdAlumnos(Integer.parseInt(request.getParameter("id")));
        try {
            dto = dao.read(dto);
            dao.delete(dto);
            response.sendRedirect("Menu.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void actualizarAlumno(HttpServletRequest request, HttpServletResponse response) {
        AlumnoDAO dao = new AlumnoDAO();
        AlumnoDTO dto = new AlumnoDTO();
        dto.getEntidad().setIdAlumnos(Integer.parseInt(request.getParameter("id")));
        try {
            dto = dao.read(dto);
            request.setAttribute("usuario", dto);
            RequestDispatcher vista = request.getRequestDispatcher("/alumnos/alumnoForm.jsp");
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void almacenarAlumno(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        AlumnoDAO dao = new AlumnoDAO();
        AlumnoDTO dto = new AlumnoDTO();
        Utilerias mail = new Utilerias();
        if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
            dto.getEntidad().setNombre(request.getParameter("txtNombre"));
            dto.getEntidad().setPaterno(request.getParameter("txtPaterno"));
            dto.getEntidad().setMaterno(request.getParameter("txtMaterno"));
            dto.getEntidad().setEmail(request.getParameter("txtEmail"));
            dto.getEntidad().setNombreUsuario(request.getParameter("txtNombreUsuario"));
            dto.getEntidad().setClaveUsuario(request.getParameter("txtClaveUsuario"));
            Part archivo = null;
            archivo = request.getPart("txtFoto");
            if (archivo != null) {
                System.out.println(archivo.getName());
                dto.getEntidad().setFoto(archivo.getInputStream());
            }
            try {
                dao.create(dto);
                String asunto = "Confirmacion de registro en LanguageSchool";
                String texto
                        = "Estimad@, " + request.getParameter("txtNombre") + " " + request.getParameter("txtPaterno") + " " + request.getParameter("txtMaterno")
                        + "\n\nHemos confirmado su registro y le informamos que usted ha sido registrado como Alumn@"
                        + " de nuestra institucion LanguageSchool exitosamente."
                        + "\n\nA partir de ahora podra acceder al sistema con su Usuario y Clave desde el Inicio de Sesion."
                        + "\n\n Por favor, no responder a este correo gracias.";
                mail.enviarEmail(request.getParameter("txtEmail"), asunto, texto);
                response.sendRedirect("Menu.jsp");
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }

        } else {
            dto.getEntidad().setIdAlumnos(Integer.parseInt(request.getParameter("id")));
            dto.getEntidad().setNombre(request.getParameter("txtNombre"));
            dto.getEntidad().setPaterno(request.getParameter("txtPaterno"));
            dto.getEntidad().setMaterno(request.getParameter("txtMaterno"));
            dto.getEntidad().setEmail(request.getParameter("txtEmail"));
            dto.getEntidad().setNombreUsuario(request.getParameter("txtNombreUsuario"));
            dto.getEntidad().setClaveUsuario(request.getParameter("txtClaveUsuario"));
            Part archivo = null;
            archivo = request.getPart("txtFoto");
            if (archivo != null) {
                System.out.println(archivo.getName());
                dto.getEntidad().setFoto(archivo.getInputStream());
            }
            try {
                dao.update(dto);
                listaDeAlumnos(request, response);
            } catch (SQLException ex) {
                Logger.getLogger(UsuarioServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
