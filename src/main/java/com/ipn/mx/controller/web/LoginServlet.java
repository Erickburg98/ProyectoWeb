/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.controller.web;

import com.ipn.mx.modelo.dao.MaestroDAO;
import com.ipn.mx.utilerias.LoginManagerVF;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author darkdestiny
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    private static final String SQL_SELECT = "{call LoginMae(?)}";
    private Connection con;

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
            throws ServletException, IOException, SQLException {
        String accion = request.getParameter("accion");
        if (accion.equals("login")) {
            iniciarSesion(request, response);
        } else {
            if (accion.equals("logout")) {
                cerrarSesion(request, response);
            } else if (accion.equals("logout2")) {
                cerrarSesion2(request, response);
            }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private void iniciarSesion(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        LoginManagerVF vf = new LoginManagerVF();
        vf.getLoginName(request, response);
        MaestroDAO dao = new MaestroDAO();
        String newMaestro = request.getParameter("newMaestro");
        String username = "Erickburg";
        String password = "Erickburg";

        if (newMaestro.equals("no")) {
            username = request.getParameter("txtUsuario");
            password = request.getParameter("txtPassword");
        }

        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            boolean ok = false;
            obtenerConexion();
            cs = con.prepareCall(SQL_SELECT);
            cs.setString(1, username);
            rs = cs.executeQuery();
            String idUser = "aaa";
            while (rs.next()) {
                String nUser = rs.getString("usuario");
                String cUser = rs.getString("contrasena");
                idUser = rs.getString("idMaestros");
                if (username.equals(nUser) && password.equals(cUser)) {
                    ok = true;
                } else {
                    ok = false;
                }
            }
            if (ok == true) {
                vf.login(request, response, username);
                if (newMaestro.equals("si")) {
                    response.sendRedirect("UsuarioServlet?accion=nuevo");
                } else {
                    response.sendRedirect("UsuarioServlet?accion=listaDeUsuarios&id=" + idUser);
                }

            } else {
                response.sendRedirect("index.jsp");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cerrarSesion(HttpServletRequest request, HttpServletResponse response) {
        try {
            LoginManagerVF vf = new LoginManagerVF();
            vf.getLoginName(request, response);
            vf.Logout(request, response);
            response.sendRedirect("Menu.jsp");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void cerrarSesion2(HttpServletRequest request, HttpServletResponse response) {
        try {
            LoginManagerVF vf = new LoginManagerVF();
            vf.getLoginName(request, response);
            vf.Logout(request, response);
            response.sendRedirect("index.jsp");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Connection obtenerConexion() {
        String user = "root";
        String pwd = "AXHcqa11092";
        String url = "jdbc:mysql://node54915-env-3995618.jl.serv.net.mx:3306/ProyectoWeb?serverTimezone=America/Mexico_City&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false";
        String mySqlDriver = "com.mysql.cj.jdbc.Driver";
        /*String user = "root";
        String pwd = "password";
        String url = "jdbc:mysql://localhost:3306/ProyectoWeb?serverTimezone=America/Mexico_City&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&useSSL=false";
        String mySqlDriver = "com.mysql.cj.jdbc.Driver";*/

        try {
            Class.forName(mySqlDriver);
            con = DriverManager.getConnection(url, user, pwd);
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

}
