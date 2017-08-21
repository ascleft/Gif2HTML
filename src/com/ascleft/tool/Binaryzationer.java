package com.ascleft.tool;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class Binaryzationer {

	public static BufferedImage DoBinaryzationer(BufferedImage bi, int Threshold) {
		int h = bi.getHeight();
		int w = bi.getWidth();
		int[][] gray = new int[w][h];
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				gray[x][y] = getGray(bi.getRGB(x, y));
			}
		}

		BufferedImage nbi = new BufferedImage(w, h, 12);
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				if (getAverageColor(gray, x, y, w, h) > Threshold) {
					int max = new Color(255, 255, 255).getRGB();
					nbi.setRGB(x, y, max);
				} else {
					int min = new Color(0, 0, 0).getRGB();
					nbi.setRGB(x, y, min);
				}
			}
		}

		return nbi;
	}

	public static int getGray(int rgb) {
		String str = Integer.toHexString(rgb);
		int r = Integer.parseInt(str.substring(2, 4), 16);
		int g = Integer.parseInt(str.substring(4, 6), 16);
		int b = Integer.parseInt(str.substring(6, 8), 16);

		Color c = new Color(rgb);
		r = c.getRed();
		g = c.getGreen();
		b = c.getBlue();
		int top = (r + g + b) / 3;
		return top;
	}

	public static int getAverageColor(int[][] gray, int x, int y, int w, int h) {
		int rs = gray[x][y] + (x == 0 ? 255 : gray[(x - 1)][y])
				+ ((x == 0) || (y == 0) ? 255 : gray[(x - 1)][(y - 1)])
				+ ((x == 0) || (y == h - 1) ? 255 : gray[(x - 1)][(y + 1)])
				+ (y == 0 ? 255 : gray[x][(y - 1)])
				+ (y == h - 1 ? 255 : gray[x][(y + 1)])
				+ (x == w - 1 ? 255 : gray[(x + 1)][y])
				+ ((x == w - 1) || (y == 0) ? 255 : gray[(x + 1)][(y - 1)])
				+ ((x == w - 1) || (y == h - 1) ? 255 : gray[(x + 1)][(y + 1)]);
		return rs / 9;
	}
}