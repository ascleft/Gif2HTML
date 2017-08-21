package com.ascleft.ui;

import java.util.Scanner;

public class ControlPanel {
	public static int choose_num;
	public static int pic_old_num;
	public static String pic_old_name;
	public static String pic_new_name;

	static Scanner scanner;

	public static void main(String[] args) {
		while (choose_num != 5) {
			System.out.println(" ----------------------------");
			System.out.println("|          Smurfs            |");
			System.out.println("|----------------------------|");
			System.out.println("| 1.Gif to html.             |");
			System.out.println("| 2.Jpg to html.             |");
			System.out.println("| 3.Jpg binaryzation.        |");
			System.out.println("| 4.Exit.                    |");
			System.out.println(" ----------------------------");

			scanner = new Scanner(System.in);
			choose_num = Integer.parseInt(scanner.next());

			switch (choose_num) {

			case 1:
				System.out.println("Choice ---> 1.Gif to html");
				Ui_GifHtml gifHtml = new Ui_GifHtml();
				System.out.println(gifHtml.show());
				break;
			case 2:
				System.out.println("Choice ---> 2.Jpg to html.");
				Ui_JpgHtml jpgHtml = new Ui_JpgHtml();
				System.out.println(jpgHtml.show());
				break;
			case 3:
				System.out.println("Choice ---> 3.Jpg binaryzation.");
				Ui_JpgBinaryzation jpgBinaryzation = new Ui_JpgBinaryzation();
				System.out.println(jpgBinaryzation.show());
				break;
			case 4:
				System.out.println("Choice ---> 4.Exit. ");
				break;
			default:
				System.out.println("Error ---> Input error!");
			}
		}
	}
}