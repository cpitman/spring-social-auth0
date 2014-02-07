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

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.auth0.api.Auth0;
import org.springframework.social.auth0.api.Auth0UserProfile;
import org.springframework.social.auth0.api.UserOperations;

public class Auth0AdapterTest {

	private Auth0Adapter apiAdapter = new Auth0Adapter();
	
	private Auth0 auth0 = Mockito.mock(Auth0.class);
	
	@Test
	public void fetchProfile() {
		UserOperations userOperations = Mockito.mock(UserOperations.class);
		when(auth0.userOperations()).thenReturn(userOperations);
		when(userOperations.getUserProfile()).thenReturn(new Auth0UserProfile("habuma", "Craig Walls", "Craig", "Walls", "cwalls@vmware.com", "http://awesome/image.jpg"));
		UserProfile profile = apiAdapter.fetchUserProfile(auth0);
		assertEquals("Craig Walls", profile.getName());
		assertEquals("Craig", profile.getFirstName());
		assertEquals("Walls", profile.getLastName());
		assertEquals("cwalls@vmware.com", profile.getEmail());
		assertEquals("habuma", profile.getUsername());
	}

}
