package com.revature.models;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Transaction {
	private int id;
	private String trans_date;
	private double amount;
	private String trans_type;
	private int account_id;
	private int customerId;
	
	private static Logger logger = LoggerFactory.getLogger(Transaction.class);

	public Transaction(int id, String trans_date, double amount, String trans_type, int account_id) {
		super();
		this.id = id;
		this.trans_date = trans_date;
		if(amount > 0)
			this.amount = amount;
		else
			logger.warn("The owner of account #" + account_id + "tried to "
					+ "create a transaction with a negative amount");
		this.trans_type = trans_type;
		this.account_id = account_id;
		this.customerId = customerId;
	}

	public Transaction() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrans_date() {
		return trans_date;
	}

	public void setTrans_date(String trans_date) {
		this.trans_date = trans_date;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		if(amount > 0)
			this.amount = amount;
		else
			logger.warn("The owner of account #" + account_id + "tried to "
					+ "create a transaction with a negative amount");	
	}

	public String getTrans_type() {
		return trans_type;
	}

	public void setTrans_type(String trans_type) {
		this.trans_type = trans_type;
	}

	public int getAccount_id() {
		return account_id;
	}

	public void setAccount_id(int account_id) {
		this.account_id = account_id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + account_id;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + customerId;
		result = prime * result + id;
		result = prime * result + ((trans_date == null) ? 0 : trans_date.hashCode());
		result = prime * result + ((trans_type == null) ? 0 : trans_type.hashCode());
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
		Transaction other = (Transaction) obj;
		if (account_id != other.account_id)
			return false;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (customerId != other.customerId)
			return false;
		if (id != other.id)
			return false;
		if (trans_date == null) {
			if (other.trans_date != null)
				return false;
		} else if (!trans_date.equals(other.trans_date))
			return false;
		if (trans_type != other.trans_type)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", trans_date=" + trans_date + ", amount=" + amount + ", trans_type="
				+ trans_type + ", account_id=" + account_id + ", customerId=" + customerId + "]";
	}
	
}
