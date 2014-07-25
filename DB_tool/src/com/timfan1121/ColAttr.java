package com.timfan1121;

public class ColAttr {
	String db_name;
	String type;
	String java_name;
	public String getDb_name() {
		return db_name;
	}
	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getJava_name() {
		return java_name;
	}
	public void setJava_name(String java_name) {
		this.java_name = java_name;
	}

	public String getUpperJava_name() {
		String s=java_name.substring(0, java_name.length()).toUpperCase();
		return s+java_name.substring(0);
	}
	
	
}
