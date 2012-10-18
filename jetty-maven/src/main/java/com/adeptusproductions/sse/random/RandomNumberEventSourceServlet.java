package com.adeptusproductions.sse.random;

import org.eclipse.jetty.servlets.EventSource;

import javax.servlet.http.HttpServletRequest;

public class RandomNumberEventSourceServlet extends org.eclipse.jetty.servlets.EventSourceServlet {
	@Override
	protected EventSource newEventSource(HttpServletRequest request) {
		return new RandomNumberEventSource();
	}

}