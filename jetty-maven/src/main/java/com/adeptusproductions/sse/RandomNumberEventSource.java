package com.adeptusproductions.sse;

import org.eclipse.jetty.servlets.EventSource;

import java.io.IOException;

class RandomNumberEventSource implements EventSource {
    private Emitter emitter;

    public void onOpen(Emitter emitter) throws IOException {
		System.out.println("Connection opened.");
        this.emitter = emitter;

        emitEvent("hallo thar!");

		RandomEmitter random = new RandomEmitter(this);
		random.run();
	}

    public void emitEvent(String dataToSend) throws IOException {
        System.out.println("Sending: " + dataToSend);
        this.emitter.data(dataToSend);
    }

    public void onClose() {
		System.out.println("Connection closed.");
	}
}