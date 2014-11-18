/**
 * 
 */
package edu.luc.comp433.client.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.client.WebClient;
import org.codehaus.jackson.jaxrs.JacksonJsonProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Bruno Correa <brunogmc at gmail>
 *
 */
public final class WebClientUtil {

	private static final Logger logger = LoggerFactory
			.getLogger(WebClientUtil.class);

	public static WebClient createDefaultGetRequest(String uri, String path) {
		return createDefaultRequest(uri, path, "GET", null);
	}

	public static WebClient createDefaultGetRequest(String uri, String path,
			Map<String, String> queryParams) {
		return createDefaultRequest(uri, path, "GET", queryParams);
	}

	public static WebClient createDefaultPutRequest(String uri, String path) {
		return createDefaultRequest(uri, path, "PUT", null);
	}

	public static WebClient createDefaultPutRequest(String uri, String path,
			Map<String, String> queryParams) {
		return createDefaultRequest(uri, path, "PUT", queryParams);
	}

	public static WebClient createDefaultPostRequest(String uri, String path) {
		return createDefaultRequest(uri, path, "POST", null);
	}

	public static WebClient createDefaultPostRequest(String uri, String path,
			Map<String, String> queryParams) {
		return createDefaultRequest(uri, path, "POST", queryParams);
	}

	public static WebClient createDefaultRequest(String uri, String path,
			String httpMethod, Map<String, String> queryParams) {
		return createRequest(uri, path, queryParams, httpMethod,
				new MediaType[] { MediaType.APPLICATION_JSON_TYPE },
				new MediaType[] { MediaType.APPLICATION_JSON_TYPE });
	}

	public static WebClient createRequest(String uri, String path,
			Map<String, String> queryParams, String httpMethod,
			MediaType[] accept, MediaType[] contentType) {

		List<Object> providers = new ArrayList<Object>();
		JacksonJsonProvider provider = new JacksonJsonProvider();
		provider.addUntouchable(Response.class);
		providers.add(provider);

		httpMethod = httpMethod.toUpperCase();
		WebClient webClient = WebClient.create(uri, providers);
		WebClient.getConfig(webClient).getOutInterceptors()
				.add(new LoggingOutInterceptor());
		WebClient.getConfig(webClient).getInInterceptors()
				.add(new LoggingInInterceptor());

		for (MediaType mT : accept)
			webClient.accept(mT);
		for (MediaType mT : contentType)
			webClient.type(mT);

		webClient.path(path);

		if (null != queryParams) {
			for (String key : queryParams.keySet()) {
				webClient.query(key, queryParams.get(key));
			}
		}

		String getRequestURI = webClient.getCurrentURI().toString();
		logger.info("Client " + httpMethod + " METHOD Request URI: "
				+ getRequestURI);
		String getRequestHeaders = webClient.getHeaders().toString();
		logger.info("Client " + httpMethod + " METHOD Request Headers: "
				+ getRequestHeaders);

		return webClient;

	}

	/**
	 * @param selectedBooks2
	 * @return
	 */
	public static <T> WebClient createQueryParam(WebClient wClient,
			String paramName, List<T> items) {
		for (T item : items)
			wClient.query(paramName, item);
		return wClient;
	}
}
