/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Datos.GastosD;
import Datos.TiendasD;
import Negocios.GastosN;
import Negocios.TiendasN;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge.lopez
 */
@WebServlet(name = "ServBuscarPorCategoria", urlPatterns = {"/ServBuscarPorCategoria"})
public class ServBuscarPorCategoria extends HttpServlet {

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
            
            
                String fecha1 = request.getParameter("fecha1");
              // Date fecha2 = Date.valueOf(request.getParameter("fecha2"));
               
              
            
            try {
                
                 GastosN tin = new GastosN();  
                GastosD    tid ;
                tid = tin.consultarDostres(fecha1);
                
                  if(tid !=null){
           request.setAttribute("fecha1", tid);
           //request.setAttribute("fecha2", fecha2);
          
           
            }
                
                
            } catch (Exception ex) {
                 ex.printStackTrace();
            }
            
           request.getRequestDispatcher("MostrarGastosFecha.jsp").forward(request, response);
    }

    }
}