package com.base.easy.action.standalone;

public interface Login {
	void LoginRmi(Object c);
	void Authenticate();
	void Authorize();
	void CreateRemoteUserSystem();
	String getUserName();
	String getSessionid();

}
