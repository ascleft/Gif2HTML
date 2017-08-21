package com.ascleft.writer;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;


public class HtmlWriter {
	
	private String gifName;
	private int numFrameCount;
	private ArrayList<String[][]> al_string;
	private int[] size;

	
	public HtmlWriter(String nameIn, int numIn,ArrayList<String[][]> alIn,int[] sizeIn) {
		gifName = nameIn;
		numFrameCount = numIn;
		al_string = alIn;
		size = sizeIn;
	}
	
	public void write() {
		System.out.println("---> writing...");

		FileWriter fileWriter = null;
		BufferedWriter bufferedWriter = null;
		PrintWriter printWriter = null;
		try {
			fileWriter = new FileWriter(gifName + ".html");
			bufferedWriter = new BufferedWriter(fileWriter);
			printWriter = new PrintWriter(bufferedWriter);

			printWriter.println("<!DOCTYPE HTML PUBLIC '-//W3C//DTD HTML 4.0 Transitional//EN'>");
			printWriter.println("<HTML>");
			printWriter.println(" <HEAD>");
			printWriter.println("  <TITLE> New Document </TITLE>");
			printWriter.println("  <META NAME=\"Generator\" CONTENT=\"EditPlus\">");
			printWriter.println("  <META NAME=\"Author\" CONTENT=\"\">");
			printWriter.println("  <META NAME=\"Keywords\" CONTENT=\"\">");
			printWriter.println("  <META NAME=\"Description\" CONTENT=\"\">");
			printWriter.println(" </HEAD>");

			
			
			
			
			printWriter.println("<style type=\"text/css\">");
			printWriter.println("p.asc{font-family:Consolas,\"Times New Roman\",Georgia,Serif}");
			printWriter.println("</style>");
			
			printWriter.println("<script>");
			printWriter.println("var i=0;");
			printWriter.println("var arr = new Array();");

			for (int i = 0; i < numFrameCount; i++) {
				
				String[][] string_map = al_string.get(i);

				printWriter.print("arr[");
				printWriter.print(i);
				printWriter.print("] = \"");

				for (int y = 0; y < size[1]; y++) {
					for (int x = 0; x < size[0]; x++) {
						printWriter.print(string_map[x][y]);
					}
					printWriter.print("<br>");
				}
				printWriter.print("Finish!<br>");

				printWriter.println("\";");
			}

			printWriter.println("function changeString(){");
			printWriter.println("\tdocument.getElementById(\"asc\").innerHTML = arr[i];");
			printWriter.println("\ti++;");
			printWriter.print("\tif(i>");
			printWriter.print(numFrameCount - 1);
			printWriter.println("){");
			printWriter.println("\t\ti=0;");
			printWriter.println("\t}");
			printWriter.println("\tsetTimeout(\"changeString();\",\"100\");");
			printWriter.println("}");
			printWriter.println("</script>");
			printWriter.println(" <BODY onLoad=\"changeString();\">");
			printWriter.println(" <p id=\"asc\" class=\"asc\"></p2>");
			printWriter.println(" </BODY>");
			printWriter.println("</HTML>");
		} catch (FileNotFoundException e) {
			System.out.println("该文件不存在-" + e.getMessage());
		} catch (IOException e) {
			System.out.println("文件读取错误-" + e.getMessage());
		} finally {
			if (printWriter != null)
				printWriter.close();
		}
	}
}