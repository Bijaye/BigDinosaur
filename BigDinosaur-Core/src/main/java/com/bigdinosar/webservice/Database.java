package com.bigdinosar.webservice;




import java.util.HashSet;
import java.util.Set;


public class Database {

	private Set<String> authCodes = new HashSet<String>();
	private Set<String> tokens = new HashSet<String>();
	private Set<String> refreshtoken = new HashSet<String>();
	private Set<String> passwords = new HashSet<String>();
	private Set<String> usernames = new HashSet<String>();
	private Set<String> signature = new HashSet<String>();

	public void addAuthCode(String authCode) {
		authCodes.add(authCode);
	}

	public boolean isValidAuthCode(String authCode) {
		return authCodes.contains(authCode);
	}
	public boolean isValidPassWord(String password) {
		return passwords.contains(password);
	}
	public boolean isValidUsername(String username) {
		return usernames.contains(username);
	}

	public void addusername(String username) {
		usernames.add(username);
	}

	public void addpasswords(String password) {
		passwords.add(password);
	}

	public void addToken(String token) {
		tokens.add(token);
	}
	public void addRefreshToken(String refreshtok) {
		refreshtoken.add(refreshtok);
	}
	public void addsignature(String signatur) {
		signature.add(signatur);
	}

	public boolean isValidToken(String token) {
		return tokens.contains(token);
	}
}
