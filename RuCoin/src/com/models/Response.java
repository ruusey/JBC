package com.models;

import java.sql.Timestamp;
import com.config.Config;

public class Response {
	private String message;
	private String HTMLmsg;
	private String time =null;
	private boolean success;
	private int status;
	public Response(String data, boolean success,String html, int status) {
		super();
		this.message = data;
		this.success = success;
		this.HTMLmsg = "";
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		this.time=(Config.TIMESTAMP_FORMAT.format(timestamp));
		this.status=status;
	}
	public Response(){
		
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getHTMLmsg() {
		return HTMLmsg;
	}
	public void setHTMLmsg(String hTMLmsg) {
		HTMLmsg = hTMLmsg;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	
	
	
	
}
