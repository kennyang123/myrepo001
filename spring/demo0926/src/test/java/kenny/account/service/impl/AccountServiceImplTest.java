package kenny.account.service.impl;

import kenny.account.domain.Account;
import kenny.account.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class AccountServiceImplTest {
    ApplicationContext ac= new ClassPathXmlApplicationContext("bean.xml");
    IAccountService accountService = ac.getBean("accountService", IAccountService.class);
    @Test
    public void saveAccount() {
        Account account = new Account();
        account.setName("ddd");
        account.setMoney(999f);
        accountService.saveAccount(account);
    }

    @Test
    public void updateAccount() {
        Account account = new Account();
        account.setId(4);
        account.setName("eee");
        account.setMoney(1999f);
        accountService.updateAccount(account);
    }

    @Test
    public void deleteAccountById() {
        accountService.deleteAccountById(4);
    }

    @Test
    public void findAccountById() {
        Account account = accountService.findAccountById(4);
        System.out.println(account);
    }

    @Test
    public void findAllAccount() {
        List<Account> accounts = accountService.findAllAccount();
        System.out.println(accounts);
    }

    @Test
    public void transfer() {
        accountService.transfer("aaa","bbb",100f);
    }
}