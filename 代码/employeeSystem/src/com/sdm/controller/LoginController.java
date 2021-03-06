package com.sdm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdm.service.EmployeesService;
import com.sdm.service.imp.EmployeesServiceImp;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login.do")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String pwd = request.getParameter("pwd");
		EmployeesService employeesService = new EmployeesServiceImp();
		int code = employeesService.login(id, pwd);
		switch (code) {
		case 404:
			request.setAttribute("failtip", "该账号不存在，请重新登录");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		case 500:
			request.setAttribute("failtip", "密码错误，请重新登录");
			request.getRequestDispatcher("login.jsp").forward(request, response);
			break;
		case 200:
			response.sendRedirect("/employeeSystem/main.jsp");
			break;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
