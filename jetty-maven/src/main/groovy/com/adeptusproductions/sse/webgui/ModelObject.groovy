package com.adeptusproductions.sse.webgui

class ModelObject {

    int id
    View view
    // more specific fields...

    ModelObject(int id, View view) {
        this.id = id
        this.view = view
    }

    void everySecond(Closure closure) {
        // create timer - thread or loop or what?
    }

    void moveLeft(int distance) {
        // update position ...
        // send update of absolute position to view
        view.update(this)
    }
}
