package com.bigdinosar.oltu.extend;

import javax.servlet.http.HttpServletRequest;

import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

public class OAuthTokenRequestExtend extends  OAuthTokenRequest {

	public OAuthTokenRequestExtend(HttpServletRequest request)
			throws OAuthSystemException, OAuthProblemException {
		super(request);
	}
	public String getUserRoleType(){
		System.out.println(request.getParameter("userType"));
		return request.getParameter("userType");
	}

}
