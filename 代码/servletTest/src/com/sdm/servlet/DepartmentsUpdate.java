package com.sdm.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdm.dao.Departments;
import com.sdm.dao.DepartmentsDao;

/**
 * Servlet implementation class DepartmentsUpdate
 */
@WebServlet("/departments/update.do")
public class DepartmentsUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DepartmentsUpdate() {
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
		String did = request.getParameter("did");
		System.out.println(did);
		String dname = request.getParameter("dname");
		String mid = request.getParameter("mid");
		String lid = request.getParameter("lid");
		int departmentsId = Integer.parseInt(did);
		int managerId = Integer.parseInt(mid);
		int locationId = Integer.parseInt(lid);
		Departments d = new Departments(departmentsId, dname, managerId, locationId);
		DepartmentsDao dd = new DepartmentsDao();
		int code = dd.updateById(d);
		PrintWriter out = response.getWriter();
		out.print(code+"条数据被修改");
		out.close();
		System.out.println(code);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
