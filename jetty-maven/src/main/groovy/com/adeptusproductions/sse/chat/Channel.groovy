package com.adeptusproductions.sse.chat

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
        // TODO need some JSON de/serialization library - jersey?
        // TODO user and message needs to be escaped, and then un-escaped in JS.
        String event = "{\"eventId\":\"${eventId++}\", \"user\":\"${name}\", \"message\":\"${message}\"}"
        clients.values().each { ChatClientEventSource client -> client.emitEvent(event) }
    }

    void message(user, String message) {
        sendToAll(user, message)
    }

    def left(String name) {
        clients.remove(name)
        sendToAll("Channel", "User ${name} has left the channel. Clients: ${clients.size()}")
    }
}
