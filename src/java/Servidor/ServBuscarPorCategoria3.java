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

import java.text.DateFormat;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
/**
 *
 * @author jorge.lopez
 */
@WebServlet(name = "ServBuscarPorCategoria3", urlPatterns = {"/ServBuscarPorCategoria3"})
public class ServBuscarPorCategoria3 extends HttpServlet {

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
          
            
              // Date fecha2 = Date.valueOf(request.getParameter("fecha2"));
               
             DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
            
            try {
                 Date fecha = Date.valueOf(request.getParameter("fecha"));
                 GastosN tin = new GastosN();  
                GastosD    tid ;
                tid = tin.consultarDostres(fecha.toString());
                
                  if(tid !=null){
           request.setAttribute("fecha", tid);
                                      // MostrarGastosFecha2         
         request.getRequestDispatcher("MostrarGastosFecha2.jsp").forward(request, response);
            }
                
                
            } catch (Exception ex) {
                 ex.printStackTrace();
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
