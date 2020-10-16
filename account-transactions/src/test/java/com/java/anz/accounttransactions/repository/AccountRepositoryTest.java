package com.java.anz.accounttransactions.repository;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.java.anz.accounttransactions.dao.AccountRepository;
import com.java.anz.accounttransactions.dao.TransactionRepository;
import com.java.anz.accounttransactions.model.Account;
import com.java.anz.accounttransactions.model.AccountTransaction;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AccountRepositoryTest {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	//given get all accounts gives xxx
	
	@Test
	public void totalAccountsRetrieved()
	{
		logger.info("init test running....");
		List<Account> list = accountRepository.getAllAccounts();
		assertEquals(11, list.size());
	}
	
	@Test
	public void transactionsRetrievedForGivenAccount()//check transaction
	{
		Account a = accountRepository.findById(791066619L);
		List<AccountTransaction> transactions = transactionRepository.retrieveTransactions(a);
		assertEquals(3, transactions.size());
		}
	
}
