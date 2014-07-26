package com.timfan1121.tool;

import java.util.ArrayList;
import java.util.List;

import com.timfan1121.ColAttr;

public class ColumnParser {
	public static List<ColAttr> parser(String columns){
		String[] cols=columns.split("@");
		List<ColAttr> cs=new ArrayList<ColAttr>();
		for(String s:cols){
			try {
				String[] ss=s.substring(1).substring(0, s.length()-2).split(",");
				ColAttr c=new ColAttr();
				c.setDb_name(ss[0]);
				c.setJava_name(ss[1]);
				c.setType(ss[2]);
				cs.add(c);
			} catch (Exception e) {
			}
		}
		return cs;
	}
}
