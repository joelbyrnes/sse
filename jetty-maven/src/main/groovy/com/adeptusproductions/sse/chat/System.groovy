package com.adeptusproductions.sse.chat

class System {
    // TODO replace this lame singleton with dep injection
    private static final INSTANCE = new System()
    static getInstance() { return INSTANCE }

    Map<String, User> users = [:]
    Map<String, Channel> channels = ["default": new Channel("default")]

    def connect(User user) {
        users.put(user.name, user)
    }

    void disconnect(User user) {
        user.channels.each { Channel c -> c.disconnect(user) }
    }
}
