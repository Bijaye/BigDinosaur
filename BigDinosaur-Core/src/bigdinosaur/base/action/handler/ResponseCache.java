package bigdinosaur.base.action.handler;



public interface ResponseCache {

  void getVerifyToken(String accessToken);

  void storeVerifyToken(String accessToken);
}
