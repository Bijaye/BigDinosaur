package com.bigdinosar.security.extend;

import org.apache.oltu.oauth2.as.issuer.OAuthIssuerImpl;
import org.apache.oltu.oauth2.as.issuer.ValueGenerator;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;

public class ExtendOAuthIssuerImpl extends OAuthIssuerImpl {
	private ValueGenerator vg;

	public ExtendOAuthIssuerImpl(ValueGenerator vg) {
		
		super(vg);
		this.vg=vg;
	}
	public String clientId() throws OAuthSystemException {
		return this.vg.generateValue();
	}
	public String clientSecret() throws OAuthSystemException {
		return this.vg.generateValue();
	}


}
