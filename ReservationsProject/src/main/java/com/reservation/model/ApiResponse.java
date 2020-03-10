package com.reservation.model;

public class ApiResponse {

	private Boolean success;
	private String messagge;
	
	public ApiResponse(Boolean success, String messagge) {
		super();
		this.success = success;
		this.messagge = messagge;
	}

	public ApiResponse() {
		// TODO Auto-generated constructor stub
	}

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public String getMessagge() {
		return messagge;
	}

	public void setMessagge(String messagge) {
		this.messagge = messagge;
	}
	
	
}
