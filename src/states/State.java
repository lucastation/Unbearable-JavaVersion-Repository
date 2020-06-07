package states;

import java.awt.Graphics;

import base.Game;
import base.Handler;

public abstract class State {

	protected Handler handler;

	public State(Handler handler) {
		this.handler = handler;
	}

	public abstract void tick();

	public abstract void render(Graphics g);

}
