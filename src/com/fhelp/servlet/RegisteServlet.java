package com.fhelp.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fhelp.base.BaseBean;
import com.fhelp.service.UserService;
import com.fhelp.service.impl.UserServiceImpl;
import com.google.gson.Gson;

public class RegisteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		//1.先从表单中获取注册信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String psw_comfirm = request.getParameter("psw_comfirm");
		
		//2.判断数据是否是有效的并将结果返回给客户端
		Gson gson = new Gson();
		BaseBean base = new BaseBean();
		UserService service = new UserServiceImpl();
		if(service.findUser(username)==null) {
			//当前
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
