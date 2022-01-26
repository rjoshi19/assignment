package com.ravi.assignment.transaction.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Setter
@Getter
public class Transaction {

	@Id
	@GeneratedValue
	private int id;
	private int accountId;
	private long transactionAmount;
	private Date transactionDate;

	public Transaction() {
	}

	public Transaction(int accountId, long transactionAmount) {
		this.accountId = accountId;
		this.transactionAmount = transactionAmount;
	}
}
