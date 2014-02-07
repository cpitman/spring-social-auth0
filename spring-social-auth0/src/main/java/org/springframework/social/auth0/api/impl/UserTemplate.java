/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.auth0.api.impl;

import static java.util.Arrays.*;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.social.auth0.api.Auth0UserProfile;
import org.springframework.social.auth0.api.UserOperations;
import org.springframework.web.client.RestTemplate;

/**
 * <p>
 * User template implementation.
 * </p>
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class UserTemplate extends AbstractAuth0Operations implements UserOperations {

	private final RestTemplate restTemplate;
	
	public String getProfileId() {
		return getUserProfile().getUserId();
	}

	public Auth0UserProfile getUserProfile() {
		@SuppressWarnings("unchecked")
		Map<String, ?> user = restTemplate.getForObject(buildUri("userinfo"), Map.class);		
		String userId = String.valueOf(user.get("user_id"));
		String name = String.valueOf(user.get("name"));
		String familyName = String.valueOf(user.get("family_name"));
		String givenName = String.valueOf(user.get("given_name"));
		String email = user.get("email") != null ? String.valueOf(user.get("email")) : null;
		String profileImageUrl = String.valueOf(user.get("picture"));
		return new Auth0UserProfile(userId, name, givenName, familyName, email, profileImageUrl);
	}

	/**
	 * @param restTemplate
	 * @param isAuthorizedForUser
	 */
	public UserTemplate(RestTemplate restTemplate, String domain, boolean isAuthorizedForUser) {
		super(domain, isAuthorizedForUser);
		this.restTemplate = restTemplate;
	}
	
}

