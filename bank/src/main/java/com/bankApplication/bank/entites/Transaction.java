package com.bankApplication.bank.entites;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "transaction_table")
public class Transaction {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int amount;
    private LocalDateTime dateTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    // Getters and setters for the fields

    public Transaction(int amount) {
        this.amount = amount;
        this.dateTime = LocalDateTime.now();
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}