package com.bigdinosaur.base.access.core.realm;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.credential.CredentialsMatcher;

public class EasyCredentialsMatcher implements CredentialsMatcher {

	public EasyCredentialsMatcher() {
	}

	public boolean doCredentialsMatch(AuthenticationToken token,
			AuthenticationInfo info) {

		String credential = (String) info.getCredentials();

		if (credential != null) {

			if (token instanceof EasyAuthenticationToken) {
				return true;
			} else {
				return false;
			}
		}

		else {
			return false;
		}
	}
}