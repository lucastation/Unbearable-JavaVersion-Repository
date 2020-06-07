package graphics;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 150, height = 150;
	public static BufferedImage player, grass1, grass2, grass3, tree;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet1.png"));

		player=sheet.crop(0,0,width,height);
		grass1=sheet.crop(0, 00, width, height);
		grass2=sheet.crop(0, 150, width, height);
		grass3=sheet.crop(0, 300, width, height);
	}

}
