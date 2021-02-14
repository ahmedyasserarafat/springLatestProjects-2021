package com.cbxservice.application.restinvoker;

import java.util.List;

import com.cbxservice.application.transactionmodel.CbxTransaction;

public interface CbxTransactionService {

    public List<CbxTransaction> findAllTransactions();

}