package com.musicshop;

public class Customer {

	private int uid;
	private String username;
	private String name;
	private String password;
	
	
	public Customer(int uid, String username, String name, String password) {
		super();
		this.uid = uid;
		this.username = username;
		this.name = name;
		this.password = password;
	}


	public int getUid() {
		return uid;
	}


	public String getUsername() {
		return username;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

}
