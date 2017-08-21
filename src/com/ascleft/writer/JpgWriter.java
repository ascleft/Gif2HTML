package com.ascleft.writer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class JpgWriter {

	private String jpgName;
	private BufferedImage image;

	public JpgWriter(String nameIn, BufferedImage imageIn) {
		jpgName = nameIn;
		image = imageIn;
	}

	public void write() {
		System.out.println("---> writing...");

		try {
			ImageIO.write(image, "jpg", new File(jpgName + ".jpg"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}