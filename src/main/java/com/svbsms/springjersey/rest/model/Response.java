package com.svbsms.springjersey.rest.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {

	public int code;
	public boolean status;
	public String message;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Response [code=" + code + ", status=" + status + ", message=" + message + "]";
	}
	
	
}
