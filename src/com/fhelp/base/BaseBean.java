package com.fhelp.base;

/**
 * 封装返回给客户端的数据
 * @author Fan
 *
 */
public class BaseBean {
	private int code;//状态码
	private String msg;//结果信息
	private Object data;//数据
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
