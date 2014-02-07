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

import org.springframework.social.MissingAuthorizationException;

/**
 * <p>
 * Based on <code>AbstractTwitterOperations</code>, by Keith Donald.
 * </p>
 * 
 */
class AbstractAuth0Operations {
	private final boolean isAuthorized;
	private final String domain;
	
	public AbstractAuth0Operations(String domain, boolean isAuthorized) {
		this.domain = domain;
		this.isAuthorized = isAuthorized;
	}
	
	protected void requireAuthorization() {
		if (!isAuthorized) {
			throw new MissingAuthorizationException("auth0");
		}
	}
	
	protected String buildUri(String path) {
		return "https://" + domain + ".auth0.com/" + path;
	}
	
}

