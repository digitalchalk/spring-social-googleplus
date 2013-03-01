package com.digitalchalk.social.googleplus;

import java.util.logging.*;

import org.springframework.social.connect.*;

public class GooglePlusApiAdapter implements ApiAdapter<GooglePlus> {

	private static final Logger logger = Logger.getGlobal();
	
	@Override
	public boolean test(GooglePlus api) {
		return true;
	}

	@Override
	public void setConnectionValues(GooglePlus api, ConnectionValues values) {
		logger.info("GooglePlus setConnectionValues");
		GoogleUserProfile profile = api.getGoogleUserProfile();
		values.setProviderUserId(profile.getId());
		values.setImageUrl(profile.getPictureUrl());
		values.setDisplayName(profile.getName());
		values.setProfileUrl(profile.getProfileLink());
	}

	@Override
	public UserProfile fetchUserProfile(GooglePlus api) {
		
		
		UserProfileBuilder builder = new UserProfileBuilder();
		return UserProfile.EMPTY;
		
	}

	@Override
	public void updateStatus(GooglePlus api, String message) {
		// TODO Auto-generated method stub

	}

}
