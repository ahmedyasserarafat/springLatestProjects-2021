package com.cbxservice.application.dao;

import java.util.List;

import com.cbxservice.application.transactionmodel.CbxTransaction;

public interface CbxTransactionDAO {

    List<CbxTransaction> getAllTransactions();

}