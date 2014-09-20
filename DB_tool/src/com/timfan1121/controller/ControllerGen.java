package com.timfan1121.controller;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.timfan1121.FileOutper;

public class ControllerGen {

	//git
	public void gen(String filePath,String className,String serviceName) throws IOException{
		
		FileInputStream importF = new FileInputStream(filePath);
		BufferedReader df = new BufferedReader(new InputStreamReader(
				new DataInputStream(importF)));
		String str;
		StringBuilder sb2 = new StringBuilder();
		while ((str = df.readLine()) != null) {
			sb2.append(str + "\n");
		}
		
		String data=sb2.toString();
		
		String l_className=className.substring(0, 1).toLowerCase()+className.substring(1);
		String l_serviceName=serviceName.substring(0, 1).toLowerCase()+serviceName.substring(1);
		data=data.replaceAll("@className",className );
		data=data.replaceAll("@l_className", l_className);
		data=data.replaceAll("@service", serviceName);
		data=data.replaceAll("@l_service", l_serviceName);
		FileOutper.outFile(data.toString(), className+"Controller.java");
	}
	
}
