package com.easy.base.access.core.realm;

import org.apache.shiro.authc.HostAuthenticationToken;
import org.apache.shiro.authc.RememberMeAuthenticationToken;



public class EasyAuthenticationToken implements HostAuthenticationToken, RememberMeAuthenticationToken {
    /**
	 * 
	 */
	private static final long serialVersionUID = -7619636872945749913L;
	private final String principal;
    private String host;
    private final String password;

    

    public EasyAuthenticationToken(String principal, String password) {
	this.principal = principal;
	this.password =  password;
    }
    public EasyAuthenticationToken(String principal, String password,String host) {
    	this.principal = principal;
    	this.password =  password;
    	this.host=host;
        }

    public Object getPrincipal() {
        return principal;
    }

    public Object getCredentials() {
        return password;
    }

    public boolean isRememberMe() {
        return true;
    }

    public String getHost() {
        return host;
    }

   
 
}
