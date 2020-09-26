package kenny.account.service.impl;

import kenny.account.dao.IAccountDao;
import kenny.account.domain.Account;
import kenny.account.service.IAccountService;
import kenny.account.utils.TransactionManager;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨小平
 * @date 2020/9/26 6:19
 * @description TODO
 */
@Service(value="accountService")
public class AccountServiceImpl implements IAccountService {
    @Resource(name="accountDao")
    IAccountDao accountDao;

    public void saveAccount(Account account) {
        accountDao.save(account);
    }

    public void updateAccount(Account account) {
        accountDao.update(account);
    }

    public void deleteAccountById(Integer accountId) {
        accountDao.delete(accountId);
    }

    public Account findAccountById(Integer accountId) {
        Account account = accountDao.findById(accountId);
        return account;
    }

    public List<Account> findAllAccount() {
        List<Account> accounts = accountDao.findAll();
        return accounts;
    }

    public void transfer(String source, String dest, Float money) {
        Account accountSource = accountDao.findByName(source);
        Account accountDest = accountDao.findByName(dest);
        accountSource.setMoney(accountSource.getMoney() - money);
        accountDest.setMoney(accountDest.getMoney() + money);
        accountDao.update(accountSource);
        //int i = 1 / 0;
        accountDao.update(accountDest);
    }

}