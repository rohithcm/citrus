/*
 * Copyright 2006-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.consol.citrus.dsl.builder;

import com.consol.citrus.TestAction;
import com.consol.citrus.dsl.actions.DelegatingTestAction;
import com.consol.citrus.endpoint.Endpoint;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;

/**
 * Action executes docker commands.
 * 
 * @author Christoph Deppisch
 * @since 2.4
 */
public class HttpClientActionBuilder extends AbstractTestActionBuilder<DelegatingTestAction<TestAction>> {

	/** Spring application context */
	private ApplicationContext applicationContext;

	/** Target http client instance */
	private final Endpoint httpClient;

	/**
	 * Default constructor.
	 */
	public HttpClientActionBuilder(DelegatingTestAction<TestAction> action, Endpoint httpClient) {
		super(action);
		this.httpClient = httpClient;
	}

	/**
	 * Generic response builder for expecting response messages on client.
	 * @return
	 */
	public HttpClientResponseActionBuilder response() {
		HttpClientResponseActionBuilder httpClientResponseActionBuilder = new HttpClientResponseActionBuilder(action, httpClient)
				.withApplicationContext(applicationContext);
		return httpClientResponseActionBuilder;
	}

	/**
	 * Generic response builder for expecting response messages on client with response status code.
	 * @return
	 */
	public HttpClientResponseActionBuilder response(HttpStatus status) {
		HttpClientResponseActionBuilder httpClientResponseActionBuilder = new HttpClientResponseActionBuilder(action, httpClient)
				.withApplicationContext(applicationContext)
				.status(status);
		return httpClientResponseActionBuilder;
	}

	/**
	 * Sends Http GET request as client to server.
	 */
	public HttpClientRequestActionBuilder get() {
		return request(HttpMethod.GET, null);
	}

	/**
	 * Sends Http GET request as client to server.
	 */
	public HttpClientRequestActionBuilder get(String path) {
		return request(HttpMethod.GET, path);
	}

	/**
	 * Sends Http POST request as client to server.
	 */
	public HttpClientRequestActionBuilder post() {
		return request(HttpMethod.POST, null);
	}

	/**
	 * Sends Http POST request as client to server.
	 */
	public HttpClientRequestActionBuilder post(String path) {
		return request(HttpMethod.POST, path);
	}

	/**
	 * Sends Http PUT request as client to server.
	 */
	public HttpClientRequestActionBuilder put() {
		return request(HttpMethod.PUT, null);
	}

	/**
	 * Sends Http PUT request as client to server.
	 */
	public HttpClientRequestActionBuilder put(String path) {
		return request(HttpMethod.PUT, path);
	}

	/**
	 * Sends Http DELETE request as client to server.
	 */
	public HttpClientRequestActionBuilder delete() {
		return request(HttpMethod.DELETE, null);
	}

	/**
	 * Sends Http DELETE request as client to server.
	 */
	public HttpClientRequestActionBuilder delete(String path) {
		return request(HttpMethod.DELETE, path);
	}

	/**
	 * Sends Http HEAD request as client to server.
	 */
	public HttpClientRequestActionBuilder head() {
		return request(HttpMethod.HEAD, null);
	}

	/**
	 * Sends Http HEAD request as client to server.
	 */
	public HttpClientRequestActionBuilder head(String path) {
		return request(HttpMethod.HEAD, path);
	}

	/**
	 * Sends Http OPTIONS request as client to server.
	 */
	public HttpClientRequestActionBuilder options() {
		return request(HttpMethod.OPTIONS, null);
	}

	/**
	 * Sends Http OPTIONS request as client to server.
	 */
	public HttpClientRequestActionBuilder options(String path) {
		return request(HttpMethod.OPTIONS, path);
	}

	/**
	 * Sends Http TRACE request as client to server.
	 */
	public HttpClientRequestActionBuilder trace() {
		return request(HttpMethod.TRACE, null);
	}

	/**
	 * Sends Http TRACE request as client to server.
	 */
	public HttpClientRequestActionBuilder trace(String path) {
		return request(HttpMethod.TRACE, path);
	}

	/**
	 * Sends Http PATCH request as client to server.
	 */
	public HttpClientRequestActionBuilder patch() {
		return request(HttpMethod.PATCH, null);
	}

	/**
	 * Sends Http PATCH request as client to server.
	 */
	public HttpClientRequestActionBuilder patch(String path) {
		return request(HttpMethod.PATCH, path);
	}

	/**
	 * Generic request builder with request method and path.
	 * @param method
	 * @param path
	 * @return
	 */
	private HttpClientRequestActionBuilder request(HttpMethod method, String path) {
		HttpClientRequestActionBuilder httpClientRequestActionBuilder = new HttpClientRequestActionBuilder(action, httpClient)
				.withApplicationContext(applicationContext)
				.method(method);

		if (StringUtils.hasText(path)) {
			httpClientRequestActionBuilder.path(path);
		}

		return httpClientRequestActionBuilder;
	}

	/**
	 * Sets the Spring bean application context.
	 * @param applicationContext
	 */
	public HttpClientActionBuilder withApplicationContext(ApplicationContext applicationContext) {
		this.applicationContext = applicationContext;
		return this;
	}

}
