/*
 * Copyright 2013-2012 the original author or authors.
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

import org.springframework.social.auth0.api.Auth0;
import org.springframework.social.auth0.api.UserOperations;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.OAuth2Version;
import org.springframework.web.client.RestOperations;

/**
 * <p>
 * The central class for interacting with Auth0.
 * </p>
 */
public class Auth0Template extends AbstractOAuth2ApiBinding implements Auth0 {
	private UserOperations userOperations;
	
	private final String domain;

	/**
	 * No-arg constructor to support cases in which you want to call the Auth0
	 * API without requiring authorization. This is useful for public operations,
	 * such as getting the list of watchers for a public repository.
	 */
	public Auth0Template(String domain) {
		super();
		this.domain = domain;
		initSubApis();
	}

	/**
	 * Constructs a Auth0Template with the minimal amount of information
	 * required to sign requests with an OAuth <code>Authorization</code>
	 * header.
	 * 
	 * @param accessToken
	 *            An access token granted to the application after OAuth
	 *            authentication.
	 */
	public Auth0Template(String domain, String accessToken) {
		super(accessToken);
		this.domain = domain;
		initSubApis();
	}

	@Override
	protected OAuth2Version getOAuth2Version() {
		return OAuth2Version.BEARER;
	}

	public UserOperations userOperations() { 
		return userOperations; 
	}

	public RestOperations restOperations() {
		return getRestTemplate();
	}

	// internal helpers

	private void initSubApis() {
		this.userOperations = new UserTemplate(getRestTemplate(), domain, isAuthorized());
	}

}

