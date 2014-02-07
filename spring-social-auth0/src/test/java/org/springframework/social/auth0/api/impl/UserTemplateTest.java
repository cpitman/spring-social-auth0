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

import static org.junit.Assert.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.*;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.social.auth0.api.Auth0UserProfile;

/**
 * @author Craig Walls
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public class UserTemplateTest extends AbstractAuth0ApiTest {
	
	@Test
	public void getUserProfile() throws Exception {
		mockServer.expect(requestTo("https://test.auth0.com/userinfo")).andExpect(method(GET))
				.andExpect(header("Authorization", "Bearer ACCESS_TOKEN"))
				.andRespond(withSuccess(new ClassPathResource("profile.json", getClass()), MediaType.APPLICATION_JSON));
		Auth0UserProfile profile = auth0.userOperations().getUserProfile();
		assertEquals("google-oauth2|103547991597142817347", profile.getUserId());
		assertEquals("John Foo", profile.getName());
		assertEquals("johnfoo@gmail.com", profile.getEmail());
	}

}
