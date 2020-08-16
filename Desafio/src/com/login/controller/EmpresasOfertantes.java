/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.login.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.login.model.*;

@WebServlet(name = "EmpresasOfertantes", urlPatterns = { "/EmpresasOfertantes" })
public class EmpresasOfertantes extends HttpServlet {

	EmpresasOfertantesModel modelo = new EmpresasOfertantesModel();
	ArrayList<String> listaErrores = new ArrayList<>();

	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");

		PrintWriter out = response.getWriter();

		try {
			String operacion = request.getParameter("op");
			switch (operacion) {
			case "listar":
				listar(request, response);
				break;
			case "nuevo":
				request.getRequestDispatcher("/editoriales/nuevoEditorial.jsp").forward(request, response);
				break;
			}
		} finally {
			out.close();
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
			request.setAttribute("listar", modelo.listar());
			request.getRequestDispatcher("Admin/Admin.jsp").forward(request, response);
		} catch (SQLException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
		} catch (ServletException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
		} catch (IOException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
		}
	}


}