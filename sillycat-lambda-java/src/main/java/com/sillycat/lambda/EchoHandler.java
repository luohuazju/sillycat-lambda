package com.sillycat.lambda;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class EchoHandler implements RequestHandler<Map<String, Object>, ApiGatewayResponse> {

	private static final Logger LOG = Logger.getLogger(EchoHandler.class);

	@Override
	public ApiGatewayResponse handleRequest(Map<String, Object> request, Context context) {
		LOG.info("received: " + request);
		Response response = new Response("My Widget 3 ");
		Map<String, String> headers = new HashMap<>();
		headers.put("X-Powered-By", "AWS Lambda & Serverless");
		headers.put("Content-Type", "application/json");
		return ApiGatewayResponse.builder().setStatusCode(200).setObjectBody(response).setHeaders(headers).build();
	}

}
