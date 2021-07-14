package com.revature.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Account {
		
	private int id;
	private int customerId;
	private double balance;
	private String approved;
	
	private static Logger logger = LoggerFactory.getLogger(Account.class);
	
	

	public Account(int id, int customerId, double balance, String approved) {
		super();
		this.id = id;
		this.customerId = customerId;
		if(balance >= 0)
			this.balance = balance;
		else {
			logger.warn(this.id + "tried to set opening balance as a negative number");
		}
		this.approved = approved;
	}

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getApproved() {
		return approved;
	}

	public void setApproved(String approved) {
		this.approved = approved;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		if(balance >= 0)
			this.balance = balance;
		else {
			logger.warn(this.id + "tried to set opening balance as a negative number");
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((approved == null) ? 0 : approved.hashCode());
		long temp;
		temp = Double.doubleToLongBits(balance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + customerId;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (approved == null) {
			if (other.approved != null)
				return false;
		} else if (!approved.equals(other.approved))
			return false;
		if (Double.doubleToLongBits(balance) != Double.doubleToLongBits(other.balance))
			return false;
		if (customerId != other.customerId)
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", customerId=" + customerId + ", balance=" + balance + ", approved=" + approved
				+ "]";
	}
	
}
