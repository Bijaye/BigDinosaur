package com.easy.base.client.ui.request;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.bigdinosaur.base.skeleton.BaseUI;

public class UiobjectResponse extends HttpServletResponseWrapper implements BaseUI{

	public UiobjectResponse(HttpServletResponse response) {
		super(response);
	}

}
