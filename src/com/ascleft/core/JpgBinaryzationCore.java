package com.ascleft.core;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.ascleft.reader.JpgReader;
import com.ascleft.tool.Binaryzationer;
import com.ascleft.writer.JpgWriter;

public class JpgBinaryzationCore {
	public static String nameIn, nameOut;
	public BufferedImage img_in;
	public BufferedImage img_target_size;
	public String[][] img_string;

	public void init(String in, String out) {
		nameIn = in;
		nameOut = out;
		img_in = null;
		img_target_size = null;
		img_string = null;
	}

	public void read() {

		JpgReader reader = new JpgReader(nameIn);
		img_in = reader.getImg();
	}

	public void zoom() {

		// Zoomer zoomer = new Zoomer();
		// img_target_size = zoomer.zoom(img_in);
	}

	public void change() {

		img_target_size = Binaryzationer.DoBinaryzationer(img_in, 160);
	}

	public void write() {

		BufferedImage frame = img_target_size;

		ArrayList<String[][]> al = new ArrayList<String[][]>();
		al.add(img_string);

		JpgWriter jpgWriter = new JpgWriter(nameIn, frame);
		jpgWriter.write();
	}

}
