/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controller.web;

import com.ipn.mx.modelo.dao.ImpartenDAO;
import com.ipn.mx.modelo.dto.ImpartenDTO;
import com.ipn.mx.utilerias.Utilerias;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 *
 * @author burgos
 */
@WebServlet(name = "ImpartenServlet", urlPatterns = {"/ImpartenServlet"})
@MultipartConfig(maxFileSize = 16000000)
public class ImpartenServlet extends HttpServlet {

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
        if (accion.equals("guardar")) {
            almacenarImparten(request, response);
        } else if (accion.equals("listaDeGrupos")) {
            listaDeGrupos(request, response);
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

    private void almacenarImparten(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        ImpartenDAO dao = new ImpartenDAO();
        ImpartenDTO dto = new ImpartenDTO();
        dto.getEntidad().setIdMaestro(Integer.parseInt(request.getParameter("txtId")));
        dto.getEntidad().setNombre(request.getParameter("txtNombre"));
        dto.getEntidad().setPaterno(request.getParameter("txtPaterno"));
        dto.getEntidad().setNombreIdio(request.getParameter("txtIdioma"));
        dto.getEntidad().setNivel(Integer.parseInt(request.getParameter("txtNivel")));
        try {
            dao.create(dto);
            response.sendRedirect("UsuarioServlet?accion=listaDeUsuarios&id=" + request.getParameter("txtId"));
        } catch (SQLException ex) {
            Logger.getLogger(ImpartenServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void listaDeGrupos(HttpServletRequest request, HttpServletResponse response) {
        ImpartenDAO dao = new ImpartenDAO();
        ImpartenDTO dto = new ImpartenDTO();
        int val = Integer.parseInt(request.getParameter("id"));
        dto.getEntidad().setIdMaestro(Integer.parseInt(request.getParameter("id")));
        try {
            if (val == 9999) {
                Collection lista = dao.readAll();
                request.setAttribute("listaDeGrupos", lista);
                System.out.println(dao.readAll());
                RequestDispatcher vista = request.getRequestDispatcher("/usuarios/listaDeGrupos.jsp");
                vista.forward(request, response);
            } else {
                Collection lista = dao.readOne(dto);
                request.setAttribute("listaDeGrupos", lista);
                System.out.println(dao.readAll());
                RequestDispatcher vista = request.getRequestDispatcher("/usuarios/listaDeGrupos.jsp");
                vista.forward(request, response);
            }

        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(ImpartenServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
