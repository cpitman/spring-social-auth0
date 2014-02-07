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
package org.springframework.social.auth0.security;

import org.springframework.social.auth0.api.Auth0;
import org.springframework.social.auth0.connect.Auth0ConnectionFactory;
import org.springframework.social.security.provider.OAuth2AuthenticationService;

public class Auth0AuthenticationService extends OAuth2AuthenticationService<Auth0> {

	public Auth0AuthenticationService(String domain, String apiKey, String appSecret) {
		super(new Auth0ConnectionFactory(domain, apiKey, appSecret));
	}

}
