package entities;

import java.awt.Graphics;

import base.Handler;
import graphics.Assets;
import tile.Tile;

public class Beer extends StaticEntity {

	public Beer(Handler handler, float x, float y) {
		super(handler, x, y, Tile.TILEWIDTH, Tile.TILEHEIGHT);

	}

	public void tick() {

	}

	public void render(Graphics g) {
		g.drawImage(Assets.beer, (int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset())	, width, height, null);
	}

}
