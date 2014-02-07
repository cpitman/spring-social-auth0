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

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.Import;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.auth0.api.Auth0;
import org.springframework.social.auth0.connect.Auth0ConnectionFactory;

/**
 * Annotation to enable Auth0 in a Spring Social application.
 * Configures a {@link Auth0ConnectionFactory} bean (and a {@link ConnectionFactoryLocator} bean if one isn't already registered).
 * Also configures a request-scoped {@link Auth0} bean fetched from the current user's {@link ConnectionRepository}. 
 * @author Craig Walls
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@Import(Auth0ProviderConfigRegistrar.class)
public @interface EnableAuth0 {

	/**
	 * The applications domain as registered with Auth0
	 */
	String domain();
	
	/**
	 * The application's App ID as issued by Auth0.
	 */
	String appId();
	
	/**
	 * The application's App Secret as issued by Auth0.
	 */
	String appSecret();
	
}
