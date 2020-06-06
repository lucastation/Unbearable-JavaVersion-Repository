package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import Window.Display;
import graphics.Assets;
import graphics.ImageLoader;
import graphics.SpriteSheet;

public class Game implements Runnable {

	private Display display;

	String title;
	public int width, height;

	private Thread thread;
	private boolean running = false;

	private BufferStrategy bs;
	private Graphics g;
	

	public Game(String title, int width, int height) {

		this.width = width;
		this.height = height;
		this.title = title;

	}

	private void init() {

		display = new Display(title, width, height);
		Assets.init();
	}

	private void tick() {

	}

	private void render() {

		bs = display.getCanvas().getBufferStrategy();
		if (bs == null) {
			display.getCanvas().createBufferStrategy(3);
			return;
		}

		g = bs.getDrawGraphics();

		// clear Screen
		g.clearRect(0, 0, width, height);

		// start drawing
		
		g.setColor(Color.red);
		g.fillRect(0, 0, width, height); // background rectangle;
		g.drawImage(Assets.grass,10,10,null);
		// end drawing

		bs.show();
		g.dispose();

	}

	public void run() {

		init();

		while (running) {
			tick();
			render();
		}
		stop();
	}

	public synchronized void start() {

		if (running) // se opreste daca jocul deja ruleaza
			return;

		running = true;
		thread = new Thread(this);
		thread.start();
	}

	public synchronized void stop() {
		if (!running) // se opreste daca jocul nu ruleaza
			return;

		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			System.err.print("EROARE LA Thread STOP");
			e.printStackTrace();
		}
	}
}
