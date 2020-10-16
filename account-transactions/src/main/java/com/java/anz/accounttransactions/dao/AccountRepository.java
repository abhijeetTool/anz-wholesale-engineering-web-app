package com.java.anz.accounttransactions.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java.anz.accounttransactions.exceptions.AccountNotFoundException;
import com.java.anz.accounttransactions.exceptions.TransactionsNotFoundException;
import com.java.anz.accounttransactions.model.Account;
import com.java.anz.accounttransactions.model.AccountTransaction;

@Repository
public class AccountRepository {

	//@PersistenceContext
	@Autowired
	EntityManager entityManager;
	
	public List<Account> getAllAccounts() {
		return entityManager.createQuery("SELECT a FROM Account a").getResultList();
	}

	public Account findById(long id) {
		Account account = entityManager.find(Account.class, id);
		if (account==null)
	        throw new AccountNotFoundException("for id :" + id);

		return account;
	}
		
}
