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

import java.util.List;

/**
 * Interface defining the operations for working with Auth0 users.
 * 
 */
public interface UserOperations {

	/**
	 * Retrieves the user's Auth0 profile details.
	 * 
	 * @return the user's Auth0 profile
	 */
	Auth0UserProfile getUserProfile();

}

