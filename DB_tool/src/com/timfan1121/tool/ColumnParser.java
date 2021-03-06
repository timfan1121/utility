package com.timfan1121.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.timfan1121.ColAttr;

public class ColumnParser {
	public static List<ColAttr> parser(String columns){
		Pattern pat = Pattern.compile("\\{([^\\{])+\\}");
		Matcher m = pat.matcher(columns);
		List<ColAttr> cs=new ArrayList<ColAttr>();
		while(m.find()){
			String s=m.group().substring(1, m.group().length()-1); //去頭尾
			try {
				String[] ss=s.split(",");
				ColAttr c=new ColAttr();
				c.setDb_name(ss[0]);
				c.setJava_name(ss[1]);
				c.setType(ss[2]);
				c.setMessage(ss[3]);
				cs.add(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cs;
	}
}
