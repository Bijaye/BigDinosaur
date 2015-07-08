package com.easy.base.client.ui.request;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

import com.easy.base.skeleton.BaseUI;

public class UiobjectRequest extends HttpServletRequestWrapper implements BaseUI{

	public UiobjectRequest(HttpServletRequest request) {
		super(request);
		
	}

}
