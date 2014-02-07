/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.auth0.api;

import java.io.Serializable;
import java.util.Date;

public class Auth0UserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	private final String name;
	private final String givenName;
	private final String familyName;
	private final String userId;
	private final String email;
	private final String profileImageUrl;

	public Auth0UserProfile(String userId, String name, String givenName, String familyName,
			String email, String profileImageUrl) {
		this.userId = userId;
		this.name = name;
		this.givenName = givenName;
		this.familyName = familyName;
		this.email = email;
		this.profileImageUrl = profileImageUrl;
	}

	public String getName() {
		return name;
	}

	public String getUserId() {
		return userId;
	}
	
	public String getGivenName() {
		return givenName;
	}
	
	public String getFamilyName() {
		return familyName;
	}
	
	public String getEmail() {
		return email;
	}
	
	public String getProfileImageUrl() {
		return profileImageUrl;
	}

}