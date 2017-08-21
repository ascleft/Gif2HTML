package com.ascleft.tool;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Zoomer {
	public Zoomer() {

	}

	public BufferedImage zoom(BufferedImage frame) {
		int widthTarget = 60;
		frame = zoomOutImage(frame, widthTarget);
		return frame;
	}

	private BufferedImage zoomOutImage(BufferedImage originalImage,
			int targetWidth) {
		int width = targetWidth;
		int height = (int) ((float) originalImage.getHeight()
				* (float) targetWidth / (float) originalImage.getWidth());
		BufferedImage newImage = new BufferedImage(width, height,
				originalImage.getType());
		Graphics g = newImage.getGraphics();
		g.drawImage(originalImage, 0, 0, width, height, null);
		g.dispose();
		return newImage;
	}
}
