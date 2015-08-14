package com.bigdinosaur.base.client.ui.response;


import java.util.HashSet;
import java.util.Set;


public class ValidatorImpl implements Validator {


  private static final Set<String> GRANT_TYPES = new HashSet<String>();

  

 
  
  public boolean validate(Object request) {
      validateGrantType(request);
      
      validateAttributes(request);
      
      validateAccessTokenRequest(request);
	return false;
      
  }




private void validateAccessTokenRequest(Object request) {
	
}




private void validateAttributes(Object request) {
	
}




private void validateGrantType(Object request) {
	// TODO Auto-generated method stub
	
}
  





}
