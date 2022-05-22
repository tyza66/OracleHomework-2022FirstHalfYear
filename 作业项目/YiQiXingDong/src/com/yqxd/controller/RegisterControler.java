package com.yqxd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yqxd.entity.QuarantineAdmin;
import com.yqxd.service.QuarantineAdminService;
import com.yqxd.service.imp.QuarantineAdminServiceImp;

/**
 * Servlet implementation class Register
 */
@WebServlet("/register")
public class RegisterControler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterControler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String way = request.getParameter("way");
		String name = request.getParameter("name");
		String sex = request.getParameter("sex");
		String phone = request.getParameter("phone");
		int ks = request.getParameter("ks")==null?0:Integer.parseInt(request.getParameter("ks"));
		String password = request.getParameter("password");
		String vcode = request.getParameter("vcode");
		QuarantineAdminService employeesService = new QuarantineAdminServiceImp();
		if(way.equals("1")) {
			request.setAttribute("failtip", "功能仍在开发");
			request.getRequestDispatcher("register.jsp").forward(request, response);
		}
		if(way.equals("2")) {
			if(way.equals("")||name.equals("")||sex.equals("")||phone.equals("")||ks==0||password.equals("")||vcode.equals("")) {
				request.setAttribute("failtip", "填写信息不完整");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			HttpSession s = request.getSession();
			String vt = (String) s.getAttribute("vcode");
			if(!vcode.toLowerCase().equals(vt.toLowerCase())) {
				request.setAttribute("failtip", "验证码错误");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
			QuarantineAdmin q = new QuarantineAdmin(66,name,sex,phone,null,null,password,ks);
			QuarantineAdminService quarantineAdminService = new QuarantineAdminServiceImp();
			if(quarantineAdminService.register(q)==1) {
				request.setAttribute("successtip", "注册成功！请返回登录页面进行登录！");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}else {
				request.setAttribute("failtip", "输入信息有误");
				request.getRequestDispatcher("register.jsp").forward(request, response);
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
