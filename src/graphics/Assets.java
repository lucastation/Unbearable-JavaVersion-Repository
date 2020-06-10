package graphics;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 128, height = 128;
	public static BufferedImage player, grass1, grass2, grass3, grass4, tree, rock, beer;

	public static void init() {
		SpriteSheet sheet1 = new SpriteSheet(ImageLoader.loadImage("/textures/sheet2.png"));

		// player = sheet1.crop(0, 256, width, height);
		rock = sheet1.crop(0, 127, width, height);
		grass1 = sheet1.crop(0, 0, width, height);
		grass2 = sheet1.crop(128, 0, width, height);
		grass3 = sheet1.crop(256, 0, width, height);
		grass4 = sheet1.crop(384, 0, width - 2, height);
		beer = sheet1.crop(0, 256, width, height);

		SpriteSheet sheet2 = new SpriteSheet(ImageLoader.loadImage("/textures/bear.png"));
		player = sheet2.crop(0, 0, width, height);
	}

}
