package com.ravi.assignment.account.proxy;

import com.ravi.assignment.account.model.Transaction;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "transaction-service", fallback = TransactionServiceFallback.class)
@RibbonClient(name = "transaction-service")
public interface TransactionServiceProxy {
	@GetMapping("/api/account/{accountId}/transactions")
	List<Transaction> getAccountTransactions(@PathVariable("accountId") int accountId);

	@PostMapping("/api/transactions")
	Transaction createTransaction(@RequestBody Transaction transaction);

	@DeleteMapping("/api/transactions")
	void deleteAllTransactions();
}