package com.timfan1121;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Properties;

public class Main {
	Properties pro = new Properties();

	public Main() {
		try {
			FileInputStream f = new FileInputStream(getClass().getResource(
					"/column.properties").getPath());
			System.out.println(getClass().getResource("/column.properties")
					.getPath());
			pro.load(f);

//			 model
			 new ModelGen().gen(pro.getProperty("model.column")
			 , pro.getProperty("model.tablename"),
			 pro.getProperty("model.className"));

//			 dao
			 new DaoGen().gen(pro.getProperty("model.tablename"),
			 pro.getProperty("model.className"));
			//
			//
			// controller
			FileInputStream importF = new FileInputStream(getClass()
					.getResource("/springMVC.txt").getPath());
			BufferedReader df = new BufferedReader(new InputStreamReader(
					new DataInputStream(importF)));
			String str;
			StringBuilder sb2 = new StringBuilder();
			while ((str = df.readLine()) != null) {
				sb2.append(str + "\n");
			}
			new ControllerGen().gen(sb2.toString(),
					pro.getProperty("model.className"),
					pro.getProperty("model.className") + "Service");

			// html 2
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
