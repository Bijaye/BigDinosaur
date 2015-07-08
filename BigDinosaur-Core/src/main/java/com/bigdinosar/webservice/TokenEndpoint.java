/**
 * Copyright 2010 Newcastle University
 *
 * http://research.ncl.ac.uk/smart/
 *
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. The ASF
 * licenses this file to You under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
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



@Path("/token")
public class TokenEndpoint {
	// call token end point of spring and get the value of TestContent

	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Response authorize(@Context HttpServletRequest request)
			throws OAuthSystemException, URISyntaxException, JSONException {
		try {
			OAuthTokenRequest oauthRequest = null;

			oauthRequest = new OAuthTokenRequest(request);
			OAuthResponse response = null;

			String clientid = oauthRequest.getClientId();
			String clientsecret = oauthRequest.getClientSecret();
			Client client = Client.create();

			WebResource webResource = client
					.resource(Utils.BigDinosaur_AUTHZ_TOKEN_CLIENTIDSECRET);
			MultivaluedMap<String, String> queryParams = new MultivaluedMapImpl();
			queryParams.add("param1", clientid);
			queryParams.add("param2", clientsecret);

			String s = webResource.queryParams(queryParams).get(String.class);

			JSONObject obj = new JSONObject(s);
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

			// do checking for different grant types case code
			if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(
					GrantType.AUTHORIZATION_CODE.toString())) {
				String authorizationcode = oauthRequest.getCode();
				String clientid1 = oauthRequest.getClientId();
				Client client1 = Client.create();
				WebResource webResource1 = client1
						.resource(Utils.BigDinosaur_AUTHZ_TOKEN_SPRING_CODE);
				MultivaluedMap<String, String> queryParams1 = new MultivaluedMapImpl();
				queryParams1.add("param1", authorizationcode);
				queryParams1.add("param2", clientid1);

				String s1 = webResource1.queryParams(queryParams1).get(
						String.class);

				JSONObject obj1 = new JSONObject(s1);
				boolean haserror1 = obj1.getBoolean("haserror");
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
				// checking done for user name and password
			} else if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(
					GrantType.CLIENT_CREDENTIALS.toString())) {
				{
					String username = oauthRequest.getUsername();
					String password = oauthRequest.getPassword();
					Client client1 = Client.create();
					WebResource webResource1 = client1
							.resource(Utils.BigDinosaur_AUTHZ_TOKEN_SPRING_CLIENTCRIDENTAILS);
					MultivaluedMap<String, String> queryParams2 = new MultivaluedMapImpl();
					queryParams2.add("param1", username);
					queryParams2.add("param2", password);
					String s1 = webResource1.queryParams(queryParams2).get(
							String.class);

					JSONObject obj1 = new JSONObject(s1);
					boolean haserror1 = obj1.getBoolean("haserror");
					if (haserror1) {

						OAuthResponse response2 = OAuthASResponse
								.errorResponse(
										HttpServletResponse.SC_BAD_REQUEST)
								.setError(
										OAuthError.TokenResponse.INVALID_GRANT)
								.setErrorDescription(
										"invalid client credentials")
								.buildJSONMessage();
						return Response.status(response2.getResponseStatus())
								.entity(response2.getBody()).build();
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
								.setParam(signature, signature)
								.buildJSONMessage();
						return Response.status(response1.getResponseStatus())
								.entity(response1.getBody()).build();

					}
				}
			} else if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equals(
					GrantType.REFRESH_TOKEN.toString())) {
				String refreshtoken = oauthRequest.getRefreshToken();
				String clientid1 = oauthRequest.getClientId();
				Client client1 = Client.create();
				WebResource webResource1 = client1
						.resource(Utils.BigDinosaur_AUTHZ_TOKEN_REFRESHTOKEN);
				MultivaluedMap<String, String> queryParams1 = new MultivaluedMapImpl();
				queryParams1.add("param1", refreshtoken);
				queryParams1.add("param2", clientid1);
				String s1 = webResource1.queryParams(queryParams1).get(
						String.class);

				JSONObject obj1 = new JSONObject(s1);
				boolean haserror1 = obj1.getBoolean("haserror");
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
		} catch (OAuthProblemException e) {
			OAuthResponse res = OAuthASResponse
					.errorResponse(HttpServletResponse.SC_BAD_REQUEST).error(e)
					.buildJSONMessage();
			return Response.status(res.getResponseStatus())
					.entity(res.getBody()).build();
		}
		return null;
	}
}
