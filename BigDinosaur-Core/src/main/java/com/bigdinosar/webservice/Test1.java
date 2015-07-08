package com.bigdinosar.webservice;

import java.io.Serializable;

public class Test1 implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5706962198178701967L;
	/**
  * 
  */

	private String name;
	private String address;
	private String userid;
	
	private String username;
	private String password;
	private String grant_type;
	private boolean haserror;
	private String errorMessage;
	private String userType;
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getGrant_type() {
		return grant_type;
	}

	public void setGrant_type(String grant_type) {
		this.grant_type = grant_type;
	}

	

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public boolean isHaserror() {
		return haserror;
	}

	public void setHaserror(boolean haserror) {
		this.haserror = haserror;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

}