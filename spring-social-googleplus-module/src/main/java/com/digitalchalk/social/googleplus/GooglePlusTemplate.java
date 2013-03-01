package com.digitalchalk.social.googleplus;

import org.springframework.http.*;
import org.springframework.social.oauth2.*;

public class GooglePlusTemplate extends AbstractOAuth2ApiBinding implements GooglePlus {

	public GooglePlusTemplate() {
		
	}
	
	public GooglePlusTemplate(String accessToken) {
		super(accessToken);
	}
	
	@Override
	public GoogleUserProfile getGoogleUserProfile() {
		ResponseEntity<GoogleUserProfile> hold = getRestTemplate().getForEntity("https://www.googleapis.com/oauth2/v1/userinfo?alt=json", GoogleUserProfile.class);
		return hold.getBody();
	}
	
}
