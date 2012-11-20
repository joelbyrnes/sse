package com.adeptusproductions.sse.chat;

import org.eclipse.jetty.servlets.EventSource;

import javax.servlet.http.HttpServletRequest;

public class ChatEventSourceServlet extends org.eclipse.jetty.servlets.EventSourceServlet {
  @Override
  protected EventSource newEventSource(HttpServletRequest request) {
      def name = request.getParameter("name")
      def id = request.getSession(true).getId()
      // TODO add channel param, create channel if not existing

      println "new event source request from ${name} with id ${id}"

      def user = new User(id, name)
      def system = System.getInstance()
      system.users.put(name, user)
      system.channels.get("default").join(user)

      println "returning EventSource to browser"

      return user
  }

}