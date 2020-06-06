package states;

import java.awt.Graphics;

import base.Game;
import entities.Player;
import graphics.Assets;

public class GameState extends State {

	private Player player;

	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
	}

	public void tick() {
		player.tick();
	}

	public void render(Graphics g) {
		g.drawImage(Assets.grass, 10, 10, null);
		player.render(g);
	}

}
