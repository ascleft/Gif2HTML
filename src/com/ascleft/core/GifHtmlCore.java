package com.ascleft.core;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.ascleft.reader.GifReader;
import com.ascleft.tool.StringMapper;
import com.ascleft.tool.Zoomer;
import com.ascleft.writer.HtmlWriter;

public class GifHtmlCore {
	public static String nameIn, nameOut;
	public static int numFrameCount, numDelay;
	public ArrayList<BufferedImage> al_img_in;
	public ArrayList<BufferedImage> al_img_target_size;
	public ArrayList<String[][]> al_string;

	public void init(String in, String out) {
		nameIn = in;
		nameOut = out;
		al_img_in = null;
		al_img_target_size = new ArrayList<BufferedImage>();
		al_string = new ArrayList<String[][]>();
	}

	public void read() {

		GifReader reader = new GifReader(nameIn);
		reader.read();

		al_img_in = reader.getImgArrayList();
		numFrameCount = reader.getNumFrameCount();
		numDelay = reader.getNumDelay();
	}

	public  void zoom() {

		Zoomer zoomer = new Zoomer();
		for (BufferedImage frame : al_img_in) {
			al_img_target_size.add(zoomer.zoom(frame));
		}
	}

	public void change() {

		for (BufferedImage frame : al_img_target_size) {
			al_string.add(StringMapper.imgToStringMap(frame));
		}
	}

	public void write() {
		BufferedImage frame = al_img_target_size.get(0);
		int[] size = new int[] { frame.getWidth(), frame.getHeight() };

		HtmlWriter htmlWriter = new HtmlWriter(nameIn, numFrameCount, al_string, size);
		htmlWriter.write();

	}

}
