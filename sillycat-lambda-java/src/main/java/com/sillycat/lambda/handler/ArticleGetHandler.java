package com.sillycat.lambda.handler;

import java.util.HashMap;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayV2HTTPResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sillycat.lambda.model.Article;
import com.sillycat.lambda.service.ArticleService;

public class ArticleGetHandler implements RequestHandler<APIGatewayV2HTTPEvent, APIGatewayV2HTTPResponse> {

	private ArticleService articleService = new ArticleService();
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Override
	public APIGatewayV2HTTPResponse handleRequest(APIGatewayV2HTTPEvent event, Context context) {
		LambdaLogger logger = context.getLogger();
		logger.log("event: " + gson.toJson(event));
		logger.log("path: " + event.getRawPath());
		logger.log("pathParameters: " + event.getPathParameters());
		String id = event.getPathParameters().get("id");
		logger.log("id: " + id);
		Article item = articleService.get(id);

		APIGatewayV2HTTPResponse response = new APIGatewayV2HTTPResponse();
		response.setIsBase64Encoded(false);
		response.setStatusCode(200);
		HashMap<String, String> headers = new HashMap<String, String>();
		headers.put("X-Powered-By", "AWS Lambda & Serverless");
		headers.put("Content-Type", "application/json");
		response.setHeaders(headers);
		response.setBody(gson.toJson(item));
		return response;
	}

}
