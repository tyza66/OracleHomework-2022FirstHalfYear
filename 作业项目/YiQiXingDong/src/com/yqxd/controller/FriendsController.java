package com.yqxd.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yqxd.entity.Friends;
import com.yqxd.service.FriendsService;
import com.yqxd.service.imp.FriendsServiceImp;


/**
 * Servlet implementation class FriendsController
 */
@WebServlet("/FriendsController")
public class FriendsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FriendsController() {
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
		String how = request.getParameter("t");
		FriendsService fs = new FriendsServiceImp();
		if(how.equals("1")) {//查询
			Friends a = fs.getFriends();
			request.setAttribute("friendshow",a);
			request.getRequestDispatcher("jsp/control6.jsp").forward(request, response);
		}else if(how.equals("2")) {//修改
			String z1 = request.getParameter("z1");
			String z2 = request.getParameter("z2");
			String z3 = request.getParameter("z3");
			String z4 = request.getParameter("z4");
			String z5 = request.getParameter("z5");
			String z6 = request.getParameter("z6");
			String z7 = request.getParameter("z7");
			String z8 = request.getParameter("z8");
			String z9 = request.getParameter("z9");
			String z10 = request.getParameter("z10");
			Friends f = new Friends(1,Integer.parseInt(z1),Integer.parseInt(z2),Integer.parseInt(z3),Integer.parseInt(z4),Integer.parseInt(z5),Integer.parseInt(z6),Integer.parseInt(z7),Integer.parseInt(z8),Integer.parseInt(z9),Integer.parseInt(z10));
			int code = fs.pushFriends(f);
			HttpSession session = request.getSession();
			if(code == 1) {
				session.setAttribute("addstatus","ok");
				response.sendRedirect("jsp/control6.jsp");
			}else {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control6.jsp");
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
