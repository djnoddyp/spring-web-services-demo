package pnodder.repositories;

import org.springframework.stereotype.Repository;
import pnodder.model.Account;

import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AccountRepository {

    private Map<Integer, Account> accountMap;

    {
        Account account1 = new Account();
        account1.setName("Jim");
        account1.setBalance(9066.85);

        Account account2 = new Account();
        account2.setName("Sam Losco");
        account2.setBalance(4550.55);

        Account account3 = new Account();
        account3.setName("Julian");
        account3.setBalance(1020.99);

        accountMap.put(101, account1);
        accountMap.put(102, account2);
        accountMap.put(103, account3);
    }

    public void addAccount(Account account) {
        accountMap.put(104, account);
    }

    public Double getAccountBalanceByName(String name) {
        Double balance = accountMap.entrySet().stream()
                        .filter(map -> name.equals(map.getValue().getName()))
                        .mapToDouble(map -> map.getValue().getBalance())
                        .sum();
        return balance;
    }
}
