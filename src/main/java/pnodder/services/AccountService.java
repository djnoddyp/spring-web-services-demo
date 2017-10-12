package pnodder.services;

import org.springframework.stereotype.Service;
import pnodder.model.Account;

import java.util.List;

@Service
public interface AccountService {

    void insertAccount(Account account);

    Double getAccountBalanceByName(String name);

}
