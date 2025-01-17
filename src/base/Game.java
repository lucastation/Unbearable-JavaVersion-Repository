package base;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import com.sun.corba.se.spi.orbutil.fsm.State;

import Window.Display;
import graphics.Assets;
import graphics.GameCamera;
import graphics.ImageLoader;
import graphics.SpriteSheet;
import input.KeyManager;
import states.GameState;
import states.MenuState;
import states.StateManager;

public class Game implements Runnable {

	//Display
	private Display display;

	//Titlu si dimensiune frame
	String title;
	private int width, height;
	
	//Thread
	private Thread thread;
	private boolean running = false;

	//ImageLoader
	private BufferStrategy bs;
	private Graphics g;

	// States
	private GameState gameState;
	private MenuState menuState;

	// Input
	private KeyManager keyManager;

	// Camera
	private GameCamera gameCamera;
	
	//Handler
	private Handler handler;
	
	

	public Game(String title, int width, int height) {

		this.width = width;
		this.height = height;
		this.title = title;
		keyManager = new KeyManager();
	}

	private void init() {

		display = new Display(title, width, height);
		display.getFrame().addKeyListener(keyManager);
		Assets.init();
		
		handler=new Handler(this);
		gameCamera = new GameCamera(handler, 0, 0);

		
		gameState = new GameState(handler);
		menuState = new MenuState(handler);
		StateManager.setState(gameState);
	}

	private void tick() {

		keyManager.tick();

		if (StateManager.getState() != null) {
			StateManager.getState().tick();
		}

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

		if (StateManager.getState() != null) {
			StateManager.getState().render(g);
		}

		// end drawing

		bs.show();
		g.dispose();

	}

	public void run() {

		init();

		// game loop
		int fps = 60;
		double timePerTick = 1000000000 / fps;
		double delta = 0;
		long now;
		long lastTime = System.nanoTime();
		long timer = 0;
		int ticks = 0;

		while (running) {
			now = System.nanoTime();
			delta += (now - lastTime) / timePerTick;
			timer += now - lastTime;
			lastTime = now;

			if (delta >= 1) {
				tick();
				render();
				ticks++;
				delta--;
			}
			if (timer >= 1000000000) { // afisare Ticks and Frames
				System.out.println("Ticks and Frames: " + ticks);
				ticks = 0;
				timer = 0;
			}
		}
		// game loop end
		stop();
	}

	// ===========Geters============
	public KeyManager getKeyManager() {
		return keyManager;
	}

	public GameCamera getGameCamera() {
		return gameCamera;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
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
