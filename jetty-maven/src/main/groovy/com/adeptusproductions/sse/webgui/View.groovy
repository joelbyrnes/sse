package com.adeptusproductions.sse.webgui

/**
 * The View (or ViewModel in MVVM) is really the browser. This class reads from the model, or receives events, and sends messages over EventSource to update the screen.
 * So this class really turns events in JSON, to be sent to all the clients. Then the GUI is done in HTML/JS.
 *
 * Ensuring complete, in-order events is essential in this mode, so LastEventId or some implementation should be done.
 * This also requires the server to retain events up to some limit.
 *
 * Finally, it would be useful to be able to send different event types which are handled differently.
 *
 */
class View {
    def update(ModelObject modelObject) {
        // send new object params to clients: object XX position X,Y
    }
}
