package com.easy.base.client.ui.response;


import java.io.IOException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class UserConsentFilter implements Filter {



  private AuthorizetHandler userConsentHandler;

  @Override
  public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
    HttpServletRequest request = (HttpServletRequest) req;
    HttpServletResponse response = (HttpServletResponse) res;

        chain.doFilter(request, response);
      userConsentHandler.doFilter(request, response, chain);
    }



  private boolean initialRequest(HttpServletRequest request) {
    return  request.getAttribute(AbstractAuthenticator.PRINCIPAL) != null;
  }

  public void setUserConsentHandler(AuthorizetHandler userConsentHandler) {
    this.userConsentHandler = userConsentHandler;
  }

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {
  }

  @Override
  public void destroy() {
  }

}
