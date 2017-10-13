package pnodder.endpoints;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.support.SpringBeanAutowiringSupport;
import pnodder.model.Account;
import pnodder.services.AccountService;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService(serviceName = "AccountService")
public class AccountServiceEndpoint {

    @Autowired
    private AccountService accountService;

    @WebMethod
    public void insertAccount(Account account) {
        accountService.insertAccount(account);
    }

    @WebMethod
    public Double getAccountbalanceByName(String name) {
        return accountService.getAccountBalanceByName(name);
    }

}
