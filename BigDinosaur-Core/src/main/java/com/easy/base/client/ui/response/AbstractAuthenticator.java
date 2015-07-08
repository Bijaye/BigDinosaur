package com.easy.base.client.ui.response;



import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public abstract class AbstractAuthenticator extends AbstractFilter {


  public static final String PRINCIPAL = "PRINCIPAL";

  @Override
  public final void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException,
      ServletException {
    authenticate((HttpServletRequest) request, (HttpServletResponse) response, chain, getAuthStateValue(request),
        getReturnUri(request));
  }

  public abstract boolean canCommence(HttpServletRequest request);


  
  public abstract void authenticate(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
      String authStateValue, String returnUri) throws IOException, ServletException;

  protected final void setPrincipal(ServletRequest request, AuthenticatedPrincipal principal) {
    request.setAttribute(PRINCIPAL, principal);
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }
}
