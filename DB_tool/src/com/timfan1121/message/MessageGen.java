package com.timfan1121.message;

import java.util.ArrayList;
import java.util.List;

import com.timfan1121.ColAttr;
import com.timfan1121.FileOutper;
import com.timfan1121.QueryColAttr;

/**
 *多國語言產生器 
 */
public class MessageGen {
	public void gen(List<ColAttr> cols,
			List<QueryColAttr> qcols,
			String startLabel){
		
		StringBuilder sb=new StringBuilder();
		for(ColAttr col:cols){
			sb.append(startLabel+"."+col.getJava_name()+"="+col.getMessage());
			sb.append("\n");
		}

		sb.append("\n");
		for(QueryColAttr col:qcols){
			sb.append(startLabel+"."+col.getColName()+"="+col.getMsg());
			sb.append("\n");
		}
		FileOutper.outFile(sb.toString(), "message.properties");
	}
}
