package com.musicshop;

public class Songs {

	private int sid;
	private String name;
	private String description;
	
	public Songs(int sid, String name, String description) {
		
		this.sid = sid;
		this.name = name;
		this.description = description;
	}

	public int getSid() {
		return sid;
	}


	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}

}
