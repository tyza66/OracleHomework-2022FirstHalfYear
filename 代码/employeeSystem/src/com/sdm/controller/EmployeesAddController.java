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
 * Servlet implementation class EmployeesAddController
 */
@WebServlet("/employees/add.do")
public class EmployeesAddController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeesAddController() {
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
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		String phoneNumber = request.getParameter("phonenumber");
		String jobId = request.getParameter("jobid");
		double salary = Double.parseDouble(request.getParameter("salary"));
		double commissionPct = Double.parseDouble(request.getParameter("commissionpct")==null?"0":request.getParameter("commissionpct"));
		int managerId = Integer.parseInt(request.getParameter("managerid"));
		int departmentId = Integer.parseInt(request.getParameter("departmentid"));
		Employees e = new Employees(employeeId,firstName,lastName,email,phoneNumber,null,jobId,salary,commissionPct,managerId,departmentId);
		EmployeesService employeesService = new EmployeesServiceImp();
		int code = employeesService.employeeAdd(e);
		if(code == 0) {
			
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
