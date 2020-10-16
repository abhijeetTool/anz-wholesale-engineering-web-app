package com.java.anz.accounttransactions.dao;

import java.util.List;
import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.java.anz.accounttransactions.exceptions.AccountNotFoundException;
import com.java.anz.accounttransactions.exceptions.TransactionsNotFoundException;
import com.java.anz.accounttransactions.model.Account;
import com.java.anz.accounttransactions.model.AccountTransaction;

@Repository
@Transactional
public class TransactionRepository {

	//@PersistenceContext
	@Autowired
	EntityManager entityManager;
	
	public List<AccountTransaction> retrieveTransactions(Account account)  {

		if(account.getAccountTransaction()==null)
		{
			throw new TransactionsNotFoundException("for id :" + account.getId());
		}
		
		return account.getAccountTransaction();
	}
	
}
