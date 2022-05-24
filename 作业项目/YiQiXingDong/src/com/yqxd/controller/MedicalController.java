package com.yqxd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yqxd.entity.Medical;
import com.yqxd.entity.Vegetables;
import com.yqxd.service.MedicalService;
import com.yqxd.service.imp.MedicalServiceImp;

/**
 * Servlet implementation class MedicalController
 */
@WebServlet("/Medical")
public class MedicalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MedicalController() {
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
		MedicalService v = new MedicalServiceImp();
		if(how.equals("1")) {//查询
			List<Medical> vsList = v.getAllMedical();
			request.setAttribute("vlist",vsList);
			request.getRequestDispatcher("jsp/control8.jsp").forward(request, response);
		}else if(how.equals("2")) {//增加
			String id = request.getParameter("id");
			String time = request.getParameter("time");
			String pname = request.getParameter("pname");
			String dname = request.getParameter("dname");
			String classify = request.getParameter("classify");
			int code = v.addMedical(new Medical(Integer.parseInt(id),time,pname,dname,classify));
			HttpSession session = request.getSession();
			if(code == 1) {
				session.setAttribute("addstatus","ok");
				response.sendRedirect("jsp/control8.jsp");
			}else {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control8.jsp");
			}
		}else if(how.equals("3")) {//删除
			String id = request.getParameter("id");
			int code = v.deleteMedical(Integer.parseInt(id));
			HttpSession session = request.getSession();
			if(code == 1) {
				session.setAttribute("addstatus","dl");
				response.sendRedirect("jsp/control8.jsp");
			}else {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control8.jsp");
			}
		}else if(how.equals("4")) {
			String id = request.getParameter("id");
			String time = request.getParameter("time");
			String pname = request.getParameter("pname");
			String dname = request.getParameter("dname");
			String classify = request.getParameter("classify");
			int code = v.updateMedical(new Medical(Integer.parseInt(id),time,pname,dname,classify));
			HttpSession session = request.getSession();
			if(code == 1) {
				session.setAttribute("addstatus","up");
				response.sendRedirect("jsp/control8.jsp");
			}else {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control8.jsp");
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
