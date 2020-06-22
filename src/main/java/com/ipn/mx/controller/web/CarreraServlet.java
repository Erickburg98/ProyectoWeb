package com.ipn.mx.controller.web;

import com.ipn.mx.modelo.dao.IdiomasDAO;
import com.ipn.mx.modelo.dto.IdiomasDTO;
import com.ipn.mx.utilerias.Grafica;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperRunManager;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

@WebServlet(name = "CarreraServlet", urlPatterns = {"/CarreraServlet"})
public class CarreraServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion.equals("listaDeCarreras")) {
            listaDeCarreras(request, response);
        } else if (accion.equals("Grafica")) {
            Grafica(request, response);
        } else if (accion.equals("repoC")) {
            generarRCarrera(request, response);
        } else if (accion.equals("repGeneral")) {
            repGeneral(request, response);
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

    private void listaDeCarreras(HttpServletRequest request, HttpServletResponse response) {
        IdiomasDAO dao = new IdiomasDAO();
        try {
            Collection lista = dao.readAll();
            request.setAttribute("listaDeCarreras", lista);
            RequestDispatcher vista = request.getRequestDispatcher("/carrera/listaDeCarreras.jsp");
            vista.forward(request, response);
        } catch (SQLException | ServletException | IOException ex) {
            Logger.getLogger(CarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void Grafica(HttpServletRequest request, HttpServletResponse response) {
        JFreeChart Chart = ChartFactory.createPieChart3D("Maestros por Idioma", getgraficaAlumnos(), true, true, Locale.getDefault());
        String archivo = getServletConfig().getServletContext().getRealPath("/grafica.png");
        try {
            ChartUtils.saveChartAsPNG(new File(archivo), Chart, 700, 500);
            RequestDispatcher vista = request.getRequestDispatcher("/Grafica.jsp");
            vista.forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private PieDataset getgraficaAlumnos() {
        DefaultPieDataset pie = new DefaultPieDataset();
        IdiomasDAO dao = new IdiomasDAO();
        try {
            List datos = dao.grafica();
            for (int i = 0; i < datos.size(); i++) {
                Grafica dto = (Grafica) datos.get(i);
                pie.setValue(dto.getNombre(), dto.getCantidad());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return pie;
    }
    
    private void generarRCarrera(HttpServletRequest request, HttpServletResponse response) {
        IdiomasDAO dao = new IdiomasDAO();
        try {
            ServletOutputStream sos = response.getOutputStream();
            File reporte = new File(getServletConfig().getServletContext().getRealPath("/reportes/repCa.jasper"));
            
            Map parametro =new HashMap();
            parametro.put("id", Integer.parseInt(request.getParameter("id")));
            
            byte[] bytes = JasperRunManager.runReportToPdf(reporte.getPath(), parametro, dao.obtenerConexion());
            response.setContentType("application/pdf");
            response.setContentLength(bytes.length);
            sos.write(bytes, 0, bytes.length);
            sos.flush();
            sos.close();
        } catch (IOException | JRException ex) {
            Logger.getLogger(CarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void repGeneral(HttpServletRequest request, HttpServletResponse response) {
        IdiomasDAO dao = new IdiomasDAO();
      try{
          ServletOutputStream sos = response.getOutputStream();
          File reporte = new File(getServletConfig().
          getServletContext().getRealPath("/reportes/General.jasper"));
          byte[] bytes = JasperRunManager.runReportToPdf(reporte.getPath(),null,dao.obtenerConexion());
          response.setContentType("application/pdf");
          response.setContentLength(bytes.length);
          sos.write(bytes, 0, bytes.length);
          sos.flush();
          sos.close();     
      }
      catch (IOException | JRException ex) {
            Logger.getLogger(CarreraServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
