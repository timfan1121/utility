package com.timfan1121;

public class ControllerGen {

	//git
	public void gen(String data,String className,String serviceName){
		String l_className=className.substring(0, 1).toLowerCase()+className.substring(1);
		String l_serviceName=serviceName.substring(0, 1).toLowerCase()+serviceName.substring(1);
		data=data.replaceAll("@className",className );
		data=data.replaceAll("@l_className", l_className);
		data=data.replaceAll("@service", serviceName);
		data=data.replaceAll("@l_service", l_serviceName);
		FileOutper.outFile(data.toString(), className+"Controller.java");
	}
	
}
