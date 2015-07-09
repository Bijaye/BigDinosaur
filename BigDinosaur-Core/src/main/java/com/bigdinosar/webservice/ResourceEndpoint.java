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

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.oltu.oauth2.as.response.OAuthASResponse;
import org.apache.oltu.oauth2.common.OAuth;
import org.apache.oltu.oauth2.common.error.OAuthError;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.OAuthResponse;
import org.apache.oltu.oauth2.common.message.types.ParameterStyle;
import org.apache.oltu.oauth2.common.utils.OAuthUtils;
import org.apache.oltu.oauth2.rs.request.OAuthAccessResourceRequest;
import org.apache.oltu.oauth2.rs.response.OAuthRSResponse;

/**
 *
 *
 *
 */
@Path("/resource")
public class ResourceEndpoint {
	
	
    private Database database=new Database();
    private String body="i am json:format";
   

    @GET
    @Produces("application/json")
    public Response get(@Context HttpServletRequest request) throws OAuthSystemException, IOException {
        try {
            // Make the OAuth Request out of this request
            OAuthAccessResourceRequest oauthRequest = new OAuthAccessResourceRequest(request, ParameterStyle.QUERY);
            // Get the access token
            String accessToken = oauthRequest.getAccessToken();

            // Validate the access token
            if (!database.isValidToken(accessToken)) {
                // Return the OAuth error message
                OAuthResponse oauthResponse = OAuthRSResponse
                        .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
                        .setRealm(Common.RESOURCE_SERVER_NAME)
                        .setError(OAuthError.ResourceResponse.INVALID_TOKEN)
                        .buildHeaderMessage();

                //return Response.status(Response.Status.UNAUTHORIZED).build();
                return Response.status(Response.Status.UNAUTHORIZED)
                        .header(OAuth.HeaderType.WWW_AUTHENTICATE,
                        oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE))
                        .build();

            }
            // Check if the token is sufficient
            if (TestContent.ACCESS_TOKEN_INSUFFICIENT.equals(accessToken)) {

                // Return the OAuth error message
                OAuthResponse oauthResponse = OAuthRSResponse
                    .errorResponse(HttpServletResponse.SC_FORBIDDEN)
                    .setRealm(TestContent.RESOURCE_SERVER_NAME)
                    .setError(OAuthError.ResourceResponse.INSUFFICIENT_SCOPE)
                    .buildHeaderMessage();

                // Return the error message
                return Response.status(Response.Status.FORBIDDEN)
                    .header(OAuth.HeaderType.WWW_AUTHENTICATE,
                        oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE))
                    .build();
            }
         
           
            String json="i am json";
            		
            OAuthResponse response = OAuthASResponse
                    .tokenResponse(HttpServletResponse.SC_OK)
                    .setAccessToken("")
                   
                    .buildJSONMessage();
                
          
            return Response.status(response.getResponseStatus()).entity(response.getBody()).build();
        } catch (OAuthProblemException e) {
            // Check if the error code has been set
            String errorCode = e.getError();
            if (OAuthUtils.isEmpty(errorCode)) {

                // Return the OAuth error message
                OAuthResponse oauthResponse = OAuthRSResponse
                        .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
                        .setRealm(Common.RESOURCE_SERVER_NAME)
                        .buildHeaderMessage();

                // If no error code then return a standard 401 Unauthorized response
                return Response.status(Response.Status.UNAUTHORIZED)
                        .header(OAuth.HeaderType.WWW_AUTHENTICATE,
                        oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE))
                        .build();
            }

            OAuthResponse oauthResponse = OAuthRSResponse
                    .errorResponse(HttpServletResponse.SC_UNAUTHORIZED)
                    .setRealm(Common.RESOURCE_SERVER_NAME)
                    .setError(e.getError())
                    .setErrorDescription(e.getDescription())
                    .setErrorUri(e.getUri())
                    .buildHeaderMessage();

            return Response.status(Response.Status.BAD_REQUEST)
                    .header(OAuth.HeaderType.WWW_AUTHENTICATE, oauthResponse.getHeader(OAuth.HeaderType.WWW_AUTHENTICATE))
                    .build();
        }
    }
//    String getTokenAsJson() throws IOException{
//        JSONObject obj=new JSONObject();
//        obj.put("name","foo");
//        obj.put("num",new Integer(100));
//        obj.put("balance",new Double(1000.21));
//        obj.put("is_vip",new Boolean(true));
//        obj.put("nickname",null);
//        StringWriter out = new StringWriter();
//        obj.writeJSONString(out);
//        String jsonText = out.toString();
//        return jsonText;
//    }
}