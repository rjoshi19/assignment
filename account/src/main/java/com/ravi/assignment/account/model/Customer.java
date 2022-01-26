package com.ravi.assignment.account.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Setter
@Getter
public class Customer {
	@Id
	@GeneratedValue
	@ApiModelProperty(readOnly = true)
	private int id;
	private String name;
	private String surname;

	public Customer() {
	}

	public Customer(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}
}
