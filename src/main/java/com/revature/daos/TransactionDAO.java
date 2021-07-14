package com.revature.daos;

import com.revature.models.Transaction;
import com.revature.models.Transfer;

public interface TransactionDAO {

	void createWithdrawal(Transaction transaction);

	void createDeposit(Transaction transaction);

	void createTransfer(Transfer transfer);

}
