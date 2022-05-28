package com.yqxd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yqxd.entity.MessageInfo;
import com.yqxd.entity.Vegetables;
import com.yqxd.service.MessageInfoService;
import com.yqxd.service.VegetablesService;
import com.yqxd.service.imp.MessageInfoServiceImp;
import com.yqxd.service.imp.VegetablesServiceImp;

import oracle.jdbc.driver.Message;

/**
 * Servlet implementation class MessageController
 */
@WebServlet("/MessageController")
public class MessageController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public MessageController() {
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
		String how = request.getParameter("t");
		MessageInfoService m = new MessageInfoServiceImp();
		if (how.equals("1")) {// ��
			List<MessageInfo> meList = m.getAllMessage();
			request.setAttribute("mlist", meList);
			request.getRequestDispatcher("jsp/control7.jsp").forward(request, response);
		} else if (how.equals("2")) {// ��
			String id = request.getParameter("id");
			String phone = request.getParameter("phone");
			String time = request.getParameter("time");
			String passage = request.getParameter("passage");
			int code = m.addMessage(new MessageInfo(Integer.parseInt(id), phone, time, passage));
			HttpSession session = request.getSession();
			if (code == 1) {
				session.setAttribute("addstatus", "ok");
				response.sendRedirect("jsp/control7.jsp");
			} else {
				session.setAttribute("addstatus", "no");
				response.sendRedirect("jsp/control7.jsp");
			}
		} else if (how.equals("3")) {// ɾ
			String id = request.getParameter("id");
			int code = m.deleteMessage(Integer.parseInt(id));
			HttpSession session = request.getSession();
			if (code == 1) {
				session.setAttribute("addstatus", "dl");
				response.sendRedirect("jsp/control7.jsp");
			} else {
				session.setAttribute("addstatus", "no");
				response.sendRedirect("jsp/control7.jsp");
			}
		} else if (how.equals("4")) {
			String id = request.getParameter("id");
			String phone = request.getParameter("phone");
			String time = request.getParameter("time");
			String passage = request.getParameter("passage");
			int code = m.updateMessage(new MessageInfo(Integer.parseInt(id), phone, time, passage));
			HttpSession session = request.getSession();
			if (code == 1) {
				session.setAttribute("addstatus", "up");
				response.sendRedirect("jsp/control7.jsp");
			} else {
				session.setAttribute("addstatus", "no");
				response.sendRedirect("jsp/control7.jsp");
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
