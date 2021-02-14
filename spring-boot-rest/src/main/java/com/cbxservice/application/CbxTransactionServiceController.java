package com.cbxservice.application;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cbxservice.application.restinvoker.CbxTransactionService;
import com.cbxservice.application.transactionmodel.CbxTransaction;
import com.cbxservice.application.transactionmodel.TransactionService;

@RestController
public class CbxTransactionServiceController {

	@Autowired
	public CbxTransactionService cbxTransactionService;

	@PostMapping("/transactions")
	public Optional<List<CbxTransaction>> getDetails(@RequestBody TransactionService service) {
		Optional<List<CbxTransaction>> transactions = Optional.ofNullable(cbxTransactionService.findAllTransactions());
		return transactions;

	}

	// Use Iptional RespEntity
	@PostMapping("/transactionsRespEnt")
	public ResponseEntity<Optional<List<CbxTransaction>>> getRespEntityDetails(
			@RequestBody TransactionService service) {
		return new ResponseEntity<Optional<List<CbxTransaction>>>(
				Optional.ofNullable(cbxTransactionService.findAllTransactions()), HttpStatus.OK);

	}

}