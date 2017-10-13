package pnodder.services;

import org.springframework.stereotype.Service;
import pnodder.model.Account;

import javax.jws.WebService;
import java.util.List;

@Service
@WebService
public interface AccountService {

    void insertAccount(Account account);

    Double getAccountBalanceByName(String name);

}
