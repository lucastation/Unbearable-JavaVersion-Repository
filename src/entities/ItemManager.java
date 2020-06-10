package entities;

import java.awt.Graphics;
import java.util.ArrayList;

import base.Handler;

public class ItemManager {
	
	private Handler handler;
	private ArrayList<Items> items;
	
	public ItemManager(Handler handler) {
		this.handler=handler;
	}
	
	public void tick() {
		
		
		
		
	}
	
	public void render(Graphics g) {
		for(Items i:items) {
			i.render(g);
		}
	}
	
	public void addItem(Items i) {
		items.add(i);
	}

	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	public ArrayList<Items> getItems() {
		return items;
	}

	public void setItems(ArrayList<Items> items) {
		this.items = items;
	}

}
