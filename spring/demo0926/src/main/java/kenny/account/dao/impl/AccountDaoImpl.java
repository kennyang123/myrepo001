package kenny.account.dao.impl;

import kenny.account.dao.IAccountDao;
import kenny.account.domain.Account;
import kenny.account.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * @author 杨小平
 * @date 2020/9/26 6:24
 * @description TODO
 */
public class AccountDaoImpl implements IAccountDao {
    QueryRunner runner;
    ConnectionUtils connectionUtils;

    public void setRunner(QueryRunner runner) {
        this.runner = runner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void save(Account account) {
        try {
            runner.update(connectionUtils.getConnection(),"insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void update(Account account) {
        try {
            runner.update(connectionUtils.getConnection(),"update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void delete(Integer accountId) {
        try {
            runner.update(connectionUtils.getConnection(),"delete from account where id=?",accountId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findById(Integer accountId) {
        try {
            Account account =runner.query(connectionUtils.getConnection(),"select * from account where id=?",new BeanHandler<Account>(Account.class),accountId);
            return account;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public List<Account> findAll() {
        try {
            List<Account> accounts =runner.query(connectionUtils.getConnection(),"select * from account",new BeanListHandler<Account>(Account.class));
            return accounts;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findByName(String accountName) {
        try {
            List<Account> accounts =runner.query(connectionUtils.getConnection(),"select * from account where name=?",new BeanListHandler<Account>(Account.class),accountName);
            if(accounts==null){
                return null;
            }
            if(accounts.size()>1){
                return null;
            }
            return accounts.get(0);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}