package com.fhelp.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fhelp.base.BaseBean;
import com.fhelp.base.Task;
import com.fhelp.service.UserService;
import com.fhelp.service.impl.UserServiceImpl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SendTaskServlet extends HttpServlet {

	Task task;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		Gson gson = new GsonBuilder().serializeNulls().create();
		BaseBean base = new BaseBean();
		UserService service = new UserServiceImpl();
		task = new Task();
		task.setUserId(Integer.parseInt(request.getParameter("userId")));
		// 任务类型 1现金 2积分 3无偿
		int type = Integer.parseInt(request.getParameter("taskType"));
		task.setType(type);
		task.setTasklabel(request.getParameter("taskLabel"));
		// task.setTaskPhoto(request.getParameter("taskPhoto"));
		// 任务状态 1表示刚发布未接取，2表示进行中 ，3表示已完成
		task.setState(1);
		task.setRemunertype(type);
		if (type == 1 || type == 2)
			task.setRemuneration(Double.parseDouble(request.getParameter("taskReward")));
		else
			task.setRemuneration(0);
		if ("0".equals(request.getParameter("taskTimeLimit")))
			task.setTimelimit("0");
		else
			task.setTimelimit(request.getParameter("taskTimeLimit"));
		task.setTaskName(request.getParameter("taskName"));
		task.setTaskDesc(request.getParameter("taskInfo"));
		task.setLoc(request.getParameter("taskLocation"));
		task.setCommentList("0,");
		task.setStartTime(new Date(System.currentTimeMillis()));
		if (service.sendTask(task)) {
			base.setCode(200);
			base.setMsg("发布任务成功");
			base.setData(task);
		} else {
			base.setCode(201);
			base.setMsg("发布任务失败");
		}
		response.getWriter().println(gson.toJson(base));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
