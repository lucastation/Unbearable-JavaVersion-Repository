package worlds;

import java.awt.Graphics;

import base.Game;
import tile.Tile;
import utils.Utils;

public class World {

	private Game game;
	private int width, height;
	private int spawnX, spawnY;
	private int[][] tiles;

	public World(Game game, String path) {
		this.game = game;
		loadWorld(path);
	}

	public void tick() {

	}

	public void render(Graphics g) {
		int xStart = (int) Math.max(0, game.getGameCamera().getxOffset() / Tile.TILEWIDTH);
		int xEnd = (int) Math.min(width, (game.getGameCamera().getxOffset()+game.getWidth())/Tile.TILEWIDTH+1);
		int yStart = (int) Math.max(0, game.getGameCamera().getyOffset()/Tile.TILEHEIGHT);
		int yEnd = (int) Math.min(height, (game.getGameCamera().getyOffset()+game.getHeight())/Tile.TILEHEIGHT+1);

		for (int y = yStart; y < yEnd; y++)
			for (int x = xStart; x < xEnd; x++) {
				getTile(x, y).render(g, (int) (x * Tile.TILEWIDTH - game.getGameCamera().getxOffset()),
						(int) (y * Tile.TILEHEIGHT - game.getGameCamera().getyOffset()));
			}
	}

	public Tile getTile(int x, int y) {
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
}
