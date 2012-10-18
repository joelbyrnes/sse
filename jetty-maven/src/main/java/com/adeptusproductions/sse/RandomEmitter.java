package com.adeptusproductions.sse;

import java.io.IOException;

public class RandomEmitter implements Runnable {
	private RandomNumberEventSource randomNumberEventSource;

	public RandomEmitter(RandomNumberEventSource randomNumberEventSource) {
		this.randomNumberEventSource = randomNumberEventSource;
	}

	@Override
	public void run() {
        sleepThenSend(1000, "data1");
        sleepThenSend(2000, "data2");
        sleepThenSend(500, "data3");
        sleepThenSend(500, "data4");
        sleepThenSend(500, "data5");
        sleepThenSend(5000, "data6");
	}

private void sleepThenSend(int time, String message) {
	try {
		Thread.sleep(time);
		randomNumberEventSource.emitEvent(message);
	} catch (InterruptedException e) {
		e.printStackTrace();
	} catch (IOException e) {
		e.printStackTrace();
	}
}

}
