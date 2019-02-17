package com.fhelp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fhelp.base.Task;
import com.fhelp.base.User;
import com.fhelp.service.UserService;
import com.fhelp.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class ShowTaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		UserService service = new UserServiceImpl();
		String taskType = request.getParameter("taskType");
		List<Task> task = service.getTask(taskType);
		List<User> user = new ArrayList<>()	;
		JsonObject json = new JsonObject();//存储数据
		Gson gson = new Gson();
		for(Task t:task) {
			//取出每个发布任务的用户
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
