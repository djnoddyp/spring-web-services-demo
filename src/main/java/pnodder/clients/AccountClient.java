package pnodder.clients;

import pnodder.services.AccountService;

public class AccountClient {

    private AccountService accountService;

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public Double getAccountBalanceByName(String name) {
        return accountService.getAccountBalanceByName(name);
    }
}
