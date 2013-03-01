package com.digitalchalk.social.googleplus;

import org.springframework.social.oauth2.*;

public class GooglePlusServiceProvider extends AbstractOAuth2ServiceProvider<GooglePlus> {

	public GooglePlusServiceProvider(String clientId, String clientSecret, String authorizeUrl, String accessTokenUrl) {
		super((new OAuth2Template(clientId, clientSecret, authorizeUrl, accessTokenUrl)));
		((OAuth2Template)getOAuthOperations()).setUseParametersForClientAuthentication(true);
	}


	
	@Override
	public GooglePlus getApi(String accessToken) {
		return new GooglePlusTemplate(accessToken);
	}

}
