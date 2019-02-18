package com.fhelp.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fhelp.base.BaseBean;
import com.fhelp.base.Task;
import com.fhelp.base.TaskAndUser;
import com.fhelp.base.User;
import com.fhelp.service.UserService;
import com.fhelp.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class ShowTaskServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String taskType = request.getParameter("taskType");
		UserService service = new UserServiceImpl();
		List<Task> tasks = service.getTask(taskType);
		BaseBean base = new BaseBean();
		List<TaskAndUser> list = new ArrayList<>();
		Gson gson = new GsonBuilder().serializeNulls().create();
		if (tasks == null) {
			base.setCode(404);
			base.setMsg("找不到页面,请检查您的网络");
			base.setData(null);
		} else {
			for (Task task : tasks) {
				User user = service.getUserById(task.getUserId());
				list.add(new TaskAndUser(user, task));
			}
			base.setCode(200);
			base.setMsg("请求页面成功");
			base.setData(list);
		}
		response.getWriter().println(gson.toJson(base));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
