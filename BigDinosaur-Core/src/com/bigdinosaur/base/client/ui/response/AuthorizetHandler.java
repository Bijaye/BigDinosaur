package com.bigdinosaur.base.client.ui.response;


import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public abstract class AuthorizetHandler extends AbstractFilter {

  public static final String GRANTED_SCOPES = "GRANTED_SCOPES";


  @Override
  public final void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
      ServletException {
    handleUserConsent((HttpServletRequest) request, (HttpServletResponse) response, chain, getAuthStateValue(request),
        getReturnUri(request));
  }

  public abstract void handleUserConsent(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      String authStateValue, String returnUri) throws IOException, ServletException;

  
  protected final void setGrantedScopes(ServletRequest request, String[] scopes) {
    request.setAttribute(GRANTED_SCOPES, scopes);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }

}
