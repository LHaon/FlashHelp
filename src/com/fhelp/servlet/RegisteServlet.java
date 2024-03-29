package com.fhelp.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

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
import com.google.gson.GsonBuilder;

/**
 * 注册Servlet
 * 
 * @author Fan
 *
 */
public class RegisteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		// 1.先从表单中获取注册信息
		String account = request.getParameter("account");
		String password = request.getParameter("password");
		// String psw_comfirm = request.getParameter("psw_comfirm");

		// 2.判断数据是否是有效的并将结果返回给客户端
		Gson gson = new GsonBuilder().serializeNulls().create();
		BaseBean base = new BaseBean();
		UserService service = new UserServiceImpl();
		User user = new User();
		// TODO 这个地方要改 应该从个人资料表里面去查重
		User uu = null;
		try {
			uu = service.findUser(account);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		if (uu != null) {
			// 当前用户已经被注册
			base.setCode(101);
			base.setMsg("该账号已经被注册！");
			base.setData(user);
			// } else if (!password.equals(psw_comfirm)) {
			// // 两次输入的密码不相等
			// base.setCode(102);
			// base.setMsg("两次密码输入的不一致");
			// base.setData(user);
		} else if (!JavaBaseUtil.checkUsername(account)) {
			base.setCode(103);
			base.setMsg("4-16位 (字母，数字，汉字，下划线，减号)，不能含有空格！");
			base.setData(user);
		} else if (!JavaBaseUtil.checkPassword(password)) {
			base.setCode(104);
			base.setMsg("长度为6-16位 但不能是9位以下纯数字且可以包含字母、数字、特殊符号(~!@#$%^&*()_+[]{}|\\;'\",./<>?)");
			base.setData(user);
		} else {
			// 信息正确
			// 获取最后一条记录推算出下一个人的id
			User u = null;
			try {
				u = service.getLastUser();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			int last_user_id = u == null ? 0 : u.getUserId();
			base.setCode(200);
			base.setMsg("注册成功");
			user.setUsername(account);
			user.setNikename("help_" + UUID.randomUUID().toString().split("-")[0] + (last_user_id + 1));
			user.setPassword(password);
			user.setUserId(last_user_id + 1);
			Date date = new Date(System.currentTimeMillis());
			user.setRegistertime(date);
			user.setFollow("0");
			user.setFans("0");
			user.setSendList("0");
			user.setAccept("0");
			user.setCollection("0");
			user.setFinish("0");
			user.setOfftenTask("0");
			user.setPhoto("");
			user.setSex(0);
			user.setLocation("康定");
			user.setAutograph("这个人很懒，什么都没有留下");
			base.setData(user);//
			// 添加到数据库中
			service.register(user);
		}
		response.getWriter().println(gson.toJson(base));
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}
