package pnodder.repositories;

import org.springframework.stereotype.Repository;
import pnodder.model.Account;

import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class AccountRepository {

    private Map<Integer, Account> accountMap;

    {
        Account account1 = new Account("Jim Lahey", 4500.01);
        Account account2 = new Account("Sam Losco", 9780.67);
        Account account3 = new Account("Julian", 5005.99);
        accountMap.put(101, account1);
        accountMap.put(102, account2);
        accountMap.put(103, account3);
    }

    public void addAccount(Account account) {
        accountMap.put(104, account);
    }

    public Integer getAccountBalanceByName(String name) {
        Double i = accountMap.entrySet().stream()
                        .filter(map -> name.equals(map.getValue().getName()))
                        .map(map -> map.getValue().getBalance())
                        .collect(Collectors.toMap(m -> m.g))
}
