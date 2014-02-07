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

import org.junit.Before;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

/**
 * <p>
 * Based on <code>AbstractTwitterApiTest</code>.
 * </p>
 * 
 * @author Willie Wheeler (willie.wheeler@gmail.com)
 */
public abstract class AbstractAuth0ApiTest {
	protected Auth0Template auth0;
	protected Auth0Template unauthorizedAuth0;
	protected MockRestServiceServer mockServer;
	protected HttpHeaders responseHeaders;
	
	@Before
	public void setup() {
		this.auth0 = new Auth0Template("test", "ACCESS_TOKEN");
		this.mockServer = MockRestServiceServer.createServer(auth0.getRestTemplate());
		
		this.responseHeaders = new HttpHeaders();
		responseHeaders.setContentType(MediaType.APPLICATION_JSON);
		
		this.unauthorizedAuth0 = new Auth0Template("test");
		
		// Create a mock server just to avoid hitting real Auth0 if something gets past the authorization check.
		MockRestServiceServer.createServer(unauthorizedAuth0.getRestTemplate());
	}

	protected Resource jsonResource(String filename) {
		return new ClassPathResource(filename + ".json", getClass());
	}
}
