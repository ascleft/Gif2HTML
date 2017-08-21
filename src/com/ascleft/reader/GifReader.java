package com.ascleft.reader;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import com.ascleft.GifAPI.GifDecoder;

public class GifReader {
	private String gifName;
	private int numFrameCount, numDelay;
	public ArrayList<BufferedImage> al_img = null;

	public GifReader(String nameIn) {
		init(nameIn);
	}

	public void init(String nameIn) {
		gifName = nameIn;
		al_img = new ArrayList<BufferedImage>();
		numFrameCount = 0;
		numDelay = 0;
	}

	public void read() {
		try {
			System.out.println("---> reading...");
			
			GifDecoder decoder = new GifDecoder();
			decoder.read(gifName + ".gif");

			numFrameCount = decoder.getFrameCount();
			numDelay = decoder.getDelay(0);// 得到延迟时间,没侦之间延时可能不同

			System.out.println("gif帧数----" + numFrameCount);
			System.out.println("gif延时----" + numDelay);

			for (int i = 0; i < numFrameCount; i++) {

				BufferedImage frame = decoder.getFrame(i);

				System.out.println(i + "/" + numFrameCount);
//				System.out.println(frame.getType());
//				System.out.println(frame.getColorModel());

				al_img.add(frame);
			}
		} catch (Exception e) {
			System.out.println("Input Failed!");
			e.printStackTrace();
		}
	}

	public ArrayList<BufferedImage> getImgArrayList() {
		return al_img;
	}

	public int getNumFrameCount() {
		return numFrameCount;
	}

	public int getNumDelay() {
		return numDelay;
	}
}