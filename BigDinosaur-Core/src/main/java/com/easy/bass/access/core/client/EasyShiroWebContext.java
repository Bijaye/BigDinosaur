package com.easy.bass.access.core.client;

import io.buji.pac4j.ShiroWebContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EasyShiroWebContext extends ShiroWebContext{
	public EasyShiroWebContext(HttpServletRequest request,
			HttpServletResponse response) {
		super(request, response);
	}
	

}
