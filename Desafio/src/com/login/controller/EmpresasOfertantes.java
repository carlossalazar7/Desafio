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

import com.login.bean.EmpresasOfertantesBean;
import com.login.model.*;

@WebServlet(name = "EmpresasOfertantes", urlPatterns = { "/EmpresasOfertantes" })
public class EmpresasOfertantes extends HttpServlet {

	EmpresasOfertantesModel modelo = new EmpresasOfertantesModel();
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
				request.getRequestDispatcher("/Admin/nuevoEmpresa.jsp").forward(request, response);
				break;
			case "insertar":
				insertar(request, response);
				break;
			case "obtener":
				obtener(request, response);
				break;
			case "modificar":
				modificar(request, response);
				break;
			case "eliminar":
				eliminar(request, response);
				break;
			}
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
		} catch (SQLException | ServletException | IOException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void insertar(HttpServletRequest request, HttpServletResponse response) {
		try {

			EmpresasOfertantesBean miGenero = new EmpresasOfertantesBean();
			miGenero.setIdEmpresa((request.getParameter("nombre")));

			if (listaErrores.size() > 0) {
				request.setAttribute("listaErrores", listaErrores);
				request.setAttribute("genero", miGenero);
				request.getRequestDispatcher("EmpresasOfertantes?op=nuevo").forward(request, response);
			} else {
				if (modelo.insertarEmpresa(miGenero) > 0) {
					request.getSession().setAttribute("exito", "Genero registrado exitosamente");
					response.sendRedirect(request.getContextPath() + "/generos.do?op=listar");
				} else {
					request.getSession().setAttribute("fracaso",
							"El genro no ha sido ingresado" + "ya hay un genro con este codigo");
					response.sendRedirect(request.getContextPath() + "/generos.do?op=listar");
				}
			}
		} catch (IOException | SQLException | ServletException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void obtener(HttpServletRequest request, HttpServletResponse response) {
		try {
			String codigo = request.getParameter("id");
			EmpresasOfertantesBean miGenero = modelo.obtenerEmpresa(codigo);
			if (miGenero != null) {
				request.setAttribute("genero", miGenero);
				request.getRequestDispatcher("/Admin/editarEmpresa.jsp").forward(request, response);
			} else {
				response.sendRedirect(request.getContextPath() + "/error404.jsp");
			}
		} catch (SQLException | IOException | ServletException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void modificar(HttpServletRequest request, HttpServletResponse response) {

		try {
			listaErrores.clear();
			EmpresasOfertantesBean empresa = new EmpresasOfertantesBean();
			empresa.setIdEmpresa(request.getParameter("idEmpresa"));

			if (listaErrores.size() > 0) {
				request.setAttribute("listaErrores", listaErrores);
				request.setAttribute("genero", empresa);
				request.getRequestDispatcher("/EmpresasOfertantes?op=obtener").forward(request, response);
			} else {
				if (modelo.modificarEmpresa(empresa) > 0) {
					request.getSession().setAttribute("exito", "genero modificado exitosamente");
					response.sendRedirect(request.getContextPath() + "/EmpresasOfertantes?op=listar");
				} else {
					request.getSession().setAttribute("fracaso",
							"El Genero no ha sido modificado" + " ya hay un Genero con este codigo");
					response.sendRedirect(request.getContextPath() + "/EmpresasOfertantes?op=listar");
				}
			}
		} catch (IOException | SQLException | ServletException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

	private void eliminar(HttpServletRequest request, HttpServletResponse response) {
		try {
			String codigo = request.getParameter("id");
			if (modelo.eliminarEmpresa(codigo) > 0) {
				request.setAttribute("exito", "Empresa  eliminado exitosamente");

			} else {
				request.setAttribute("fracaso", "No se puede eliminar esta Empresa");
			}
			request.getRequestDispatcher("/EmpresasOfertantes?op=listar").forward(request, response);
		} catch (SQLException | ServletException | IOException ex) {
			Logger.getLogger(EmpresasOfertantesModel.class.getName()).log(Level.SEVERE, null, ex);
		}
	}

}