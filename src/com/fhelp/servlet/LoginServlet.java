package com.fhelp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fhelp.base.BaseBean;
import com.fhelp.base.User;
import com.fhelp.dao.UserDao;
import com.fhelp.dao.impl.UserDaoImpl;
import com.fhelp.service.UserService;
import com.fhelp.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * 登录Servlet
 *
 */
public class LoginServlet extends HttpServlet {

	UserService service = new UserServiceImpl();
	// 数据传输对象
	Gson gson = new Gson();
	BaseBean base = new BaseBean();
	String username;
	String password;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");

		username = request.getParameter("username");
		password = request.getParameter("password");

		User user = new User();
		boolean flag = false;
		try {
			flag = service.login(username, password);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (flag) {
			// 用户部分信息
			try {
				user = service.findUser(username);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			// 用户所有的信息
			// service.findAllMsg(user, user.getUserId());
			base.setCode(200);
			base.setMsg("登录成功！");
		} else {
			base.setCode(404);
			base.setMsg("账号或者密码不正确！");
		}
		base.setData(user);
		response.getWriter().println(gson.toJson(base));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
