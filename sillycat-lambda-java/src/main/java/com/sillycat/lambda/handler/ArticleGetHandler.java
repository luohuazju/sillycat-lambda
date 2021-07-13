package com.sillycat.lambda.handler;

import java.util.HashMap;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.sillycat.lambda.model.Article;
import com.sillycat.lambda.service.ArticleService;

public class ArticleGetHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

	private ArticleService articleService = new ArticleService();
	private Gson gson = new GsonBuilder().setPrettyPrinting().create();

	@Override
	public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent event, Context context) {
		LambdaLogger logger = context.getLogger();
		logger.log("event: " + gson.toJson(event));
		logger.log("path: " + event.getPath());
		logger.log("pathParameters: " + event.getPathParameters());
		String id = event.getPathParameters().get("id");
		logger.log("id: " + id);
		Article item = articleService.get(id);

		APIGatewayProxyResponseEvent response = new APIGatewayProxyResponseEvent();
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
