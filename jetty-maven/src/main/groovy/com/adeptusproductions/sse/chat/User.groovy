package com.adeptusproductions.sse.chat

import org.eclipse.jetty.servlets.EventSource
import org.eclipse.jetty.servlets.EventSource.Emitter

class User implements EventSource {
    private Emitter emitter
    String name, sessionId
    System system = System.getInstance()
    Channel[] channels = []

    public User(sessionId, name) {
        this.sessionId = sessionId
        this.name = name
    }

    @Override
    public void onOpen(Emitter emitter) throws IOException {
        println "Connection opened by user ${name}."
        this.emitter = emitter
    }

    private void emitEvent(String dataToSend) throws IOException {
        println "[${name}] Sending: " + dataToSend
        this.emitter.data("${dataToSend}\n")
    }

    @Override
    public void onClose() {
        println "Connection closed by ${name}, id ${sessionId}."
        system.disconnect(this)
    }

    def send(String s) {
        emitEvent(s)
    }

    def join(Channel channel) {
        channels << channel
    }
}
