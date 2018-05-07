package com.neuedu.bean;

public class ResponseInfo<T> {

	private boolean result;
	private String msg;
	private T data;

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public ResponseInfo(boolean result, String msg, T data) {
		super();
		this.result = result;
		this.msg = msg;
		this.data = data;
	}

	public ResponseInfo() {
		super();
	}

	public ResponseInfo(boolean result, String msg) {
		super();
		this.result = result;
		this.msg = msg;
	}

}
