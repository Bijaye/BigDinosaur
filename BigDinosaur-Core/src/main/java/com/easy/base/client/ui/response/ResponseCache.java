package com.easy.base.client.ui.response;



public interface ResponseCache {

  void getVerifyToken(String accessToken);

  void storeVerifyToken(String accessToken);
}
