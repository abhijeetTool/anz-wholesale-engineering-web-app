package com.java.anz.accounttransactions.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class AccountTransaction {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="Account_name", nullable=false)
	private String accountName;
	
	@Column(name="Value_date", nullable=false)
	private Date date;
	
	@Column(name="Currency", nullable=false)
	private String currency;
	
	@Column(name="Debit_amount")
	private double debitAmount;
	
	@Column(name="Credit_amount")
	private double creditAmount;
	
	@Column(name="Debit_credit")
	private String transactionType;
	
	@Column(name="Transaction_narrative")
	private String transactionNarrative;
	
	@ManyToOne
	//Account_number
	private Account account;

	public AccountTransaction() {}
	
	public AccountTransaction(String accountName, Date date, String currency, double debitAmount, double creditAmount,
			String transactionType, String transactionNarrative) {
		this.accountName = accountName;
		this.date = date;
		this.currency = currency;
		this.debitAmount = debitAmount;
		this.creditAmount = creditAmount;
		this.transactionType = transactionType;
		this.transactionNarrative = transactionNarrative;
	}

	public Long getId() {
		return id;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public double getDebitAmount() {
		return debitAmount;
	}

	public void setDebitAmount(double debitAmount) {
		this.debitAmount = debitAmount;
	}

	public double getCreditAmount() {
		return creditAmount;
	}

	public void setCreditAmount(double creditAmount) {
		this.creditAmount = creditAmount;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public String getTransactionNarrative() {
		return transactionNarrative;
	}

	public void setTransactionNarrative(String transactionNarrative) {
		this.transactionNarrative = transactionNarrative;
	}

	public void setAccount(Account account) {
		this.account=account;
	}
	
	public Account getAccount() {
		return account;
	}

}
