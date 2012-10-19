package com.adeptusproductions.sse

import org.eclipse.jetty.server.Server
import com.google.inject.Injector
import com.google.inject.Guice
import org.eclipse.jetty.server.DispatcherType
import org.eclipse.jetty.servlet.ServletContextHandler
import org.eclipse.jetty.servlet.ServletHolder
import org.eclipse.jetty.servlet.FilterHolder
import org.eclipse.jetty.webapp.WebAppContext

class WebAppServer {

    public static void main(String[] args) {
        Injector injector = Guice.createInjector()

        Server server = new Server(8080);

        WebAppContext webAppContext = new WebAppContext();
        webAppContext.setContextPath("/");
        webAppContext.setWar("src/main/webapp");
        server.setHandler(webAppContext);
        server.setStopAtShutdown(true);
        server.start();

        println "Jetty server started"
    }
}
