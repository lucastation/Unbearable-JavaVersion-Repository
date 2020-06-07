package graphics;

import java.awt.image.BufferedImage;

public class Assets {

	private static final int width = 128, height = 128;
	public static BufferedImage player, grass1, grass2, grass3,grass4, tree, rock;

	public static void init() {
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/mySheet.png"));

		player = sheet.crop(0, 256, width, height);
		rock = sheet.crop(0, 127, width, height);
		grass1 = sheet.crop(0, 0, width, height);
		grass2 = sheet.crop(128, 0, width, height);
		grass3 = sheet.crop(256, 0, width, height);
		grass4=sheet.crop(384, 0, width-2, height);
	}

}
