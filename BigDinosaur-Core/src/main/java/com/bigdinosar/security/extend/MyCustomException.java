package com.bigdinosar.security.extend;

import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

public class MyCustomException extends OAuthSystemException {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4608468577865798578L;

	public MyCustomException(String exception) {
		super(exception);

	}

}
