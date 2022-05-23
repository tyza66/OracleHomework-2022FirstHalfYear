package com.yqxd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.yqxd.entity.Vegetables;
import com.yqxd.service.VegetablesService;
import com.yqxd.service.imp.VegetablesServiceImp;

/**
 * Servlet implementation class VegetablesController
 */
@WebServlet("/vegetable")
public class VegetablesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VegetablesController() {
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
		VegetablesService v = new VegetablesServiceImp();
		if(how.equals("1")) {
			List<Vegetables> vsList = v.getAllVegetable();
			request.setAttribute("elist",vsList);
			request.getRequestDispatcher("jsp/control2.jsp").forward(request, response);
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
