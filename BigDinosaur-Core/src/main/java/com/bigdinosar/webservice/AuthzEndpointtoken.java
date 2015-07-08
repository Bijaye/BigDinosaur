/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdinosar.webservice;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
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
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;

@Path("/authztoken")
public class AuthzEndpointtoken {
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Response authorize(@Context HttpServletRequest request)
			throws URISyntaxException, OAuthSystemException,
			OAuthProblemException, JSONException {
		try {
			OAuthTokenRequest oauthRequest = null;
			oauthRequest = new OAuthTokenRequest(request);

			String clientid = oauthRequest.getClientId();
			String clientsecret = oauthRequest.getClientSecret();
			if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(
					GrantType.AUTHORIZATION_CODE.toString())) {
				Client client = Client.create();

				WebResource webResource = client
						.resource(Utils.BigDinosaur_AUTHZ_TOKEN_SPRING);
				MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
				queryParams.add("param1", clientid);
				queryParams.add("param2", clientsecret);
				String s = webResource.queryParams(queryParams).get(
						String.class);

			
				JSONObject obj = new JSONObject(s);
			
				boolean haserror1 = obj.getBoolean("haserror");

				if (haserror1) {
					OAuthResponse response1 = OAuthASResponse
							.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
							.setError(OAuthError.TokenResponse.INVALID_GRANT)
							.setErrorDescription("invalid authorization code")
							.buildJSONMessage();
					return Response.status(response1.getResponseStatus())
							.entity(response1.getBody()).build();
				} else {
					String accessToken = (String) obj.get("accessToken");
					String refreshToken = (String) obj.get("refreshToken");
					String expiresIn = (String) obj.get("expiresIn");
					String signature = (String) obj.get("signature");
					String tokentype = (String) obj.get("tokentype");

					OAuthResponse response1 = OAuthASResponse
							.tokenResponse(HttpServletResponse.SC_OK)
							.setAccessToken(accessToken)
							.setExpiresIn(expiresIn)
							.setRefreshToken(refreshToken)
							.setTokenType(tokentype)
							.setParam(signature, signature).buildJSONMessage();
					return Response.status(response1.getResponseStatus())
							.entity(response1.getBody()).build();

				}
			}
		}
		 catch (OAuthProblemException e) {

			final Response.ResponseBuilder responseBuilder = Response
					.status(HttpServletResponse.SC_FOUND);

			String redirectUri = e.getRedirectUri();

			if (OAuthUtils.isEmpty(redirectUri)) {
				throw new WebApplicationException(responseBuilder.entity(
						"OAuth callback url needs to be provided by client!!!")
						.build());
			}
			final OAuthResponse response = OAuthASResponse
					.errorResponse(HttpServletResponse.SC_FOUND).error(e)
					.location(redirectUri).buildQueryMessage();
			final URI location = new URI(response.getLocationUri());
			return responseBuilder.location(location).build();
		}
		return null;
	}
}
