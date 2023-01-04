package com.sillycat.lambda.handler;

import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class SimpleHandler implements RequestHandler<Map<String, String>, String> {

	public String handleRequest(Map<String, String> event, Context context) {
		return "Hello Carl";
	}

}
