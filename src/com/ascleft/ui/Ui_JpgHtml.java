package com.ascleft.ui;

import java.util.Scanner;

import com.ascleft.core.JpgHtmlCore;

public class Ui_JpgHtml {
	Scanner scanner;

	public String show() {
		System.out.println("");
		System.out.println("step1--->����Դ�ļ������س�");
		scanner = new Scanner(System.in);
		String old_name = scanner.next();
		System.out.println("step2--->�Զ����ļ������س�");
		scanner = new Scanner(System.in);
		String new_name = scanner.next();

		JpgHtmlCore core = new JpgHtmlCore();

		core.init(old_name, new_name);
		core.read();
		core.zoom();
		core.change();
		core.write();

		return "�����ַ���-->���н���";
	}
}