package states;

import java.awt.Graphics;

import base.Game;
import base.Handler;
import entities.Beer;
import entities.Player;
import graphics.Assets;
import tile.Tile;
import worlds.World;

public class GameState extends State {

	private Player player;
	private World world;
	private Beer beer;

	public GameState(Handler handler) {
		super(handler);
		world = new World(handler, "res/worlds/world1.txt");
		handler.setWorld(world);
		//player = new Player(handler, 100, 100);
		//beer=new Beer(handler,300,300);


	}

	public void tick() {
		world.tick();
		//player.tick();
		//beer.tick();
	}

	public void render(Graphics g) {
		world.render(g);
		//player.render(g);
		//beer.render(g);

	}

}
