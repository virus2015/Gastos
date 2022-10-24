    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Datos.GastosD;
import Negocios.GastosN;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge.lopez
 */
@WebServlet(name = "ServInsertarGastos3", urlPatterns = {"/ServInsertarGastos3"})
public class ServInsertarGastos3 extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
        
                 
            int idArticulos = Integer.parseInt(request.getParameter("idArticulos"));
            int idCategorias = Integer.parseInt(request.getParameter("idCategorias"));
            int idTiendas = Integer.parseInt(request.getParameter("idTiendas"));
            int cantidad = Integer.parseInt(request.getParameter("cantidad"));
            Date fecha = Date.valueOf(request.getParameter("fecha"));
            int monto = Integer.parseInt(request.getParameter("monto"));
            
            GastosN  gan = new GastosN();
            GastosD gad = new GastosD();
            
            gad.setIdArticulos(idArticulos);
            gad.setIdCategorias(idCategorias);
            gad.setIdTiendas(idTiendas);
            gad.setCantidad(cantidad);
            gad.setFecha(fecha); 
            gad.setMonto(monto);
            
            
            gan.Ingresar(gad);
            response.sendRedirect("GastosVariables.jsp");
            
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

}
