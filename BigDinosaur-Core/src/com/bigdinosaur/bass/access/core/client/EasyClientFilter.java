package com.bigdinosaur.bass.access.core.client;

import io.buji.pac4j.ClientFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.authc.AuthenticationToken;

public class EasyClientFilter extends ClientFilter{
	protected AuthenticationToken createToken(ServletRequest request,
			ServletResponse response) throws Exception {
		AuthenticationToken easytoken= super.createToken(request, response);
		return easytoken;
	}

}
