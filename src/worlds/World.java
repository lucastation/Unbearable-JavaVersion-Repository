package worlds;

import java.awt.Graphics;

import base.Game;
import base.Handler;
import entities.Beer;
import entities.EntityManager;
import entities.Player;
import tile.Tile;
import utils.Utils;

public class World {

	private Handler handler;
	private int width, height;
	private int spawnX=5, spawnY=5;
	private int[][] tiles;
	// Entities
	private EntityManager entityManager;

	public World(Handler handler, String path) {
		this.handler = handler;
		
		entityManager = new EntityManager(handler, new Player(handler, 100, 100));
		
		
		//Beers
		entityManager.addEntity(new Beer(handler,100,250));
		
		
		loadWorld(path);
	
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void tick() {
		
		entityManager.tick();

	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width,
				(handler.getGameCamera().getxOffset() + handler.getWidth()) / Tile.TILEWIDTH + 1);
		int yStart = (int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height,
				(handler.getGameCamera().getyOffset() + handler.getHeight()) / Tile.TILEHEIGHT + 1);

		for (int y = yStart; y < yEnd; y++)
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - handler.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - handler.getGameCamera().getyOffset()));
			}
		//Entities
		entityManager.render(g);
		
	}

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grass1Tile;

		Tile t = Tile.tiles[tiles[x][y]];
		if (t == null)
			return Tile.grass1Tile;
		return t;
	}

	private void loadWorld(String path) {
		String file = Utils.loadFileAString(path);
		String[] tokens = file.split("\\s+");

		// World dimension
		width = Utils.parseInt(tokens[0]);
		height = Utils.parseInt(tokens[1]);
		// Player spawn
		spawnX = Utils.parseInt(tokens[2]);
		spawnY = Utils.parseInt(tokens[3]);
		// World code
		tiles = new int[width][height];
		for (int y = 1; y < height; y++)
			for (int x = 1; x < width; x++) {
				tiles[x][y] = Utils.parseInt(tokens[(x + y * width) + 4]);
			}

	}

	// Getters
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;

	}
}
