package com.adeptusproductions.sse.chat

import org.codehaus.groovy.grails.web.json.*; // package containing JSONObject, JSONArray,...

class Channel {
    String name
    List<User> users = []
    int eventId = 0;

    Channel(String name) {
        this.name = name
    }

    void join(User user) {
        users << user
        sendToAll("Channel", "User ${user.name} has joined the channel. Users: ${users.size()}")
    }

    void sendToAll(name, String message) {
        println "Channel sendToAll: " + message
        // TODO use an easier JSON converter library like grails.converters.JSON
        def sw = new StringWriter()
        new JSONWriter(sw).object().key("eventId").value(eventId++)
                .key("user").value(name)
                .key("message").value(message).endObject()
        users.each { User user -> user.send(sw.toString()) }
    }

    void message(User user, String message) {
        sendToAll(user, message)
    }

    def disconnect(User user) {
//        users >> user
        users.remove(user)
        sendToAll("Channel", "User ${user.name} has disconnected. Users: ${users.size()}")
    }
}
