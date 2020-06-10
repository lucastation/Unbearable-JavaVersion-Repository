package entities;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

import base.Handler;
import graphics.Assets;

public class Items {

	//Handler
	
	public static Items[] items=new Items[256];
	public static Items beer=new Items(Assets.beer,"Beer",10);
	
	
	
	//Class
	
	public static final int ITEMWIDTH = 32, ITEMHEIGHT = 32, PICKED_UP = -1;
	protected Handler handler;
	protected BufferedImage texture;
	protected String name;
	protected final int id;

	protected int x, y, count;

	public Items(BufferedImage texture, String name, int id) {

		this.texture = texture;
		this.name = name;
		this.id = id;
		count = 1;

	}

	public void tick() {

	}

	public void render(Graphics g, int x, int y) {

		if (handler == null)
			return;
		render(g, (int) (x - handler.getGameCamera().getxOffset()), (int) (y - handler.getGameCamera().getyOffset()));
	}

	public Items createNew(int x,int y) {
		Items i=new Items(texture,name,id);
		i.setPosition(x, y);
		return i;
	}
	
	public void setPosition(int x, int y) {
		this.x = x;
		this.y = y;
	}

	// GETTERS AND SETTER

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public BufferedImage getTexture() {
		return texture;
	}

	public void setTexture(BufferedImage texture) {
		this.texture = texture;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public int getId() {
		return id;
	}

	public void render(Graphics g) {
		g.drawImage(texture, x, y, ITEMWIDTH, ITEMHEIGHT, null);
	}

}
