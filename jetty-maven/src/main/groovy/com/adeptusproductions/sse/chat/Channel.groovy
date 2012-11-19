package com.adeptusproductions.sse.chat

import org.codehaus.groovy.grails.web.json.*; // package containing JSONObject, JSONArray,...

class Channel {
    // TODO replace this lame singleton with dep injection
    private static final INSTANCE = new Channel()

    static getInstance() { return INSTANCE }

    Map<String, ChatClientEventSource> clients = [:]
    int eventId = 0;

    void addClient(String name, ChatClientEventSource chatClientEventSource) {
        clients.put(name, chatClientEventSource)
        sendToAll("Channel", "User ${name} has joined the channel. Users: ${clients.size()}")
    }

    void sendToAll(name, String message) {
        println "Channel sendToAll: " + message
        // TODO use an easier JSON converter library like grails.converters.JSON
        def sw = new StringWriter()
        new JSONWriter(sw).object().key("eventId").value(eventId++)
                .key("user").value(name)
                .key("message").value(message).endObject()
        clients.values().each { ChatClientEventSource client -> client.emitEvent(sw.toString()) }
    }

    void message(user, String message) {
        sendToAll(user, message)
    }

    def left(String name) {
        clients.remove(name)
        sendToAll("Channel", "User ${name} has left the channel. Users: ${clients.size()}")
    }
}
