package states;

import java.awt.Graphics;

public interface State {

	public abstract void tick();
	public abstract void render(Graphics g);

}
