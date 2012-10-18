package com.adeptusproductions.sse.chat

class Channel {
  List<ChatClientEventSource> clients = []
  int clientIdCounter = 0;

  void addClient(ChatClientEventSource chatClientEventSource) {
    clients.add(chatClientEventSource)
    sendToAll("user has joined the channel")
  }

  void sendToAll(String s) {
    clients.each { ChatClientEventSource client -> client.emitEvent(s) }
  }
}
