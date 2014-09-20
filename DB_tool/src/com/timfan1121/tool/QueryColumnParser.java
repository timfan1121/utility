package com.timfan1121.tool;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.timfan1121.ColAttr;
import com.timfan1121.QueryColAttr;

public class QueryColumnParser {
	public static List<QueryColAttr> parser(String columns){
		Pattern pat = Pattern.compile("\\{([^\\{])+\\}");
		Matcher m = pat.matcher(columns);
		List<QueryColAttr> cs=new ArrayList<QueryColAttr>();
		while(m.find()){
			String s=m.group().substring(1, m.group().length()-1); //去頭尾
			try {
				String[] ss=s.split(",");
				QueryColAttr c=new QueryColAttr();
				c.setColName(ss[0]);
				c.setMsg(ss[1]);
				cs.add(c);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return cs;
	}
}
