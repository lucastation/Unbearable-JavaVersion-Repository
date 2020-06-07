package states;

import java.awt.Graphics;

import base.Game;
import entities.Player;
import graphics.Assets;
import tile.Tile;
import worlds.World;

public class GameState extends State {

	private Player player;
	private World world;

	public GameState(Game game) {
		super(game);
		player = new Player(game, 100, 100);
		world = new World(game, "res/worlds/world1.txt");

	}

	public void tick() {
		world.tick();
		player.tick();
	}

	public void render(Graphics g) {
		world.render(g);
		player.render(g);

	}

}
