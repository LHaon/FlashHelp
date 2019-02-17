package com.fhelp.base;

import com.mysql.fabric.xmlrpc.base.Data;

/**
 * 订单类
 *
 */
public class Order {
	private int orderId;// 订单ID
	private int taskId;// 任务ID
	private int userIDS;// 发布任务用户ID
	private int userIDA;// 接取任务用户ID
	private int orderState;// 订单状态
	private Data time;// 订单生成时间

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserIDS() {
		return userIDS;
	}

	public void setUserIDS(int userIDS) {
		this.userIDS = userIDS;
	}

	public int getUserIDA() {
		return userIDA;
	}

	public void setUserIDA(int userIDA) {
		this.userIDA = userIDA;
	}

	public int getOrderState() {
		return orderState;
	}

	public void setOrderState(int orderState) {
		this.orderState = orderState;
	}

	public Data getTime() {
		return time;
	}

	public void setTime(Data time) {
		this.time = time;
	}
}
