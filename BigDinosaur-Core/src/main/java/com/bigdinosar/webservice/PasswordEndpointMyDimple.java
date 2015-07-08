package com.bigdinosar.webservice;

import java.net.URISyntaxException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
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

import com.bigdinosar.oltu.extend.OAuthTokenRequestExtend;
import com.bigdinosar.security.utils.PropertyUtils;
import com.google.gson.Gson;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;

/**
 * <<Description Here>>
 * 
 * @author abis
 * @version
 * @since
 */
@Path("/passwordauthzorizationdimple")
public class PasswordEndpointMyDimple {

	// public static final String BigDinosaur_AUTHZ_TOKEN_SPRINGIMPLICT_MyDIMPLE
	// ="http://localhost:8090/BigDinosaur-Resource/springimplictmydimple";
	public String Resource_Server_Url = "";

	// public static final String BigDinosaur_AUTHZ_TOKEN_SPRINGIMPLICT_MyDIMPLE
	// ="http://localhost:8090/BigDinosaur-Resource";

	/**
	 * <<Add description here>>
	 * 
	 * @param request
	 * @return
	 * @throws OAuthSystemException
	 * @throws URISyntaxException
	 * @throws JSONException
	 * @author
	 * @since ,Modified In: @version,By @author
	 */
	@POST
	@Consumes("application/x-www-form-urlencoded")
	@Produces("application/json")
	public Response authorize(@Context HttpServletRequest request)
			throws OAuthSystemException, URISyntaxException, JSONException {
		try {
			Resource_Server_Url = (String) PropertyUtils.getPropertyObject()
					.get("resourceurl");

			OAuthTokenRequestExtend oauthRequest = null;
			oauthRequest = new OAuthTokenRequestExtend(request);
			oauthRequest.getUserRoleType();
			if (oauthRequest.getParam(OAuth.OAUTH_GRANT_TYPE).equalsIgnoreCase(
					GrantType.PASSWORD.toString())) {
				String username = oauthRequest.getUsername();
				String password = oauthRequest.getPassword();
				// This is for get case
				Client client = Client.create();
				// WebResource webResource1 = client
				// .resource(Utils.BigDinosaur_AUTHZ_TOKEN_SPRINGIMPLICT_MyDIMPLE);
				// MultivaluedMap<String,String> queryParams = new
				// MultivaluedMapImpl();
				// queryParams.add("param1", username);
				// queryParams.add("param2", password);
				// String s = webResource1.queryParams(queryParams).get(
				// String.class);

				// ClientConfig config = new DefaultClientConfig();
				// Client client = Client.create(config);
				// config.getFeatures().put(
				// JSONConfiguration.FEATURE_POJO_MAPPING, Boolean.TRUE);
				//
				//
				//
				// WebResource webResource = client
				// .resource(BigDinosaur_AUTHZ_TOKEN_SPRINGIMPLICT_MyDIMPLE);

				// case for post request .
				// Case1:For case1 the request parameter has to be converted to
				// json format .SSSo it is converted to json format .when passed
				// through prehandle
				Test1 emp = new Test1();
				//
				//
				// RestTemplate restTemplate = new RestTemplate();
				emp.setName("a");
				emp.setPassword(password);
				emp.setUsername(username);
				emp.setGrant_type("password");
				emp.setUserid("null");
				// //
				// //
				// Test1 response =
				// restTemplate.postForObject(BigDinosaur_AUTHZ_TOKEN_SPRINGIMPLICT_MyDIMPLE,
				// emp, Test1.class);
				//
				// ClientResponse response =
				// webResource.accept("application/json")
				// .type("application/json").post(ClientResponse.class, emp);
				// Client client = Client.create();
				Gson gson = new Gson();
				String mapJsonStr = gson.toJson(emp);
				//
				WebResource webResource = client.resource(Resource_Server_Url);
				ClientResponse response = webResource.type(
						MediaType.APPLICATION_JSON).post(ClientResponse.class,
						mapJsonStr);
				// JSONObject jsonInput = new JSONObject()
				// .element( "grant_type", "password" )
				// .element( "username", "<<username>>" )
				// .element( "password", "<<password>>" )
				// .element( "client_id", "sugar" );

				// ClientResponse response =
				// webResource.type("application/json")
				// .post(ClientResponse.class, emp);
				// ClientResponse response =
				// webResource.post(ClientResponse.class, emp);

				// //create a form and add to this form information of a user
				// Form form = new Form();
				// form.add("username", username);
				// form.add(password, password);
				// form.add("grant_type", "password");

				// send this form to the server and get response
				// ClientResponse response =
				// service.path("springimplictmydimple").type(MediaType.APPLICATION_JSON_TYPE)
				// .post(ClientResponse.class, form);
				String s = response.getEntity(String.class);
				// System.out.println(response.getEntity(String.class));

				JSONObject obj = new JSONObject(s);
				boolean haserror1 = obj.getBoolean("error");
				// response.isHaserror()
				if (haserror1) {
					String errorMessage = obj.getString("errMsg");
					OAuthResponse response5 = OAuthASResponse
							.errorResponse(HttpServletResponse.SC_BAD_REQUEST)
							.setError(OAuthError.TokenResponse.INVALID_GRANT)
							.setErrorDescription(errorMessage)
							.buildJSONMessage();
					return Response.status(response5.getResponseStatus())
							.entity(response5.getBody()).build();

				} else {
					String accessToken = (String) obj.get("accessToken");
					String refreshToken = (String) obj.get("refreshtoken");
					Integer userId = (Integer) obj.get("userId");
					// String tokentype = (String) obj.get("tokentype");

					OAuthResponse response1 = OAuthASResponse
							.tokenResponse(HttpServletResponse.SC_OK)
							.setAccessToken(accessToken)
							.setRefreshToken(refreshToken)
							// .setTokenType(tokentype)
							.setParam("userId", userId.toString())
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

	}

}