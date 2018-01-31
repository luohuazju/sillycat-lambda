package com.sillycat.lambda.handler;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.sillycat.lambda.model.Widget;
import com.sillycat.lambda.model.WidgetRequest;

public class EchoWidgetHandler implements RequestHandler<WidgetRequest, Widget>
{

  @Override
  public Widget handleRequest( WidgetRequest widgetRequest, Context context )
  {
    return new Widget( widgetRequest.getId(), "My Widget " + widgetRequest.getId() );
  }

}
