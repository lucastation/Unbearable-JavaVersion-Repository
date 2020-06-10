package entities;

import java.awt.Color;
import java.awt.Graphics;

import base.Game;
import base.Handler;
import graphics.Assets;

public class Player extends Creature {

	public Player(Handler handler, float x, float y) {
		super(handler, x, y, Creature.DEFAULT_CREATURE_WIDTH, Creature.DEFAULT_CREATURE_HEIGHT);

		bounds.x = 40;
		bounds.y = 35;
		bounds.width = 45;
		bounds.height = 73;
	}

	public void tick() {
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);

	}

	private void getInput() {
		xMove = 0;
		yMove = 0;

		if (handler.getKeyManager().up)
			yMove = -speed;
		if (handler.getKeyManager().down)
			yMove = speed;
		if (handler.getKeyManager().left)
			xMove = -speed;
		if (handler.getKeyManager().right)
			xMove = speed;
	}

	public void render(Graphics g) {
		g.drawImage(Assets.player, (int) (x - handler.getGameCamera().getxOffset()),
				(int) (y - handler.getGameCamera().getyOffset()), 128, 128, null);

		g.setColor(Color.red);
		g.fillRect((int) (x + bounds.x - handler.getGameCamera().getxOffset()),
			(int)(y + bounds.y - handler.getGameCamera().getyOffset()),
				bounds.width,bounds.height);
	}

}
