/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.ImpartenDTO;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author burgos
 */
public class ImpartenDAO {

    private static final String SQL_INSERT = "{call InsertImp(?, ?, ?, ?, ?)}";
    private static final String SQL_SELECT = "{call SelectImp(?)}";
    private static final String SQL_ALL = "{call AllImp()}";

    private Connection con;

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
            Logger.getLogger(IdiomasDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return con;
    }

    public void create(ImpartenDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(SQL_INSERT);
            cs.setInt(1, dto.getEntidad().getIdMaestro());
            cs.setString(2, dto.getEntidad().getNombre());
            cs.setString(3, dto.getEntidad().getPaterno());
            cs.setString(4, dto.getEntidad().getNombreIdio());
            cs.setInt(5, dto.getEntidad().getNivel());
            cs.executeUpdate();

        } finally {
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List readAll() throws SQLException {
        obtenerConexion();
        CallableStatement ps = null;
        ResultSet rs = null;
        try {
            ps = con.prepareCall(SQL_ALL);
            rs = ps.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (ps != null) {
                ps.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    public List readOne(ImpartenDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = con.prepareCall(SQL_SELECT);
            cs.setInt(1, dto.getEntidad().getIdMaestro());
            rs = cs.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return resultados;
            } else {
                return null;
            }
        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (con != null) {
                con.close();
            }
        }
    }

    private List obtenerResultados(ResultSet rs) throws SQLException {
        List resultados = new ArrayList();
        while (rs.next()) {
            ImpartenDTO dto = new ImpartenDTO();
            dto.getEntidad().setIdImparten(rs.getInt("idImparten"));
            dto.getEntidad().setIdMaestro(rs.getInt("idMaestros"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setPaterno(rs.getString("paterno"));
            dto.getEntidad().setNombreIdio(rs.getString("nombreIdio"));
            dto.getEntidad().setNivel(rs.getInt("nivel"));
            resultados.add(dto);
        }
        return resultados;
    }

    public static void main(String[] args) throws SQLException {
        ImpartenDAO dao = new ImpartenDAO();
        ImpartenDTO dto = new ImpartenDTO();
        // dto.getEntidad().setIdMaestro(3);
        /*dto.getEntidad().setNombre("Erick");
        dto.getEntidad().setPaterno("Burgos");
        dto.getEntidad().setNombreIdio("Ingles");
        dto.getEntidad().setNivel(10);
        dao.create(dto);*/
        System.out.println(dao.readAll());
    }

}
