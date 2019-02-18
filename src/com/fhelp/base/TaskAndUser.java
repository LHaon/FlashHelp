package com.fhelp.base;

/**
 * 封装任务和用户对象
 * 
 * @author Fan
 *
 */
public class TaskAndUser {
	private User user;
	private Task task;

	
	
	
	public TaskAndUser() {
		super();
	}

	public TaskAndUser(User user, Task task) {
		super();
		this.user = user;
		this.task = task;
	}

	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

}
