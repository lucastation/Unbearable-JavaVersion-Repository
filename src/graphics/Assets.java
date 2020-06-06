package graphics;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 32, height = 32;
	public static BufferedImage player, dirt, grass, stone, tree;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/background.png"));

		player=sheet.crop(0,0,width,height);
		grass=sheet.crop(32, 0, width, height);
	}

}
