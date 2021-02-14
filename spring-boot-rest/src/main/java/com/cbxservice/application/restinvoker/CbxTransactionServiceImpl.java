package com.cbxservice.application.restinvoker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbxservice.application.dao.CbxTransactionDAO;
import com.cbxservice.application.transactionmodel.CbxTransaction;

@Service
public class CbxTransactionServiceImpl implements CbxTransactionService {

	@Autowired
    private CbxTransactionDAO transactionDAO;

  

    @Override
    public List<CbxTransaction> findAllTransactions() {
        return transactionDAO.getAllTransactions();
    }
    
    
}