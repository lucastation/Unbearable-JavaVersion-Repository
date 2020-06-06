package entities;

import java.awt.Graphics;

import base.Game;
import graphics.Assets;

public class Player extends Creature {

	private Game game;
	
	public Player(Game game, float x, float y) {
		super(x, y);
		this.game=game;
	}

	public void tick() {
		
		

	}

	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) x, (int) y, null);
	}

}
