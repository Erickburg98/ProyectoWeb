package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.IdiomasDTO;
import com.ipn.mx.utilerias.Grafica;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IdiomasDAO {

    private static final String SQL_SELECT_ALL = "{call AllIdi()}";

    private static final String SQL_GRAFICA = "{call Grafica()}";

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

    public List readAll() throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = con.prepareCall(SQL_SELECT_ALL);
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
            IdiomasDTO dto = new IdiomasDTO();
            dto.getEntidad().setIdIdiomas(rs.getInt("idIdiomas"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setNiveles(rs.getInt("niveles"));
            dto.getEntidad().setCupos(rs.getInt("cupos"));
            resultados.add(dto);
        }
        return resultados;
    }

    public static void main(String[] args) throws SQLException {
        IdiomasDAO dao = new IdiomasDAO();
        dao.readAll();
    }

    public List grafica() throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        List lista = new ArrayList();
        try {
            cs = con.prepareCall(SQL_GRAFICA);
            rs = cs.executeQuery();
            while (rs.next()) {
                Grafica grafica = new Grafica();
                grafica.setCantidad(Integer.parseInt(rs.getString("Maestros")));
                grafica.setNombre(rs.getString("Idioma"));
                lista.add(grafica);
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
        return lista;
    }
}
