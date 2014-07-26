package com.timfan1121.jsp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;

import com.timfan1121.ColAttr;
import com.timfan1121.FileOutper;
import com.timfan1121.tool.FileReader;


/**
 * 產生JSP query的class
 * @author tim
 *
 */
public class JspQueryGen {
	
	public void gen(String path,
			List<ColAttr> columns,
			String className
			) throws IOException{
		
		String l_className=className.substring(0, 1).toLowerCase()+className.substring(1);
		
		String d=body(path, 
				className,
				l_className,
				 part1(path+"_part1", l_className, columns),
				 part2(path+"_part2", l_className, columns));
		
//		d=d.replaceAll("@part1",);
//		String ps=part2(path+"_part2", l_className, columns);
//		d=d.replaceAll("@part2", );
//		d=d.replaceAll("@part2", "4324324");
		
		FileOutper.outFile(d,className+"Query.jsp");
	}
	
	public String body(String path,
			String className,
			String l_className,
			String part1,
			String part2) throws IOException{
		FileInputStream boy = new FileInputStream(path);
		BufferedReader df = new BufferedReader(new InputStreamReader(new DataInputStream(boy)));
		StringBuilder sb2 = new StringBuilder();
		String str;
		try {
			while ((str = df.readLine()) != null) {
				if(str.indexOf("@part1")!=-1){
					sb2.append(part1 + "\n");
				}else if(str.indexOf("@part2")!=-1){
					sb2.append(part2 + "\n");
				}else{
					sb2.append(str + "\n");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
		str=sb2.toString();
		str=str.replaceAll("@l_className", l_className);
		return str;
	}
	
	public String part1(String path,String l_className,List<ColAttr> column) throws IOException{
		FileInputStream part1Fis = new FileInputStream(path);
		StringBuilder sb=new StringBuilder();
		String s=FileReader.read(part1Fis);
		for(ColAttr str:column){
			String t=s.replaceAll("@l_className", l_className);
			t=t.replaceAll("@column", str.getJava_name());
			sb.append(t);
		}
		return sb.toString();
	}
	public String part2(String path,String l_className,List<ColAttr> column) throws IOException{
		FileInputStream part2Fis = new FileInputStream(path);
		StringBuilder sb=new StringBuilder();
		String s=FileReader.read(part2Fis);
		for(ColAttr str:column){
			String t=s.replaceAll("@l_className", l_className);
			t=t.replaceAll("@column", str.getJava_name());
			sb.append(t);
		}
		return sb.toString();
	}
}
