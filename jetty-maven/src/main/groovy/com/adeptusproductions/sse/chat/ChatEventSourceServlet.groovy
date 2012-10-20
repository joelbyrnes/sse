package com.adeptusproductions.sse.chat;

import org.eclipse.jetty.servlets.EventSource;

import javax.servlet.http.HttpServletRequest;

public class ChatEventSourceServlet extends org.eclipse.jetty.servlets.EventSourceServlet {
  @Override
  protected EventSource newEventSource(HttpServletRequest request) {
    String name = request.getParameter("name")

    return new ChatClientEventSource(name);
  }

}