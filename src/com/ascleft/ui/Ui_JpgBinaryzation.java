package com.ascleft.ui;

import java.util.Scanner;

import com.ascleft.core.JpgBinaryzationCore;

public class Ui_JpgBinaryzation {
	Scanner scanner;

	public String show() {
		System.out.println("");
		System.out.println("step1--->输入源文件名并回车");
		scanner = new Scanner(System.in);
		String old_name = scanner.next();
		System.out.println("step2--->自定义文件名并回车");
		scanner = new Scanner(System.in);
		String new_name = scanner.next();

		JpgBinaryzationCore core = new JpgBinaryzationCore();

		core.init(old_name, new_name);
		core.read();
		core.zoom();
		core.change();
		core.write();

		return "二值化-->运行结束";
	}
}