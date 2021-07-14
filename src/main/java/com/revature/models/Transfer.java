package com.revature.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transfer {
	
	private int id;
	private int customerId;
	private double amount;
	private int startAccount;
	private int destAccount;
	
	private static Logger logger = LoggerFactory.getLogger(Transfer.class);

	public Transfer(int id, int customerId, double amount, int startAccount, int destAccount) {
		super();
		this.id = id;
		this.customerId = customerId;
		if(amount > 0)
			this.amount = amount;
		else
			logger.warn("User tried to create a transfer with a negative amount");
		this.startAccount = startAccount;
		this.destAccount = destAccount;
	}

	public Transfer() {
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

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		if(amount > 0)
			this.amount = amount;
		else
			logger.warn("User tried to create a transfer with a negative amount");
	}

	public int getStartAccount() {
		return startAccount;
	}

	public void setStartAccount(int startAccount) {
		this.startAccount = startAccount;
	}

	public int getDestAccount() {
		return destAccount;
	}

	public void setDestAccount(int destAccount) {
		this.destAccount = destAccount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + customerId;
		result = prime * result + destAccount;
		result = prime * result + id;
		result = prime * result + startAccount;
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
		Transfer other = (Transfer) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (customerId != other.customerId)
			return false;
		if (destAccount != other.destAccount)
			return false;
		if (id != other.id)
			return false;
		if (startAccount != other.startAccount)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transfer [id=" + id + ", customerId=" + customerId + ", amount=" + amount + ", startAccount="
				+ startAccount + ", destAccount=" + destAccount + "]";
	}

}
