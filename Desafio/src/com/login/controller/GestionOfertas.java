package com.login.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.login.bean.*;
import com.login.model.*;

@WebServlet(name = "GestionOfertas", urlPatterns = { "/GestionOfertas.do" })
public class GestionOfertas extends HttpServlet{
	
	OfertasModel ofertas = new OfertasModel();
	ArrayList<String> listaErrores = new ArrayList<>();
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = response.getWriter()) {
			if (request.getParameter("op") == null) {
				listar(request, response);
				return;
			}
			String operacion = request.getParameter("op");

			switch (operacion) {
			case "listar":
				listar(request, response);
				break;
			case "nuevo":
				request.getRequestDispatcher("/Admin2/nuevaOferta.jsp").forward(request, response);
				break;
			case "insertar":
				insertar(request, response);
				break;
			
			}
		}
		
		// <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
		// + sign on the left to edit the code.">

		/**
		 * Handles the HTTP <code>GET</code> method.
		 *
		 * @param request  servlet request
		 * @param response servlet response
		 * @throws ServletException if a servlet-specific error occurs
		 * @throws IOException      if an I/O error occurs
		 */

		@Override
		protected void doGet(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			processRequest(request, response);
		}

		/**
		 * Handles the HTTP <code>POST</code> method.
		 *
		 * @param request  servlet request
		 * @param response servlet response
		 * @throws ServletException if a servlet-specific error occurs
		 * @throws IOException      if an I/O error occurs
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

		private void listar(HttpServletRequest request, HttpServletResponse response) {
			try {
				request.setAttribute("listarOfertas", ofertas.listar());
				request.getRequestDispatcher("Admin2/Admin2.jsp").forward(request, response);
			} catch (SQLException | ServletException | IOException ex) {
				Logger.getLogger(OfertasModel.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		private void insertar(HttpServletRequest request, HttpServletResponse response) {
			try {

				OfertasBean miOferta = new OfertasBean();
				miOferta.setNombreOferta(request.getParameter("nombre"));
				miOferta.setPrecioNormal(Float.parseFloat(request.getParameter("precion")));
				miOferta.setPrecioOferta(Float.parseFloat(request.getParameter("preciof")));
				miOferta.setFechaInicio(request.getParameter("fechai"));
				miOferta.setFechaFinal(request.getParameter("fechaf"));
				miOferta.setCantidadCupones(Integer.parseInt(request.getParameter("cupones")));
				miOferta.setDescripcion(request.getParameter("descripcion"));
				miOferta.setEstado("En espera");
				miOferta.setFechaLimite(request.getParameter("fechal"));
				miOferta.setJustificacion("En espera");
				miOferta.setIdEmpresa(request.getParameter("empresa"));
		
				
					
				
					if (ofertas.insertar(miOferta)> 0) {
						request.getSession().setAttribute("exito", "Oferta registrada exitosamente");
						response.sendRedirect(request.getContextPath() + "/GestionOfertas.do?op=listar");
					} else {
						request.getSession().setAttribute("fracaso","La oferta no ha sido ingresado");
						response.sendRedirect(request.getContextPath() + "/GestionOferta.do?op=listar");
					}
					request.getRequestDispatcher("/GestionOfertas.do?op=nuevo").forward(request, response);
			} catch (IOException | SQLException | ServletException ex) {
				Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
			}
		}

		
			
}