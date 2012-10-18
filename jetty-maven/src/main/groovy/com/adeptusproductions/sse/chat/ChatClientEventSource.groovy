package com.adeptusproductions.sse.chat

import org.eclipse.jetty.servlets.EventSource
import org.eclipse.jetty.servlets.EventSource.Emitter

class ChatClientEventSource implements EventSource {
  private Emitter emitter;

  // TODO get shared instance
  Channel channel = new Channel();

  @Override
  public void onOpen(Emitter emitter) throws IOException {
    System.out.println("Connection opened.");
    this.emitter = emitter;

    channel.addClient(this)

  }

  public void emitEvent(String dataToSend) throws IOException {
    System.out.println("Sending: " + dataToSend);
    this.emitter.data(dataToSend);
  }

  @Override
  public void onClose() {
    System.out.println("Connection closed.");
  }
}
