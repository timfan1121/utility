package com.timfan1121.tool;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileReader {
	public static String read(FileInputStream fis){
		BufferedReader df = new BufferedReader(new InputStreamReader(
				new DataInputStream(fis)));
		StringBuilder sb2 = new StringBuilder();
		String str;
		try {
			while ((str = df.readLine()) != null) {
				sb2.append(str + "\n");
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		return sb2.toString();
	}
}
