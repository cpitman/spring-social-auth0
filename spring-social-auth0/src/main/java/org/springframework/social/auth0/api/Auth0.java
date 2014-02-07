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
package org.springframework.social.auth0.api;

import org.springframework.social.ApiBinding;
import org.springframework.social.auth0.api.impl.Auth0Template;
import org.springframework.web.client.RestOperations;

/**
 * Interface specifying a basic set of operations for interacting with Auth0.
 * Implemented by {@link Auth0Template}.
 * 
 * Many of the methods contained in this interface require OAuth authentication
 * with Auth0. When a method's description speaks of the "current user", it is
 * referring to the user for whom the access token has been issued.
 *
 */
public interface Auth0 extends ApiBinding {
	
	/**
	 * Returns the portion of the Auth0 API containing the user operations.
	 * 
	 * @return user operations
	 */
	UserOperations userOperations();

	/**
	 * Returns the underlying {@link RestOperations} object allowing for consumption of Auth0 endpoints that may not be otherwise covered by the API binding.
	 * The RestOperations object returned is configured to include an OAuth "Authorization" header on all requests.
	 */
	RestOperations restOperations();

}

