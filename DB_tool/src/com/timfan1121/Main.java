package com.timfan1121;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import sun.swing.MenuItemLayoutHelper.ColumnAlignment;

import com.timfan1121.controller.ControllerGen;
import com.timfan1121.dao.DaoGen;
import com.timfan1121.jsp.JspQueryGen;
import com.timfan1121.model.ModelGen;
import com.timfan1121.tool.ColumnParser;

public class Main {
	Properties pro = new Properties();
	List<ColAttr> cols=new ArrayList<ColAttr>();
	public Main() {
		try {
			FileInputStream f = new FileInputStream(getClass().getResource("/column.properties").getPath());
			pro.load(f);
			cols.addAll(ColumnParser.parser(pro.getProperty("model.column")));
			
//			 model
//			 new ModelGen().gen(pro.getProperty("model.column")
//			 , pro.getProperty("model.tablename"),
//			 pro.getProperty("model.className"));

//			 dao
//			 new DaoGen().gen(pro.getProperty("model.tablename"),
//			 pro.getProperty("model.className"));

			 
			 
			 // controller
//			FileInputStream importF = new FileInputStream(getClass().getResource("/springMVC.txt").getPath());
//			BufferedReader df = new BufferedReader(new InputStreamReader(
//					new DataInputStream(importF)));
//			String str;
//			StringBuilder sb2 = new StringBuilder();
//			while ((str = df.readLine()) != null) {
//				sb2.append(str + "\n");
//			}
//			new ControllerGen().gen(sb2.toString(),
//					pro.getProperty("model.className"),
//					pro.getProperty("model.className") + "Service");

			// html 2
			JspQueryGen q=new JspQueryGen();
			q.gen(getClass().getResource("/JspQueryTemplate").getPath(), cols, pro.getProperty("model.className"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
