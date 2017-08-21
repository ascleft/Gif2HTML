package com.ascleft.ui;

import java.util.Scanner;

import com.ascleft.core.GifHtmlCore;

public class Ui_GifHtml {
	Scanner scanner;

	public String show() {
		System.out.println("");
		System.out.println("step1--->输入源文件名并回车");
		scanner = new Scanner(System.in);
		String gif_old_name = scanner.next();
		System.out.println("step2--->自定义文件名并回车");
		scanner = new Scanner(System.in);
		String gif_new_name = scanner.next();

		GifHtmlCore core = new GifHtmlCore();

		core.init(gif_old_name, gif_new_name);
		core.read();
		core.zoom();
		core.change();
		core.write();

		return "生成动画字符串-->运行结束";
	}
}