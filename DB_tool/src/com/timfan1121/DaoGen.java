package com.timfan1121;

public class DaoGen {
	public void gen(String tableName,String className){
		//git
		String sclassName=className.substring(0, 1).toLowerCase()+className.substring(1);
		
		StringBuilder sb=new StringBuilder();
		sb.append("@Repository(\""+sclassName+"Dao\")\n");
		sb.append("public class "+className+"Dao{\n");
		sb.append("\n");
		
		//add
		sb.append("\tpublic void add"+className+"("+className+" "+
				sclassName+"){\n\t}\n");
			
		//delete
		sb.append("\tpublic void delete"+className+"("+className+" "+
				sclassName+"){\n\t}\n");

		//update
		sb.append("\tpublic void update"+className+"("+className+" "+
				sclassName+"){\n\t}\n");
		sb.append("}");
		FileOutper.outFile(sb.toString(), className+"Dao.java");
	}
}
