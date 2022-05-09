package com.chinasoft.wxx.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
//注解  ---约定   url mappings 必须以/开头  ！！！！
//@WebServlet("/first.do")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     * 构造器
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//---------编写代码区！！！！-----------
		//设置响应的字符集
		response.setCharacterEncoding("utf-8");
		//获取输出流【输出工具】
		PrintWriter out = response.getWriter();
		//进行逻辑处理
		for(int i=1;i<=8;i++) {
			if(i%2==0) {
				out.print("<h1 style='color:red'>你好！！！</h1>");
			}else {
				out.print("<h1 style='color:green'>你好！！！</h1>");
			}
		}
		//关闭流
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
