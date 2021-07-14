package com.revature.models;

public class Employee {
	
	private int id;
	private String name;
	private String username;
	private int passcode;
	
	public Employee(int id, String name, String username, int passcode) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.passcode = passcode;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getPasscode() {
		return passcode;
	}

	public void setPasscode(int passcode) {
		this.passcode = passcode;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", username=" + username + ", passcode=" + passcode + "]";
	}
	
}
