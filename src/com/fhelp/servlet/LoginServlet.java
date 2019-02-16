package com.fhelp.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fhelp.base.User;
import com.fhelp.dao.UserDao;
import com.fhelp.dao.impl.UserDaoImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

/**
 * 登录Servlet
 *
 */
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDao uDI = new UserDaoImpl();
		JsonObject json = new JsonObject();
		Gson gson = new Gson();
		User user = null;
		boolean flag = uDI.login(username, password);
		if (flag) {
			user = uDI.findUser(username);
			json.addProperty("loginFlag", true);
			json.addProperty("username", user.getUsername());
			json.addProperty("password", user.getPassword());
			json.addProperty("credit", user.getCredit());
			json.addProperty("balance", user.getBalance());
			json.addProperty("integral", user.getIntegral());
		} else {
			json.addProperty("loginFlag", false);
		}
		response.getWriter().write(gson.toJson(json));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
