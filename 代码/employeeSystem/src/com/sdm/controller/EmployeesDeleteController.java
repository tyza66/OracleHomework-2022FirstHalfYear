package com.sdm.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdm.entity.Employees;
import com.sdm.service.EmployeesService;
import com.sdm.service.imp.EmployeesServiceImp;

/**
 * Servlet implementation class EmployeesDeleteController
 */
@WebServlet("/employees/delete.do")
public class EmployeesDeleteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesDeleteController() {
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
		int employeeId = Integer.parseInt(request.getParameter("employeeid"));
		EmployeesService employeesService = new EmployeesServiceImp();
		int code = employeesService.employeeDelete(employeeId);
		if(code == 0) {
			request.setAttribute("deletetip", "刪除失败");
			request.getRequestDispatcher("employeesDelete.jsp").forward(request, response);
		}else {
			response.sendRedirect("/employeeSystem/employees/info.do");
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
