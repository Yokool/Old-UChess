package com.EKEY;

import java.awt.Canvas;

import com.EKEY.Misc.DataShare;

public final class Game extends Canvas {

	private static final long serialVersionUID = -8829932882588586364L;

	private Thread gameThread = null;

	private boolean mainThreadRunning = false;
	
	private Handler handler = null;

	public Game(Handler handler) {
		DataShare.GAME = this;
		this.handler = handler;
	}
	
	public void startGame() {
		createThread();
		startThread();
	}

	
	/**
	 * The main tick method.
	 */
	public void tick() {
		
		handler.tick();
		
	}
	
	/**
	 * The main render method.
	 */
	public void render() {

		handler.render(getGraphics());
		
	}
	
	/**
	 * The method that creates a mainGameThread but doesn't start it.
	 */
	public void createThread() {

		gameThread = new Thread(new Runnable() {

			public void run() {

				long lastTime = System.nanoTime();
				double amountOfTicks = 60.0;
				double ns = 1000000000 / amountOfTicks;
				double delta = 0;
				long timer = System.currentTimeMillis();
				int frames = 0;
				while (mainThreadRunning) {
					long now = System.nanoTime();
					delta += (now - lastTime) / ns;
					lastTime = now;
					while (delta >= 1) {
						tick();
						delta--;
					}
					if (mainThreadRunning)
						render();
					frames++;

					if (System.currentTimeMillis() - timer > 1000) {
						timer += 1000;
						System.out.println("FPS: " + frames);
						frames = 0;
					}
				}
				stopThread();

			}

		});

	}

	/**
	 * A method that starts the main game thread.
	 */
	public void startThread() {

		gameThread.start();
		mainThreadRunning = true;
	}

	/**
	 * A method that stops the main game thread.
	 */
	public void stopThread() {

		try {

			mainThreadRunning = false;
			gameThread.join();

		} catch (InterruptedException e) {
			System.err.println("Failed to stop the main game thread.");
			e.printStackTrace();
		}

	}
	
	public Thread getGameThread() {
		return gameThread;
	}

	public void setGameThread(Thread gameThread) {
		this.gameThread = gameThread;
	}

}
