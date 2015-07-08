package com.bigdinosar.webservice;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.oltu.oauth2.as.request.OAuthTokenRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.GrantType;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
@Path("/passwordauthzorization")
public class PasswordEndpoint {
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Response authorize(@Context HttpServletRequest request)
			throws OAuthSystemException, URISyntaxException, JSONException {
		try {
			System.out.println("called from kamal");
	
		OAuthTokenRequest oauthRequest = null;
		oauthRequest = new OAuthTokenRequest(request);
	 if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equalsIgnoreCase(GrantType.PASSWORD.toString()))
			{
			String username = oauthRequest.getUsername();
			String password = oauthRequest.getPassword();
			Client client = Client.create();
			WebResource webResource1 = client
					.resource(Utils.BigDinosaur_AUTHZ_TOKEN_SPRINGIMPLICT);
			MultivaluedMap<String,String> queryParams = new MultivaluedMapImpl();
			queryParams.add("param1", username);
			queryParams.add("param2", password);
			String s = webResource1.queryParams(queryParams).get(
					String.class);
		

		JSONObject obj = new JSONObject(s);
		boolean haserror1 = obj.getBoolean("haserror");
		if (haserror1) {
			OAuthResponse response5 = OAuthASResponse
					.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
					.setError(OAuthError.TokenResponse.INVALID_GRANT)
					.setErrorDescription("invalid username or password")
					.buildJSONMessage();
			return Response.status(response5.getResponseStatus())
					.entity(response5.getBody()).build();

		}
		else{
			String accessToken  =  (String) obj.get("accessToken"); 
			String refreshToken =  (String) obj.get("refreshToken"); 
			Integer expiresIn    =  (Integer) obj.get("expiresIn"); 
			Integer userId    =  (Integer) obj.get("userId"); 
			String tokentype  =  (String) obj.get("tokentype"); 
			
			 OAuthResponse response1 = OAuthASResponse
	                    .tokenResponse(HttpServletResponse.SC_OK)
	                    .setAccessToken(accessToken)
	                    .setExpiresIn(expiresIn.toString())
	                    .setRefreshToken(refreshToken)
	                    .setTokenType(tokentype)
	                    .setParam("userId", userId.toString())
	                    .buildJSONMessage();
	            return Response.status(response1.getResponseStatus()).entity(response1.getBody()).build();

			
		}
	 }}
 catch (OAuthProblemException e) {
	OAuthResponse res = OAuthASResponse
			.errorResponse(HttpServletResponse.SC_BAD_REQUEST).error(e)
			.buildJSONMessage();
	return Response.status(res.getResponseStatus())
			.entity(res.getBody()).build();
}
		return null;


}}