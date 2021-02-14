package com.cbxservice.application.transactionmodel;

import java.time.LocalDate;

public class CbxTransaction {

  
    private String id;

    private String type;

    private String email;

    private LocalDate date;

    public CbxTransaction(){

    }

    public CbxTransaction(String id, String type, String email, LocalDate date) {
        this.id=id;
        this.type = type;
        this.email = email;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}