/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servidor;

import Datos.ArticulosD;
import Negocios.ArticulosN;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jorge.lopez
 */
@WebServlet(name = "ServEditarArticulos2", urlPatterns = {"/ServEditarArticulos2"})
public class ServEditarArticulos2 extends HttpServlet {

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
            
           int id = Integer.parseInt(request.getParameter("idarticulos"));
           
           String nombre = request.getParameter("nombre");
           String descripcion = request.getParameter("descripcion");
           String marca = request.getParameter("marca");           
           int  cate = Integer.parseInt(request.getParameter("idCategorias"));
            int  ti = Integer.parseInt(request.getParameter("idtiendas"));
           
           ArticulosN artn = new ArticulosN();
           ArticulosD artd = new ArticulosD();
           
       
           artd.setNombre(nombre);
           artd.setDescripcion(descripcion);
           artd.setMarca(marca);
           
           artd.setIdcategorias(cate);
           artd.setIdtiendas(ti);
           
           artd.setIdArticulos(id);
           
           artn.Editar2(artd);
           
           
           response.sendRedirect("articulos3.jsp");
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
