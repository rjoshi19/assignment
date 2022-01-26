package com.ravi.assignment.account.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.PositiveOrZero;

@Entity
@Setter
@Getter
public class Account {

	@Id
	@GeneratedValue
	@ApiModelProperty(readOnly = true)
	private int id;
	private int customerId;

	@PositiveOrZero
	private long initialBalance;

	@ApiModelProperty(readOnly = true)
	private long balance;

	public Account() {
	}

	public Account(int customerId, long initialBalance) {
		this.customerId = customerId;
		this.initialBalance = initialBalance;
	}

	public void addBalance(long transactionAmount) {
		balance += transactionAmount;
	}
}
