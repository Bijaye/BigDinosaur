/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bigdinosar.webservice;

import java.net.URI;
import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.oltu.oauth2.as.request.OAuthAuthzRequest;
import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ResponseType;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;


@Path("/authz")
public class AuthzEndpoint {
	@GET
	public Response authorize(@Context HttpServletRequest request)
			throws URISyntaxException, OAuthSystemException,
			OAuthProblemException, JSONException {
		try {
			

			OAuthAuthzRequest oauthRequest = new OAuthAuthzRequest(request);

			OAuthResponse response = null;
			String responseType = oauthRequest
					.getParam(OAuth.OAUTH_RESPONSE_TYPE);
			String clientid = oauthRequest.getClientId();
			String clientsecret = oauthRequest.getClientSecret();
			OAuthASResponse.OAuthAuthorizationResponseBuilder builder = OAuthASResponse
					.authorizationResponse(request,
							HttpServletResponse.SC_FOUND);
			// code type

			if (responseType.equals(ResponseType.CODE.toString())) {

				Client client = Client.create();

				WebResource webResource = client
						.resource(Utils.BigDinosaur_AUTHZ_SPRING);
				MultivaluedMap<String,String> queryParams = new MultivaluedMapImpl();
				queryParams.add("param1", clientid);
				queryParams.add("param2",clientsecret);
				String s = webResource.queryParams(queryParams).get(
						String.class);

				//
				JSONObject obj = new JSONObject(s);
				String authCode = null;
				boolean haserror = obj.getBoolean("haserror");
				if (haserror) {

					response = OAuthASResponse
							.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
							.setError(OAuthError.TokenResponse.INVALID_CLIENT)
							.setErrorDescription("client_id not found")
							.buildJSONMessage();
					return Response.status(response.getResponseStatus())
							.entity(response.getBody()).build();

				}
				authCode = (String) obj.get("authorizationCode");
				//

				String redirectURI = oauthRequest
						.getParam(OAuth.OAUTH_REDIRECT_URI);
				builder.setCode(authCode);

				response = builder.location(redirectURI).buildQueryMessage();

				URI url = new URI(response.getLocationUri());
				return Response.status(response.getResponseStatus())
						.location(url).build();

			}

			
		} catch (OAuthProblemException e) {

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
