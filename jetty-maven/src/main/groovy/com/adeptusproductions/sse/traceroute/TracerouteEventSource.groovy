package com.adeptusproductions.sse.traceroute

import org.eclipse.jetty.servlets.EventSource
import org.eclipse.jetty.servlets.EventSource.Emitter

class TracerouteEventSource implements EventSource, Runnable {
    private Emitter emitter
    String host

    public TracerouteEventSource(String host) {
        this.host = host;
    }

    @Override
    public void onOpen(Emitter emitter) throws IOException {
        this.emitter = emitter
        println "Traceroute request for ${host} created"
        run()
    }

    public void emitEvent(String dataToSend) throws IOException {
        print "Sending: " + dataToSend
        emitter.data(dataToSend)
    }

    @Override
    public void onClose() {
        println "Connection closed (by client?)."
    }

    @Override
    public void run() {
        // TODO make real results...
        def results = [
                "google.com",
                "microsoft.com"
        ]

        try {
            results.each { result ->
                sleepThenSend(1000, result + "\n");
            }
        } catch (IOException e) {
            println "IOException sending message. Exiting."
        }
        // TODO how do we tell the client not to reconnect on close? maybe tell it we're done, it should disconnect?
//        emitter.close();
    }

    private void sleepThenSend(int time, String message) throws IOException {
        try {
            Thread.sleep(time);
            emitEvent(message);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}