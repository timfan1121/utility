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
import com.timfan1121.message.MessageGen;
import com.timfan1121.model.ModelGen;
import com.timfan1121.tool.ColumnParser;
import com.timfan1121.tool.QueryColumnParser;

public class Main {
	Properties pro = new Properties();
	List<ColAttr> cols=new ArrayList<ColAttr>();
	List<QueryColAttr> qcols=new ArrayList<QueryColAttr>();
	
	public Main() {
		try {
			FileInputStream f = new FileInputStream(getClass().getResource("/column.properties").getPath());
			pro.load(f);
			cols.addAll(ColumnParser.parser(pro.getProperty("model.column")));
			qcols.addAll(QueryColumnParser.parser(pro.getProperty("jsp.queryColumn")));
			
//			 model
//			 new ModelGen().gen(pro.getProperty("model.column")
//			 , pro.getProperty("model.tablename"),
//			 pro.getProperty("model.className"));

//			 dao
//			 new DaoGen().gen(pro.getProperty("model.tablename"),
//			 pro.getProperty("model.className"));

			 
			 
			 // controller
//			new ControllerGen().gen(getClass().getResource("/controllerTemplate").getPath(),
//					pro.getProperty("model.className"),
//					pro.getProperty("model.className") + "Service");

			// html 2
			JspQueryGen q=new JspQueryGen();
			q.gen(getClass().getResource("/JspQueryTemplate").getPath(),
					cols, 
					qcols,
					pro.getProperty("message.startLable"),
					pro.getProperty("jsp.html.package"),
					pro.getProperty("jsp.modelName")
					);
			
			
			//message
//			MessageGen mgen=new MessageGen();
//			mgen.gen(cols,qcols, pro.getProperty("message.startLable"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new Main();
	}

}
