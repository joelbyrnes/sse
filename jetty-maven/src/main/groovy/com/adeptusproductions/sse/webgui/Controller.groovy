package com.adeptusproductions.sse.webgui

/**
 * Receives input from clients, processes as appropriate according to the Model, and sends changes/events to clients through the View.
 *
 * Maintains list of clients. Directs View to create JSON and send to all clients.
 */
class Controller {

    Model model
    View view

    Controller() {
        this.view = new View()
        this.model = new Model(view)

        // any update follows this process
//        synchronised:
//            validate and complete change with model
//            send to clients

    }

    // new client

    // close client

    // client sends event

    // events that occur within the model (eg timed events) can go through the view directly

}
