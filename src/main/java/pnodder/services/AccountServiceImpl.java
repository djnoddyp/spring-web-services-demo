package pnodder.services;

import pnodder.model.Account;
import pnodder.repositories.AccountRepository;

import java.util.List;

public class AccountServiceImpl implements AccountService {

    private AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void insertAccount(Account account) {
        accountRepository.addAccount(account);
    }

    public Double getAccountBalanceByName(String name) {
        return accountRepository.getAccountBalanceByName(name);
    }
}
