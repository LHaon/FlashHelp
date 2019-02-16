package com.fhelp.base;

import java.util.Date;

/**
 * 评论对象
 * @author Fan
 *
 */
public class Comment {
	private int commentId;
	private int userId;
	private String commentText;// 评论内容
	private Date commentTime;// 评论时间

	public Comment() {
		super();
	}

	public int getCommentId() {
		return commentId;
	}

	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getCommentText() {
		return commentText;
	}

	public void setCommentText(String commentText) {
		this.commentText = commentText;
	}

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
		this.commentTime = commentTime;
	}

}
