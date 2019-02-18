package com.fhelp.base;

import java.util.Date;
import java.util.List;

/**
 * 任务对象
 * 
 * @author Fan
 *
 */
public class Task {
	private int taskId;// 任务id
	private int userId;// 发布此任务的用户
	private int type;// 任务类型
	private int state;// 任务状态
	private int remunertype;// 酬劳类型
	private double remuneration;// 酬劳
	private String timelimit;// 时间限制
	private String taskName;// 任务名字
	private String taskDesc;// 任务描述
	private String loc;// 任务地点
	private List<Comment> commentList;// 评论列表
	private int upCount;// 点赞数
	private int collecCount;// 收藏数
	private int clickCount;// 点击数
	private List<String> taskPhoto;// 任务相关图片
	private Date startTime;// 发布时间

	public Task() {
		super();
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public int getRemunertype() {
		return remunertype;
	}

	public void setRemunertype(int remunertype) {
		this.remunertype = remunertype;
	}

	public double getRemuneration() {
		return remuneration;
	}

	public void setRemuneration(double remuneration) {
		this.remuneration = remuneration;
	}

	public String getTimelimit() {
		return timelimit;
	}

	public void setTimelimit(String timelimit) {
		this.timelimit = timelimit;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public String getTaskDesc() {
		return taskDesc;
	}

	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}

	public String getLoc() {
		return loc;
	}

	public void setLoc(String loc) {
		this.loc = loc;
	}

	public int getUpCount() {
		return upCount;
	}

	public void setUpCount(int upCount) {
		this.upCount = upCount;
	}

	public int getCollecCount() {
		return collecCount;
	}

	public void setCollecCount(int collecCount) {
		this.collecCount = collecCount;
	}

	public int getClickCount() {
		return clickCount;
	}

	public void setClickCount(int clickCount) {
		this.clickCount = clickCount;
	}

	public List<String> getTaskPhoto() {
		return taskPhoto;
	}

	public void setTaskPhoto(List<String> taskPhoto) {
		this.taskPhoto = taskPhoto;
	}

	public List<Comment> getCommentList() {
		return commentList;
	}

	public void setCommentList(List<Comment> commentList) {
		this.commentList = commentList;
	}

	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

/*	@Override
	public String toString() {
		return "taskId:" + taskId + "userId:" + userId + "type:" + type + "state:" + state + "remunertype:"
				+ remunertype + "remuneration:" + remuneration + "timelimit:" + timelimit + "taskName:" + taskName
				+ "taskDesc:" + taskDesc + "loc:" + loc + "commentList:" + commentList + "upCount:" + upCount
				+ "collecCount:" + collecCount + "clickCount:" + clickCount + "taskPhoto:" + taskPhoto + "startTime:"
				+ startTime;
	}*/
	@Override
	public String toString() {
		return "taskId:"+taskId+",userId:"+userId;
	}

}
