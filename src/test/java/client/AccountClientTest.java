package client;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import pnodder.clients.AccountClient;
import pnodder.config.AppConfig;

public class AccountClientTest {

    @Autowired
    private AccountClient accountClient;

    @Before
    public void initialiseContext() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        accountClient = (AccountClient) ctx.getBean("client");
    }

    @Test
    public void testGetAccountBalanceByName() {
        Double balance = accountClient.getAccountBalanceByName("Jim");
        Double expected = 9066.85;
        Assert.assertEquals(expected, balance);
    }

}
