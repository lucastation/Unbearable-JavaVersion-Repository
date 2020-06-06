package states;

import java.awt.Graphics;

import graphics.Assets;

public class GameState implements State{

	public GameState() {
		
	}
	
	public void tick() {
		
	}

	public void render(Graphics g) {
		g.drawImage(Assets.grass, 10, 10, null);
	}
	
	

}
