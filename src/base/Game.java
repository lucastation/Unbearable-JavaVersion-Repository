package base;

import Window.Display;

public class Game {
	
	private Display display;
	
	String title;
	public int width,height;
	


	public Game(String title, int width, int height) {
		
		this.width=width;
		this.height=height;
		this.title=title;
		
		
		display=new Display(title,width,height);
	}

}
