package com.adeptusproductions.sse.chat

class Channel {
    List<ChatClientEventSource> clients = []
    int clientIdCounter = 0;

    // TODO client should have a name, clients should be a map.
    void addClient(ChatClientEventSource chatClientEventSource) {
        clients.add(chatClientEventSource)
        sendToAll("user has joined the channel")
    }

    void sendToAll(String s) {
        // TODO send unique message ID and client name (and channel name?)
        clients.each { ChatClientEventSource client -> client.emitEvent(s) }
    }

    // TODO replace this lame singleton with dep injection
    private static final INSTANCE = new Channel()
    static getInstance() { return INSTANCE }

    void message(String message) {
        sendToAll(message)
    }
}
