package tile;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {

	// STATIC

	public static Tile[] tiles = new Tile[256];
	public static Tile rockTile = new RockTile(0);
	public static Tile grass1Tile = new Grass1Tile(1);
	public static Tile grass2Tile = new Grass2Tile(2);
	public static Tile grass3Tile = new Grass3Tile(3);
	public static Tile grass4Tile=new Grass4Tile(4);	// class

	public static final int TILEWIDTH = 128, TILEHEIGHT = 128;

	protected BufferedImage texture;
	protected final int id;

	public Tile(BufferedImage texture, int id) {
		this.texture = texture;
		this.id = id;

		tiles[id] = this;

	}

	public void tick() {

	}

	public void render(Graphics g, int x, int y) {
		g.drawImage(texture, x, y, TILEWIDTH, TILEHEIGHT, null);
	}

	public boolean isSolid() {
		return false;
	}

	public int getId() {
		return id;
	}

}
