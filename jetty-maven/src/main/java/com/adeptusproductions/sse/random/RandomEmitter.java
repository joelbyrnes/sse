package com.adeptusproductions.sse.random;

import java.io.IOException;
import java.util.Random;

/* originally based on http://blog.frankel.ch/simplest-push (which was wrong) */

/* see also
http://html5doctor.com/server-sent-events/
http://today.java.net/article/2010/03/31/html5-server-push-technologies-part-1
http://www.html5rocks.com/en/tutorials/eventsource/basics/
http://www.w3.org/TR/eventsource/

 */

public class RandomEmitter implements Runnable {
	private RandomNumberEventSource randomNumberEventSource;
  Random random = new Random();

	public RandomEmitter(RandomNumberEventSource randomNumberEventSource) {
		this.randomNumberEventSource = randomNumberEventSource;
	}

	@Override
	public void run() {
    while(true) {
      try {
        sleepThenSend(1000, String.valueOf(random.nextInt(100) + 1));
      } catch (IOException e) {
        System.out.println("IOException sending message. Exiting.");
        break;
      }
    }
	}

	private void sleepThenSend(int time, String message) throws IOException {
		try {
			Thread.sleep(time);
			randomNumberEventSource.emitEvent(message);
		} catch (InterruptedException e) {
			e.printStackTrace();
    }
	}

}
