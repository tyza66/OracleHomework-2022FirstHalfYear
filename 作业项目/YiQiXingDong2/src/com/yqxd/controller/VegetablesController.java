package com.yqxd.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		//how是用来判断请求的意图，就是我想每个实体，只用以一个sevlet实现全部功能
		String how = request.getParameter("t");
		VegetablesService v = new VegetablesServiceImp();
		if(how.equals("1")) {//查询
			List<Vegetables> vsList = v.getAllVegetable();
			request.setAttribute("vlist",vsList);
			request.getRequestDispatcher("jsp/control2.jsp").forward(request, response);
		}else if(how.equals("2")) {//增加
			String id = request.getParameter("id")==""?"0":request.getParameter("id");
			String kind = request.getParameter("kind")==""?"0":request.getParameter("kind");
			String number = request.getParameter("number")==""?"0":request.getParameter("number");
			String place = request.getParameter("place")==""?"0":request.getParameter("place");
			HttpSession session = request.getSession();
			if(id.equals("0")&&kind.equals("0")&&number.equals("0")&&place.equals("0")) {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control2.jsp");
				return ;
			}
			int code = v.addVegetable(new Vegetables(Integer.parseInt(id),kind,Integer.parseInt(number),place));
			if(code == 1) {
				session.setAttribute("addstatus","ok");
				response.sendRedirect("jsp/control2.jsp");
			}else {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control2.jsp");
			}
		}else if(how.equals("3")) {//删除
			String id = request.getParameter("id");
			int code = v.deleteVegetable(Integer.parseInt(id));
			HttpSession session = request.getSession();
			if(code == 1) {
				session.setAttribute("addstatus","dl");
				response.sendRedirect("jsp/control2.jsp");
			}else {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control2.jsp");
			}
		}else if(how.equals("4")) {
			String id = request.getParameter("id")==""?"0":request.getParameter("id");
			String kind = request.getParameter("kind")==""?"0":request.getParameter("kind");
			String number = request.getParameter("number")==""?"0":request.getParameter("number");
			String place = request.getParameter("place")==""?"0":request.getParameter("place");
			int code = v.updateVegetable(new Vegetables(Integer.parseInt(id),kind,Integer.parseInt(number),place));
			HttpSession session = request.getSession();
			if(code == 1) {
				session.setAttribute("addstatus","up");
				response.sendRedirect("jsp/control2.jsp");
			}else {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control2.jsp");
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
