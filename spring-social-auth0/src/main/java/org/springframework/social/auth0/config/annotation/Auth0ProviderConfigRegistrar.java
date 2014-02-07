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
package org.springframework.social.auth0.config.annotation;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.AbstractProviderConfigRegistrarSupport;
import org.springframework.social.config.xml.ApiHelper;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.auth0.api.Auth0;
import org.springframework.social.auth0.api.impl.Auth0Template;
import org.springframework.social.auth0.connect.Auth0ConnectionFactory;
import org.springframework.social.auth0.security.Auth0AuthenticationService;
import org.springframework.social.security.provider.SocialAuthenticationService;

/**
 * {@link ImportBeanDefinitionRegistrar} for configuring a {@link Auth0ConnectionFactory} bean and a request-scoped {@link Auth0} bean.
 * @author Craig Walls
 */
public class Auth0ProviderConfigRegistrar extends AbstractProviderConfigRegistrarSupport {

	public Auth0ProviderConfigRegistrar() {
		super(EnableAuth0.class, Auth0ConnectionFactory.class, Auth0ApiHelper.class);
	}
	
	@Override
	protected Class<? extends SocialAuthenticationService<?>> getAuthenticationServiceClass() {
		return Auth0AuthenticationService.class;
	}
	
	static class Auth0ApiHelper implements ApiHelper<Auth0> {
		
		private final UsersConnectionRepository usersConnectionRepository;

		private final UserIdSource userIdSource;

		private Auth0ApiHelper(UsersConnectionRepository usersConnectionRepository, UserIdSource userIdSource) {
			this.usersConnectionRepository = usersConnectionRepository;
			this.userIdSource = userIdSource;		
		}

		public Auth0 getApi() {
			if (logger.isDebugEnabled()) {
				logger.debug("Getting API binding instance for Auth0 provider");
			}
					
			Connection<Auth0> connection = usersConnectionRepository.createConnectionRepository(userIdSource.getUserId()).findPrimaryConnection(Auth0.class);
			if (logger.isDebugEnabled() && connection == null) {
				logger.debug("No current connection; Returning default Auth0Template instance.");
			}
			return connection != null ? connection.getApi() : new Auth0Template("error");
		}
		
		private final static Log logger = LogFactory.getLog(Auth0ApiHelper.class);

	}

}
