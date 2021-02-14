package com.cbxservice.application.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Repository;

import com.cbxservice.application.transactionmodel.CbxTransaction;

@Repository
public class CbxTransactionDAOImpl implements CbxTransactionDAO {

  
    
   //get all the transactions from the database
    @Override
    public List<CbxTransaction> getAllTransactions() {
       List<CbxTransaction> transactions = new ArrayList<>();
    	transactions.add(new CbxTransaction(UUID.randomUUID().toString(), "Savings", "11@cbx.com", LocalDate.now()));
    	transactions.add(new CbxTransaction(UUID.randomUUID().toString(), "Savings", "22@cbx.com", LocalDate.now()));
    	
    	return transactions;
   
    }
    
}
