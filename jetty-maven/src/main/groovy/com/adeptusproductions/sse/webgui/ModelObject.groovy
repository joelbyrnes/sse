package com.adeptusproductions.sse.webgui

class ModelObject {

    View view

    ModelObject(View view) {
        this.view = view
    }

    Object everySecond(Closure closure) {
        // create timer - thread or loop or what?
    }

    def moveLeft(int distance) {
        // update position
        // send update of absolute position to view
        view.update(this)
    }
}
