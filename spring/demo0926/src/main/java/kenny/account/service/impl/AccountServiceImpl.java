package kenny.account.service.impl;

import kenny.account.dao.IAccountDao;
import kenny.account.domain.Account;
import kenny.account.service.IAccountService;
import kenny.account.utils.TransactionManager;

import java.util.List;

/**
 * @author 杨小平
 * @date 2020/9/26 6:19
 * @description TODO
 */
public class AccountServiceImpl implements IAccountService {
    IAccountDao accountDao;
    TransactionManager transactionManager;

    public void setTransactionManager(TransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setAccountDao(IAccountDao accountDao) {
        this.accountDao = accountDao;
    }

    public void saveAccount(Account account) {
        try{
            transactionManager.beginTransaction();
            accountDao.save(account);
            transactionManager.commit();
        }catch (Exception e){
            transactionManager.rollback();
        }finally {
            transactionManager.release();
        }
    }

    public void updateAccount(Account account) {
        try{
            transactionManager.beginTransaction();
            accountDao.update(account);
            transactionManager.commit();
        }catch (Exception e){
            transactionManager.rollback();
        }finally {
            transactionManager.release();
        }
    }

    public void deleteAccountById(Integer accountId) {
        try{
            transactionManager.beginTransaction();
            accountDao.delete(accountId);
            transactionManager.commit();
        }catch (Exception e){
            transactionManager.rollback();
        }finally {
            transactionManager.release();
        }
    }

    public Account findAccountById(Integer accountId) {
        try{
            transactionManager.beginTransaction();
            Account account = accountDao.findById(accountId);
            transactionManager.commit();
            return account;
        }catch (Exception e){
            transactionManager.rollback();
        }finally {
            transactionManager.release();
        }
        return null;
    }

    public List<Account> findAllAccount() {
        try{
            transactionManager.beginTransaction();
            List<Account> accounts = accountDao.findAll();
            transactionManager.commit();
            return accounts;
        }catch (Exception e){
            transactionManager.rollback();
        }finally {
            transactionManager.release();
        }
        return null;
    }

    public void transfer(String source, String dest, Float money) {
        try{
            transactionManager.beginTransaction();
            Account accountSource = accountDao.findByName(source);
            Account accountDest = accountDao.findByName(dest);
            accountSource.setMoney(accountSource.getMoney()-money);
            accountDest.setMoney(accountDest.getMoney()+money);
            accountDao.update(accountSource);
            //int i=1/0;
            accountDao.update(accountDest);
            transactionManager.commit();
        }catch (Exception e){
            transactionManager.rollback();
        }finally {
            transactionManager.release();
        }
    }
}