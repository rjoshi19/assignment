package com.ravi.assignment.account.exception;

import com.ravi.assignment.account.constant.ErrorMessage;

public class NotFoundException extends Exception {

	private static final long serialVersionUID = -6289949300369454672L;

	private final ErrorMessage errorMessage;

	public NotFoundException(ErrorMessage errorMessage) {
		this.errorMessage = errorMessage;
	}

	public ErrorMessage getErrorMessage() {
		return errorMessage;
	}
}
