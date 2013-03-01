package com.digitalchalk.social.googleplus;

import org.springframework.social.connect.*;
import org.springframework.social.connect.support.*;
import org.springframework.social.oauth2.*;

public class GooglePlusConnectionFactory extends OAuth2ConnectionFactory<GooglePlus> {

	public GooglePlusConnectionFactory(String providerId, OAuth2ServiceProvider<GooglePlus> serviceProvider, ApiAdapter<GooglePlus> apiAdapter) {
		super(providerId, serviceProvider, apiAdapter);
	}

}
