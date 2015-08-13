package com.bigdinosaur.bass.access.core.client;

import io.buji.pac4j.filter.ClientUserFilter;

import java.io.IOException;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class EasyClientUserFilter extends ClientUserFilter{
	protected boolean isLoginRequest(ServletRequest request,
			ServletResponse response) {
		return false;
	}

	protected void redirectToLogin(ServletRequest request,
			ServletResponse response) throws IOException {
		
	}

	
}
