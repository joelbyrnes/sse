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

      def system = System.getInstance()

      def user = new User(id, name)

      user.onConnect {
          println "connect to system"
          system.connect(user)
      }

      return user
  }

}