package com.fhelp.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fhelp.base.BaseBean;
import com.fhelp.base.User;
import com.fhelp.service.UserService;
import com.fhelp.service.impl.UserServiceImpl;
import com.fhelp.util.JavaBaseUtil;
import com.google.gson.Gson;

public class RegisteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 1.先从表单中获取注册信息
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String psw_comfirm = request.getParameter("psw_comfirm");

		// 2.判断数据是否是有效的并将结果返回给客户端
		Gson gson = new Gson();
		BaseBean base = new BaseBean();
		UserService service = new UserServiceImpl();
		User user = new User();
		if (service.findUser(username) != null) {
			// 当前用户已经被注册
			base.setCode(101);
			base.setMsg("该账号已经被注册！");
			base.setData(user);
		} else if (!password.equals(psw_comfirm)) {
			// 两次输入的密码不相等
			base.setCode(102);
			base.setMsg("两次密码输入的不一致");
			base.setData(user);
		} else if (!JavaBaseUtil.checkUsername(username)) {
			base.setCode(103);
			base.setMsg("只能是以字母开头(不区分大小写)、6-16位、不包含特殊符号（、_.%$#@!)和空格");
			base.setData(user);
		} else if (!JavaBaseUtil.checkPassword(password)) {
			base.setCode(104);
			base.setMsg("长度为6-16位 但不能是9位以下纯数字且可以包含字母、数字、特殊符号(~!@#$%^&*()_+[]{}|\\;:'\",./<>?)");
			base.setData(user);
		}else {
			//信息正确
			base.setCode(200);
			base.setMsg("注册成功");
			user.setUsername(username);
			user.setPassword(password);
			Date date = new Date(System.currentTimeMillis());
			user.setRegistertime(date);
			user.setAutograph("这个人是个猪，没写任何东西");
			base.setData(user);
			//添加到数据库中
			service.register(user);
		}
		response.getWriter().println(gson.toJson(base));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
