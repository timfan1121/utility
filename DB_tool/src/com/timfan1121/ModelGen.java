package com.timfan1121;

import java.util.HashSet;
import java.util.Set;


public class ModelGen {
	public void gen(String patten,String tableName,String className){
		String[] cols=patten.split("@");
		Set<ColAttr> cs=new HashSet<ColAttr>();
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
		StringBuilder sb=new StringBuilder();
		sb.append("@Entity\n");
		sb.append("@Table(name=\""+tableName+"\")\n");
		sb.append("public class "+className+"{\n");
		for(ColAttr c:cs){
			sb.append("\t@Column(name=\""+c.getDb_name()+"\")\n");
			sb.append("\t"+c.getType()+" "+c.getJava_name()+";\n\n");
		}
		sb.append("\n\n");
		//getter setter
		for(ColAttr c:cs){
			sb.append("\tpublic void set"+c.getUpperJava_name()+"("+c.getType()+" "+
					c.getJava_name()+"){\n\t\tthis."+c.getJava_name()+"="+c.getJava_name()+";\n\t}\n");
			sb.append("\tpublic "+c.getType()+" get"+c.getUpperJava_name()+"(){\n\t\treturn "+c.getJava_name()+";\n\t}\n");
		}
		sb.append("}");
		FileOutper.outFile(sb.toString(), className+".java");
	}
}
