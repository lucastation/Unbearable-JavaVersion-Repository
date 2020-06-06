package states;

import java.awt.Graphics;

import entities.Player;
import graphics.Assets;

public class GameState implements State{

	private Player player;
	
	public GameState() {
		player=new Player(100,100);
	}
	
	public void tick() {
		player.tick();
	}

	public void render(Graphics g) {
		g.drawImage(Assets.grass, 10, 10, null);
		player.render(g);
	}
	
	

}
