package com.bigdinosar.security.extend;

import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.ext.dynamicreg.server.request.JSONHttpServletRequestWrapper;
import org.apache.oltu.oauth2.ext.dynamicreg.server.request.OAuthServerRegistrationRequest;

public class ExtendOAuthServerRegistrationRequest extends OAuthServerRegistrationRequest{

	public ExtendOAuthServerRegistrationRequest(
			JSONHttpServletRequestWrapper request) throws OAuthSystemException,
			OAuthProblemException {
		super(request);
	}
	public String getClientId() {
		return getParam("clientId");
	}

	

	public String getClientSecret() {
		return getParam("clientSecret");
	}

	
	public String getRedirectUri() {
		return getParam("redirectUri");
	}

	

	public String getAuthzEndpoint() {
		return getParam("authzEndpoint");
	}

	

	public String getTokenEndpoint() {
		return getParam("tokenEndpoint");
	}

	

	public String getAuthzCode() {
		return getParam("authzCode");
	}

	

	public String getErrorMessage() {
		return getParam("errorMessage");
	}

	

	public String getAccessToken() {
		return getParam("accessToken");
	}

	

	public String getExpiresIn() {
		return getParam("expiresIn");
	}

	

	

	public String getRefreshToken() {
		return getParam("refreshToken");
	}

	

	public String getResourceUrl() {
		return getParam("resourceUrl");
	}

	

	public String getResource() {
		return getParam("resource");
	}

	
	public String getScope() {
		return getParam("scope");
	}

	

	public String getState() {
		return getParam("state");
	}

	

	public String getApplication() {
		return getParam("application");
	}

	

	public String getRequestType() {
		return getParam("requestType");
	}

	

	public String getRequestMethod() {
		return getParam("requestMethod");
	}

	

	public String getIdToken() {
		return getParam("idToken");
	}

	

	public String getHeader() {
		return getParam("header");
	}

	

	public String getClaimsSet() {
		return getParam("claimsSet");
	}

	

	public String getJwt() {
		return getParam("jwt");
	}

	

	public String isIdTokenValid() {
		return getParam("idTokenValid");
	}

	

	public String getPassword() {
		return getParam("password");
	}

	

	public String getUsername() {
		return getParam("username");
	}

	

	public String getUserrole() {
		return getParam("userrole");
	}

	

	public String getId() {
		return getParam("id");
	}

	

	public String getToken() {
		return getParam("token");
	}

	

	public String getExpires() {
		return getParam("expires");
	}

	

	public String getResourceOwnerId() {
		return getParam("resourceOwnerId");
	}

	
	public String getResponseType() {
		return getParam("responseType");
	}

	

	public String getPrincipal() {
		return getParam("principal");
	}

	

	public String getEncodedPrincipal() {
		return getParam("encodedPrincipal");
	}

	

	public String getRequestedScopes() {
		return getParam("requestedScopes");
	}

	

	public String getGrantedScopes() {
		return getParam("grantedScopes");
	}

	

	public String getAuthState() {
		return getParam("authState");
	}

	

	public String getAuthorizationCode() {
		return getParam("authorizationCode");
	}

	
	public String getSecret() {
		return getParam("secret");
	}

	

	public String getContactName() {
		return getParam("contactName");
	}

	

	public String getContactEmail() {
		return getParam("contactEmail");
	}

	

	public String getAttributes() {
		return getParam("attributes");
	}

	

	public String getThumbNailUrl() {
		return getParam("thumbNailUrl");
	}

	

	public String getRedirectUris() {
		return getParam("redirectUris");
	}

	

	public String isSkipConsent() {
		return getParam("skipConsent");
	}

	

	public String isIncludePrincipal() {
		return getParam("includePrincipal");
	}

	

	public String getExpireDuration() {
		return getParam("expireDuration");
	}

	

	public String isUseRefreshTokens() {
		return getParam("useRefreshTokens");
	}

	

	public String isAllowedImplicitGrant() {
		return getParam("allowedImplicitGrant");
	}

	

	public String isAllowedClientCredentials() {
		return getParam("allowedClientCredentials");
	}

	

	public String getName() {
		return getParam("name");
	}

	

	public String getDescription() {
		return getParam("description");
	}

	

	public String getKey() {
		return getParam("key");
	}

	

	

	

	public String getOwner() {
		return getParam("owner");
	}

	
}

	


