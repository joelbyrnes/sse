package com.adeptusproductions.sse.traceroute

import org.eclipse.jetty.servlets.EventSource

class TracerouteEventSource implements EventSource, Runnable {
    private EventSource.Emitter emitter
    String host
    static final String IPINFODB_KEY = "eae8f4ad112e1c1ab1dc1715f4e30e2464d723f441415c68cc3aa83f6a88033d"

    public TracerouteEventSource(String host) {
        this.host = host;
    }

    @Override
    public void onOpen(EventSource.Emitter emitter) throws IOException {
        this.emitter = emitter
        println "Traceroute request for ${host} created"
        run()
    }

    public void emitEvent(String dataToSend) throws IOException {
//        if (!dataToSend.endsWith("\n")) dataToSend = dataToSend + "\n"
        print "Sending: " + dataToSend
        emitter.data(dataToSend)
    }

    @Override
    public void onClose() {
        println "Connection closed (by client?)."
    }

    @Override
    public void run() {
        def ipInfo = new IPInfoDB(IPINFODB_KEY)

        println "Tracing to ${host}..."
        Traceroute.eachHop(host) {
            // send data to browser to put on map. latlong, ip/host, country, region, city, avg ping.
            println "Looking up hop ${it.ip}..."
            emitEvent(ipInfo.searchJSON(it.ip).replace("\n", "") + "\n")
        }
        
        println "Traceroute complete. (close now?)"

        // TODO how do we tell the client not to reconnect on close? maybe tell it we're done, it should disconnect?
//        emitter.close()
    }

}