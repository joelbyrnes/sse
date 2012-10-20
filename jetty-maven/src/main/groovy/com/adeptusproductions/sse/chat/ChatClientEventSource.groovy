package com.adeptusproductions.sse.chat

import org.eclipse.jetty.servlets.EventSource
import org.eclipse.jetty.servlets.EventSource.Emitter

class ChatClientEventSource implements EventSource {
    private Emitter emitter;

    Channel channel = Channel.getInstance()
    String name

    public ChatClientEventSource(String name) {
        this.name = name;
    }

    @Override
    public void onOpen(Emitter emitter) throws IOException {
        println "Connection opened by user ${name}."
        this.emitter = emitter

        channel.addClient(name, this)
    }

    public void emitEvent(String dataToSend) throws IOException {
        println "[${name}] Sending: " + dataToSend
        this.emitter.data("${dataToSend}\n")
    }

    @Override
    public void onClose() {
        println "Connection closed."
        channel.left(name)
    }
}
