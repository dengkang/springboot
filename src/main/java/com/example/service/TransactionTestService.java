package com.example.service;

public interface TransactionTestService {

    void transactionMethod(String name) throws Exception;

    void nestingTransactionMethod(String name) throws Exception;

}
