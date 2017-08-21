package com.ascleft.reader;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JpgReader {
	private String jpgName;
	public BufferedImage imgIn = null;

	public JpgReader(String nameIn) {
		init(nameIn);
		read();
	}

	public void init(String nameIn) {
		jpgName = nameIn;
		imgIn = null;
	}

	public void read() {
		try {
			System.out.println("---> reading...");

			File file = new File(jpgName + ".jpg");
			imgIn = ImageIO.read(file);

		} catch (IOException e) {
			System.out.println("Read Failed!");
			e.printStackTrace();
		}
	}

	public BufferedImage getImg() {
		return imgIn;

	}

}