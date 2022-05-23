package com.yqxd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yqxd.service.QuarantineAdminService;
import com.yqxd.service.imp.QuarantineAdminServiceImp;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
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
		String way = request.getParameter("way");
		String userName = request.getParameter("username");
		String passWord = request.getParameter("password");
		QuarantineAdminService quarantineAdminService = new QuarantineAdminServiceImp();
		if (way.equals("1")) {
			request.setAttribute("failtip", "功能仍在开发");
			request.getRequestDispatcher("index.jsp").forward(request, response);
		}
		if (way.equals("2")) {
			int code = quarantineAdminService.login(userName, passWord);
			switch (code) {
			case 404:
				request.setAttribute("failtip", "该账号不存在，请重新登录");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			case 500:
				request.setAttribute("failtip", "密码错误，请重新登录");
				request.getRequestDispatcher("index.jsp").forward(request, response);
				break;
			case 200:
				String name = quarantineAdminService.getUsername(userName);
				HttpSession session = request.getSession();
				session.setAttribute("loginName", name);
				response.sendRedirect("/YiQiXingDong/jsp/control1.jsp");
				break;
			}
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
