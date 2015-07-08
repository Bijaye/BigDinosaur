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


/**
 * <<Description Here>>
 * @author abis
 * @version 
 * @since
 */
@Path("/refreshtokenauthzorizationdimple")
public class RefreshTokenEndpointMyDimple {
 	public static final String BigDinosaur_AUTHZ_TOKEN_SPRINGIMPLICT_MyDIMPLE ="http://localhost:8090/BigDinosaur-Resource/springrefreshtokenmydimple";
//	public static final String BigDinosaur_AUTHZ_TOKEN_SPRINGIMPLICT_MyDIMPLE ="http://localhost:8090/BigDinosaur-Resource";
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Response authorize(@Context HttpServletRequest request)
			throws OAuthSystemException, URISyntaxException, JSONException {
		try {
			System.out.println("called from kamal");
	
		OAuthTokenRequest oauthRequest = null;
		oauthRequest = new OAuthTokenRequest(request);
		if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(
				GrantType.REFRESH_TOKEN.toString())) {
			String refreshtoken = oauthRequest.getRefreshToken();
			String clientid = oauthRequest.getClientId();
			Client client1 = Client.create();
			WebResource webResource1 = client1
					.resource(Utils.BigDinosaur_AUTHZ_TOKEN_REFRESHTOKEN);
			MultivaluedMap<String, String> queryParams1 = new MultivaluedMapImpl();
			queryParams1.add("param1", refreshtoken);
			queryParams1.add("param2", clientid);
			String s1 = webResource1.queryParams(queryParams1).get(
					String.class);

			JSONObject obj = new JSONObject(s1);
			boolean haserror1 = obj.getBoolean("haserror");
			if (haserror1) {

				OAuthResponse response4 = OAuthASResponse
						.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
						.setError(OAuthError.TokenResponse.INVALID_GRANT)
						.setErrorDescription("invalid refresh token ")
						.buildJSONMessage();
				return Response.status(response4.getResponseStatus())
						.entity(response4.getBody()).build();
			} else {
				String accessToken = (String) obj.get("accessToken");
				String refreshToken = (String) obj.get("refreshToken");
				String expiresIn = (String) obj.get("expiresIn");
//				String signature = (String) obj.get("signature");
//				String tokentype = (String) obj.get("tokentype");

				OAuthResponse response1 = OAuthASResponse
						.tokenResponse(HttpServletResponse.SC_OK)
						.setAccessToken(accessToken)
						.setExpiresIn(expiresIn)
						.setRefreshToken(refreshToken)
//						.setTokenType(tokentype)
//						.setParam(signature, signature)
						.buildJSONMessage();
				return Response.status(response1.getResponseStatus())
						.entity(response1.getBody()).build();

			}

		}
	} catch (OAuthProblemException e) {
		OAuthResponse res = OAuthASResponse
				.errorResponse(HttpServletResponse.SC_BAD_REQUEST).error(e)
				.buildJSONMessage();
		return Response.status(res.getResponseStatus())
				.entity(res.getBody()).build();
	}
		return null;

}}