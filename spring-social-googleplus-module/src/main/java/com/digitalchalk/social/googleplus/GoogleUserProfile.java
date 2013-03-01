package com.digitalchalk.social.googleplus;

import org.codehaus.jackson.annotate.*;


@JsonIgnoreProperties(ignoreUnknown = true)
public class GoogleUserProfile {

	private String id;
	private String email;
	private String name;
	private String givenName;
	private String familyName;
	private String profileLink;
	private String pictureUrl;
	private String gender;
	private String birthday;
	private String locale;
	private String verifiedEmail;
	
	@JsonProperty(value="birthday")
	public String getBirthday() {
		return birthday;
	}
	
	@JsonProperty(value="email")
	public String getEmail() {
		return email;
	}
	
	@JsonProperty(value="family_name")
	public String getFamilyName() {
		return familyName;
	}
	
	@JsonProperty(value="gender")
	public String getGender() {
		return gender;
	}
	
	@JsonProperty(value="given_name")
	public String getGivenName() {
		return givenName;
	}
	
	@JsonProperty(value="id")
	public String getId() {
		return id;
	}
	
	@JsonProperty(value="locale")
	public String getLocale() {
		return locale;
	}
	
	@JsonProperty(value="name")
	public String getName() {
		return name;
	}
	
	@JsonProperty(value="picture")
	public String getPictureUrl() {
		return pictureUrl;
	}
	
	@JsonProperty(value="link")
	public String getProfileLink() {
		return profileLink;
	}

	
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setFamilyName(String familyName) {
		this.familyName = familyName;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setPictureUrl(String pictureUrl) {
		this.pictureUrl = pictureUrl;
	}
	public void setProfileLink(String profileLink) {
		this.profileLink = profileLink;
	}

	@JsonProperty(value="verified_email")
	public String getVerifiedEmail() {
		return verifiedEmail;
	}

	public void setVerifiedEmail(String verifiedEmail) {
		this.verifiedEmail = verifiedEmail;
	}

	
	
	
}
