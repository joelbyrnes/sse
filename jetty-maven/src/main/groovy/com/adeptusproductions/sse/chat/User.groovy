package com.adeptusproductions.sse.chat

import org.eclipse.jetty.servlets.EventSource
import org.eclipse.jetty.servlets.EventSource.Emitter

class User implements EventSource {
    private Emitter emitter
    String name, sessionId
    System system = System.getInstance()
    Channel[] channels = []
    Closure connectClosure

    public User(sessionId, name) {
        this.sessionId = sessionId
        this.name = name
    }

    @Override
    public void onOpen(Emitter emitter) throws IOException {
        println "Connection opened by user ${name}."
        this.emitter = emitter
        println "call connect closure"
        connectClosure.call()
        println "done calling connect closure"
    }

    private void emitEvent(String dataToSend) throws IOException {
        println "[${name}] Sending: " + dataToSend
        try {
            this.emitter.data("${dataToSend}\n")
        } catch (Exception e) {
            e.printStackTrace()
        }
    }

    @Override
    public void onClose() {
        println "Connection closed by ${name}, id ${sessionId}."
        system.disconnect(this)
    }

    def send(String s) {
        emitEvent(s)
    }

    def onConnect(Closure closure) {
        this.connectClosure = closure
    }
}
