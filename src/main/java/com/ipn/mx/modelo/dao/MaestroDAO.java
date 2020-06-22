package com.ipn.mx.modelo.dao;

import com.ipn.mx.modelo.dto.IdiomasDTO;
import com.ipn.mx.modelo.dto.ImpartenDTO;
import com.ipn.mx.modelo.dto.MaestroDTO;
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

public class MaestroDAO {

    private static final String SQL_INSERT = "{call InsertMae(?, ?, ?, ?, ?, ?, ?)}";
    private static final String SQL_UPDATE = "{call UpdateMae(?, ?, ?, ?, ?, ?, ?, ?)}";
    private static final String SQL_DELETE = "{call DeleteMae(?)}";
    private static final String SQL_SELECT = "{call SelectMae(?)}";
    private static final String SQL_ALL = "{call AllMaes(?)}";

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

    public void create(MaestroDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(SQL_INSERT);
            if (dto.getEntidad().getFoto() != null) {
                cs.setBlob(1, dto.getEntidad().getFoto());
            }
            cs.setString(2, dto.getEntidad().getNombre());
            cs.setString(3, dto.getEntidad().getPaterno());
            cs.setString(4, dto.getEntidad().getMaterno());
            cs.setString(5, dto.getEntidad().getEmail());
            cs.setString(6, dto.getEntidad().getNombreUsuario());
            cs.setString(7, dto.getEntidad().getClaveUsuario());
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

    public void update(MaestroDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(SQL_UPDATE);
            if (dto.getEntidad().getFoto() != null) {
                cs.setBlob(1, dto.getEntidad().getFoto());
            }
            cs.setString(2, dto.getEntidad().getNombre());
            cs.setString(3, dto.getEntidad().getPaterno());
            cs.setString(4, dto.getEntidad().getMaterno());
            cs.setString(5, dto.getEntidad().getEmail());
            cs.setString(6, dto.getEntidad().getNombreUsuario());
            cs.setString(7, dto.getEntidad().getClaveUsuario());
            cs.setInt(8, dto.getEntidad().getIdMaestro());
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

    public void delete(MaestroDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        try {
            cs = con.prepareCall(SQL_DELETE);
            cs.setInt(1, dto.getEntidad().getIdMaestro());
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

    public MaestroDTO read(MaestroDTO dto) throws SQLException {
        obtenerConexion();
        CallableStatement cs = null;
        ResultSet rs = null;
        try {
            cs = con.prepareCall(SQL_SELECT);
            cs.setInt(1, dto.getEntidad().getIdMaestro());
            rs = cs.executeQuery();
            List resultados = obtenerResultados(rs);
            if (resultados.size() > 0) {
                return (MaestroDTO) resultados.get(0);
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

    public List readOne(MaestroDTO dto) throws SQLException {
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
            MaestroDTO dto = new MaestroDTO();
            dto.getEntidad().setIdMaestro(rs.getInt("idMaestros"));
            dto.getEntidad().setNombre(rs.getString("nombre"));
            dto.getEntidad().setPaterno(rs.getString("paterno"));
            dto.getEntidad().setMaterno(rs.getString("materno"));
            dto.getEntidad().setEmail(rs.getString("email"));
            dto.getEntidad().setNombreUsuario(rs.getString("usuario"));
            dto.getEntidad().setClaveUsuario(rs.getString("contrasena"));
            InputStream binaryStream = rs.getBinaryStream("foto");
            dto.getEntidad().setFoto(binaryStream);
            resultados.add(dto);
        }
        return resultados;
    }

    public static void main(String[] args) {
        /*MaestroDAO dao = new MaestroDAO();
        MaestroDTO dto = new MaestroDTO();
        try {
            //System.out.println(dao.readGrupos(1));
        } catch (SQLException ex) {
            Logger.getLogger(MaestroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }

}
