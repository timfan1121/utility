package com.timfan1121.jsp;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.timfan1121.ColAttr;
import com.timfan1121.FileOutper;
import com.timfan1121.QueryColAttr;
import com.timfan1121.tool.FileReader;


/**
 * 產生JSP query的class
 * @author tim
 *
 */
public class JspQueryGen {
	
	public void gen(String path,
			List<ColAttr> cols,
			List<QueryColAttr> qcols,
			String messageStartLabel,
			String packageName,
			String modelName
			) throws IOException{
		
		
		String htmlStr=body(cols,
				path, 
				"",
				"",
				packageName,
				modelName
				);
		
		String p1Str=part1(path+"_part1",messageStartLabel, qcols);
		htmlStr=htmlStr.replace("@{part1}",p1Str);
		String p2Str=part2(path+"_part2",messageStartLabel, cols);
		htmlStr=htmlStr.replace("@{part2}",p2Str);
		String p3Str=part3(path+"_part3",modelName, cols);
		htmlStr=htmlStr.replace("@{part3}",p3Str);
		
		FileOutper.outFile(htmlStr,"view.jsp");
	}
	
	/**
	 * 主樣板的產生器
	 */
	public String body(List<ColAttr> cols
			,String path,
			String part1,
			String part2,
			String packageName,
			String modelName) throws IOException{
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
		str=str.replaceAll("@\\{package_name\\}", packageName);
		str=str.replaceAll("@\\{colunm_num\\}", String.valueOf(cols.size()));
		str=str.replaceAll("@\\{model_name\\}", modelName);
		return str;
	}
	
	public String part1(String path,String startLabel,List<QueryColAttr> qcol) throws IOException{
		FileInputStream part1Fis = new FileInputStream(path);
		StringBuilder sb=new StringBuilder();
		String s=FileReader.read(part1Fis);
		for(QueryColAttr q:qcol){
			String t=s.replaceAll("@\\{i18n\\}",startLabel+"."+ q.getColName());
			t=t.replaceAll("@\\{col_name\\}", q.getColName());
			sb.append(t);
		}
		return sb.toString();
	}
	
	public String part2(String path,String startLabel,List<ColAttr> col) throws IOException{
		FileInputStream part1Fis = new FileInputStream(path);
		StringBuilder sb=new StringBuilder();
		String s=FileReader.read(part1Fis);
		for(ColAttr q:col){
			String t=s.replaceAll("@\\{i18n\\}",startLabel+"."+ q.getJava_name());
			sb.append(t);
		}
		return sb.toString();
	}
	
	public String part3(String path,
			String modelName,List<ColAttr> col) throws IOException{
		FileInputStream part1Fis = new FileInputStream(path);
		StringBuilder sb=new StringBuilder();
		String s=FileReader.read(part1Fis);
		for(ColAttr q:col){
			String t=s.replaceAll("@\\{model_name\\}",modelName);
			t=t.replaceAll("@\\{bean_name\\}",q.getJava_name());
			sb.append(t);
		}
		return sb.toString();
	}
	
}
