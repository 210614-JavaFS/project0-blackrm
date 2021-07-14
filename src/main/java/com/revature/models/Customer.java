package com.revature.models;

public class Customer {
	private int id;
	private String name;
	private String username;
	private String join_date;
	
	public Customer(int id, String name, String username, String join_date) {
		super();
		this.id = id;
		this.name = name;
		this.username = username;
		this.join_date = join_date;
	}

	public Customer() {
		super();
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

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String date) {
		this.join_date = date;
	}

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", username=" + username + ", join_date=" + join_date + "]";
	}
}
