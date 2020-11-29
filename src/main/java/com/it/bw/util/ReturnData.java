package com.it.bw.util;

import java.util.Map;

public class ReturnData {
	private Integer status;
	private String msg;
	private Object data;
	
	public ReturnData() {
		this.status = 1;
		this.msg = "ok";
		this.data = null;
	}

	public ReturnData(Integer status, String msg, Object data) {
		this.status = status;
		this.msg = msg;
		this.data = data;
	}

	public ReturnData(Object object) {
		this.status = 1;
		this.msg = "ok";
		this.data = object;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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
