package com.timfan1121;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.timfan1121.tool.ColumnParser;

public class Test {
	public Test() throws IOException {
		Properties pro = new Properties();
		FileInputStream f = new FileInputStream(getClass().getResource("/column.properties").getPath());
		pro.load(f);
		String p=pro.getProperty("model.column");
//		p=p.replaceAll("@\\{[^@]+\\}", "test");
//		String[] ss=p.split("@\\{[^@]+\\}");
		String[] ss=p.split("@");
		
//		System.out.println(ss.toString());
		
		
		Pattern pat = Pattern.compile("\\{([^\\{])+\\}"); // 正则表达式 
		   Matcher m = pat.matcher(p); // 操作的字符串 
		   StringBuffer sb = new StringBuffer(); 
		   int i = 0; 
		   while (m.find()) {
//			   System.out.println(m.start());
//			   m.end();
			   System.out.println(m.group());
			   
//		    m.appendReplacement(sb, str); 
		    i++;    //字符串出现次数 
		   } 
		   
	}
	public static void main(String[] args) {
		try {
			new Test();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
