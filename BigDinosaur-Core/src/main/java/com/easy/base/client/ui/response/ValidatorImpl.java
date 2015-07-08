package com.easy.base.client.ui.response;


import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;


public class ValidatorImpl implements Validator {


  private static final Set<String> GRANT_TYPES = new HashSet<String>();

  

 
  
  @Override
  public boolean validate(HttpServletRequest request) {
      validateGrantType(request);
      
      validateAttributes(request);
      
      validateAccessTokenRequest(request);
	return false;
      
  }




private void validateAccessTokenRequest(HttpServletRequest request) {
	
}




private void validateAttributes(HttpServletRequest request) {
	
}




private void validateGrantType(HttpServletRequest request) {
	// TODO Auto-generated method stub
	
}
  





}
