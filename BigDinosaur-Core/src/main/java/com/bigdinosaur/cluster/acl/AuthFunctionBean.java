package com.bigdinosaur.cluster.acl;

public interface AuthFunctionBean
{
  String[] authenticate(String userName, String password) throws Exception;
}
