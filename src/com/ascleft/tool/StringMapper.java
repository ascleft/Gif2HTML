package com.ascleft.tool;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class StringMapper {

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

	public static String[][] imgToStringMap(BufferedImage frame) {

		int h = frame.getHeight();
		int w = frame.getWidth();

		int[][] gray = new int[w][h];
		String[][] string_map = new String[w][h];

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {
				gray[x][y] = getGray(frame.getRGB(x, y));
			}
		}

		int S1 = 240;
		int S2 = 210;
		int S3 = 190;
		int S4 = 165;
		int S5 = 135;
		int S6 = 110;
		int S7 = 90;
		int S8 = 50;

		

		String X1 = "WW";
		String X2 = "BE";
		String X3 = "33";
		String X4 = "72";
		String X5 = "*1";
		String X6 = "-*";
		String X7 = ".-";
		String X8 = "&nbsp;.";
		String X9 = "&nbsp;&nbsp;";
		
		
//		String X1 = "##";
//		String X2 = "%&";
//		String X3 = "@0";
//		String X4 = "{'";
//		String X5 = "X*";
//		String X6 = "!^";
//		String X7 = "..";
//		String X8 = "&nbsp;";
//		String X9 = "&nbsp;";

		for (int y = 0; y < h; y++) {
			for (int x = 0; x < w; x++) {

				int AVC = getAverageColor(gray, x, y, w, h);
				if (AVC > S1) {
					string_map[x][y] = X9;

				} else if (((S1 > AVC ? 1 : 0) & (AVC > S2 ? 1 : 0)) != 0) {
					string_map[x][y] = X8;

				} else if (((S2 > AVC ? 1 : 0) & (AVC > S3 ? 1 : 0)) != 0) {
					string_map[x][y] = X7;

				} else if (((S3 > AVC ? 1 : 0) & (AVC > S4 ? 1 : 0)) != 0) {
					string_map[x][y] = X6;

				} else if (((S4 > AVC ? 1 : 0) & (AVC > S5 ? 1 : 0)) != 0) {
					string_map[x][y] = X5;

				} else if (((S5 > AVC ? 1 : 0) & (AVC > S6 ? 1 : 0)) != 0) {
					string_map[x][y] = X4;

				} else if (((S6 > AVC ? 1 : 0) & (AVC > S7 ? 1 : 0)) != 0) {
					string_map[x][y] = X3;

				} else if (((S7 > AVC ? 1 : 0) & (AVC > S8 ? 1 : 0)) != 0) {
					string_map[x][y] = X2;

				} else {
					string_map[x][y] = X1;
				}
			}
		}
		return string_map;
	}
}