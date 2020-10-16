package com.java.anz.accounttransactions.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.java.anz.accounttransactions.dao.AccountRepository;
import com.java.anz.accounttransactions.dao.TransactionRepository;
import com.java.anz.accounttransactions.model.Account;
import com.java.anz.accounttransactions.model.AccountTransaction;

@RestController
public class AccountTransactionsController {

	@Autowired
	AccountRepository accountRepository;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home()
	{
		String homeMessage = "ANZ Wholesale Engineering Sample Project (Backend Development). "
				+ "To get the list of all accounts : /getAllAccounts "
				+ "To get transaction details of a specific account: /transactionEnquiry/{id}";
		return(homeMessage);
	}
	
	@RequestMapping(value = "/getAllAccounts", method = RequestMethod.GET)
	public List<Account> getAllAccounts()
	{
		return accountRepository.getAllAccounts();
	}
	
	
	@RequestMapping(value = "/transactionEnquiry/{id}", method = RequestMethod.GET)
	public List<AccountTransaction> getAccountDetails(@PathVariable long id)
	{
		Account foundAccount =accountRepository.findById(id);
		
		return transactionRepository.retrieveTransactions(foundAccount);
	}

}
