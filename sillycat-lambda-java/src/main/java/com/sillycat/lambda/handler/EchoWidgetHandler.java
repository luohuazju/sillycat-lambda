package com.sillycat.lambda.handler;

import org.apache.log4j.Logger;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.sillycat.lambda.model.Widget;
import com.sillycat.lambda.model.WidgetRequest;

public class EchoWidgetHandler implements RequestHandler<WidgetRequest, Widget> {
	
	private static final Logger LOG = Logger.getLogger(EchoWidgetHandler.class);

	public Widget handleRequest(WidgetRequest request, Context context) {
		LOG.info("received: " + request);
		Widget response = new Widget(request.getId(), "My Widget 3 " + request.getId());
		return response;
	}

}
