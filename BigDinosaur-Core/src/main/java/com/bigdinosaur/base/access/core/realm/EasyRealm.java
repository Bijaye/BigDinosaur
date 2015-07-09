package com.bigdinosaur.base.access.core.realm;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;



@Component
public class EasyRealm extends AuthorizingRealm {

	public EasyRealm() {
		setName("EasyRealm"); 
		setAuthenticationTokenClass(EasyAuthenticationToken.class);
		setCredentialsMatcher(new EasyCredentialsMatcher());
	}

	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken) throws AuthenticationException {
		return null;
		


	}

	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return null;

		
	}

	

}
