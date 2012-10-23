package com.adeptusproductions.sse.traceroute;


import javax.servlet.http.HttpServletRequest
import org.eclipse.jetty.servlets.EventSource

public class TracerouteEventSourceServlet extends org.eclipse.jetty.servlets.EventSourceServlet {
  @Override
  protected EventSource newEventSource(HttpServletRequest request) {
    String host = request.getParameter("host")

    return new com.adeptusproductions.sse.traceroute.TracerouteEventSource(host);
  }

}