package com.java.anz.accounttransactions.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Account {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column(name="Account_name", nullable=false)
	private String accountName;
	
	@Column(name="Account_type", nullable=false)
	private String accountType;
	
	@Column(name="Date", nullable=false)
	private Date time;
	
	@Column(name="Currency", nullable=false)
	private String currency;
	
	@Column(name="Opening_Available_Balance", nullable=false)
	private double availablebalance;
	
	@JsonIgnore
	@OneToMany(mappedBy = "account")
	List<AccountTransaction> accountTransaction = new ArrayList<>(); 
	
	public Account(){}
	
	public Account(String accountName, String accountType, Date time, String currency, double availablebalance) 
	{
		super();
		this.accountName = accountName;
		this.accountType = accountType;
		this.time = time;
		this.currency = currency;
		this.availablebalance = availablebalance;
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
	
	public String getAccountType() {
		return accountType;
	}
	
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
	public String getCurrency() {
		return currency;
	}
	
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	
	public double getAvailablebalance() {
		return availablebalance;
	}
	
	public void setAvailablebalance(double availablebalance) {
		this.availablebalance = availablebalance;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public List<AccountTransaction> getAccountTransaction() {
		return accountTransaction;
	}

	public void addAccountTransaction(AccountTransaction accountTransaction) {
		this.accountTransaction.add(accountTransaction);
	}
	
	public void removeAccountTransaction(AccountTransaction accountTransaction) {
		this.accountTransaction.remove(accountTransaction);
	}
	
}