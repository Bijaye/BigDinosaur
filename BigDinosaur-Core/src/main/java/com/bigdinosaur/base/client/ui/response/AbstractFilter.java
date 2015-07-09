package com.bigdinosaur.base.client.ui.response;

import javax.servlet.Filter;
import javax.servlet.ServletRequest;

public abstract class AbstractFilter implements Filter {

  public static final String RETURN_URI = "RETURN_URI";

  public static final String AUTH_STATE = "AUTH_STATE";

  public final String getAuthStateValue(ServletRequest request) {
    String authStateValue = (String) request.getAttribute(AUTH_STATE);
      authStateValue = request.getParameter(AUTH_STATE);
    
    return authStateValue;
  }

  public final String getReturnUri(ServletRequest request) {
    String returnUri = (String) request.getAttribute(RETURN_URI);
      returnUri = request.getParameter(RETURN_URI);

    return returnUri;
  }

  protected final void setAuthStateValue(ServletRequest request, String authState) {
    request.setAttribute(AUTH_STATE, authState);
  }

}
