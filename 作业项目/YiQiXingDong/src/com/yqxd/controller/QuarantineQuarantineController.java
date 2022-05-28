package com.yqxd.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.yqxd.entity.QuarantineQuarantine;
import com.yqxd.service.QuarantineQuarantineService;
import com.yqxd.service.imp.QuarantineQuarantineServiceImp;

/**
 * Servlet implementation class QuarantineQuarantineController
 */
@WebServlet("/quarantinequarantine")
public class QuarantineQuarantineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QuarantineQuarantineController() {
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
		QuarantineQuarantineService qqs = new QuarantineQuarantineServiceImp();
		
		if(how.equals("1")) {//查询
			List<QuarantineQuarantine> qqList = qqs.getQuarantineQuarantine();
			request.setAttribute("qqlist",qqList);
			request.getRequestDispatcher("jsp/control1.jsp").forward(request, response);
			
		}else if(how.equals("2")) {//增加			
			 String id=request.getParameter("id")==""?"0":request.getParameter("id");
			 String name=request.getParameter("name")==""?"0":request.getParameter("name");
			 String sex=request.getParameter("sex")==""?"0":request.getParameter("sex");
			 String age=request.getParameter("age")==""?"0":request.getParameter("age");
			 String number=request.getParameter("number")==""?"0":request.getParameter("number");
			 String symptom=request.getParameter("symptom")==""?"0":request.getParameter("symptom");
			 String checkDate=request.getParameter("checkdate")==""?"0":request.getParameter("checkdate");
			 String quarantineDate=request.getParameter("indate")==""?"0":request.getParameter("indate");
			 String travelPath=request.getParameter("way")==""?"0":request.getParameter("way");
			 String password=request.getParameter("pwd")==""?"0":request.getParameter("pwd");
			 String did=request.getParameter("did")==""?"0":request.getParameter("did");
			 String rid=request.getParameter("rid")==""?"0":request.getParameter("rid");
			 String result=request.getParameter("hs")==""?"0":request.getParameter("hs");
			//直接不转，应该是接受数据就收不到String
			HttpSession session = request.getSession();
			if(id.equals("0")&&name.equals("0")&&sex.equals("0")&& age.equals("0") &&number.equals("0")&&symptom.equals("0")&&
					checkDate.equals("0")&&quarantineDate.equals("0")&&travelPath.equals("0")&&password.equals("0")&&
					did.equals("0")&&rid.equals("0")&&result.equals("0")) {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control1.jsp");
				return ;
			}
			
			int code=qqs.addQuarantineQuarantine(new QuarantineQuarantine(id,name,sex,Integer.parseInt(age),number,symptom,checkDate,
					quarantineDate,travelPath,password,Integer.parseInt(did),rid,result));
			
			if(code == 1) {
				session.setAttribute("addstatus","ok");
				response.sendRedirect("jsp/control1.jsp");
			}else {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control1.jsp");
			}
		}else if(how.equals("3")) {//删除
			String id =request.getParameter("id");
			int code =qqs.deleteQuarantineQuarantine(id);
			HttpSession session = request.getSession();
			if(code == 1) {
				session.setAttribute("addstatus","dl");
				response.sendRedirect("jsp/control1.jsp");
			}else {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control1.jsp");
			}
		}else if(how.equals("4")) {
			 String id=request.getParameter("id")==""?"0":request.getParameter("id");
			 String name=request.getParameter("name")==""?"0":request.getParameter("name");
			 String sex=request.getParameter("sex")==""?"0":request.getParameter("sex");
			 String age=request.getParameter("age")==""?"0":request.getParameter("age");
			 String number=request.getParameter("number")==""?"0":request.getParameter("number");
			 String symptom=request.getParameter("symptom")==""?"0":request.getParameter("symptom");
			 String checkDate=request.getParameter("checkdate")==""?"0":request.getParameter("checkdate");
			 String quarantineDate=request.getParameter("indate")==""?"0":request.getParameter("indate");
			 String travelPath=request.getParameter("way")==""?"0":request.getParameter("way");
			 String password=request.getParameter("pwd")==""?"0":request.getParameter("pwd");
			 String did=request.getParameter("did")==""?"0":request.getParameter("did");
			 String rid=request.getParameter("rid")==""?"0":request.getParameter("rid");
			 String result=request.getParameter("hs")==""?"0":request.getParameter("hs");
			
			 int code=qqs.updateQuarantineQuarantine(new QuarantineQuarantine(id,name,sex,Integer.parseInt(age),number,symptom,checkDate,
						quarantineDate,travelPath,password,Integer.parseInt(did),rid,result));
				HttpSession session = request.getSession();
			if(code == 1) {
				System.out.println(1);
				session.setAttribute("addstatus","up");
				response.sendRedirect("jsp/control1.jsp");
			}else {
				session.setAttribute("addstatus","no");
				response.sendRedirect("jsp/control1.jsp");
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
