package pnodder.services;

import pnodder.model.Account;

import java.util.List;

public interface AccountService {

    void insertAccount(Account account);

    Integer getAccountBalanceByName(String name);

}
