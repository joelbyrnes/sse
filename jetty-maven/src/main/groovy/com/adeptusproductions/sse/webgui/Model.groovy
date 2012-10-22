package com.adeptusproductions.sse.webgui

/**
 * Maintains the authoritative data model. If clients get out of sync, they should be able to request a full copy of this model.
 *
 * Should also be synchronised so all clients are sent events, before processing new input. No input should be taken while synchronising a client.
 *
 * The model could and probably should also be available as a REST interface so the client-side view can access it as required instead of purely as directed by events.
 */
class Model {

    View view

    Model(view) {
        this.view = view
        // simple test: constant loop of something

        def ball = new ModelObject(view)

//        ball.everySecond {
//            moveLeft(1)
//        }
    }
}
