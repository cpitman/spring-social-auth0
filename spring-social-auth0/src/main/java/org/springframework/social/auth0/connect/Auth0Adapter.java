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
package org.springframework.social.auth0.connect;

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.auth0.api.Auth0;
import org.springframework.social.auth0.api.Auth0UserProfile;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Auth0 ApiAdapter implementation.
 * @author Keith Donald
 */
public class Auth0Adapter implements ApiAdapter<Auth0> {

	public boolean test(Auth0 auth0) {
		try {
			auth0.userOperations().getUserProfile();
			return true;
		} catch (HttpClientErrorException e) {
			// TODO : Beef up Auth0's error handling and trigger off of a more specific exception
			return false;
		}
	}

	public void setConnectionValues(Auth0 auth0, ConnectionValues values) {
		Auth0UserProfile profile = auth0.userOperations().getUserProfile();
		values.setProviderUserId(String.valueOf(profile.getUserId()));		
		values.setDisplayName(profile.getName());
		values.setImageUrl(profile.getProfileImageUrl());
	}

	public UserProfile fetchUserProfile(Auth0 auth0) {
		Auth0UserProfile profile = auth0.userOperations().getUserProfile();
		return new UserProfileBuilder().setName(profile.getName()).setEmail(profile.getEmail()).setUsername(profile.getUserId()).build();
	}
	
	public void updateStatus(Auth0 auth0, String message) {
		// not supported
	}
	
}
