package kenny.account.dao.impl;

import kenny.account.dao.IAccountDao;
import kenny.account.domain.Account;
import org.springframework.jdbc.core.*;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author 杨小平
 * @date 2020/9/26 6:24
 * @description TODO
 */
@Repository(value = "accountDao")
public class AccountDaoImpl implements IAccountDao {
    @Resource(name="jdbcTemplate")
    JdbcTemplate jdbcTemplate;

    public void save(Account account) {
        jdbcTemplate.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
    }

    public void update(Account account) {
        jdbcTemplate.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
    }

    public void delete(Integer accountId) {
        jdbcTemplate.update("delete from account where id=?",accountId);
    }

    public Account findById(Integer accountId) {
        List<Account> accounts = jdbcTemplate.query("select * from account where id=?",new BeanPropertyRowMapper<Account>(Account.class),accountId);
        return accounts.isEmpty()?null:accounts.get(0);
    }

    public List<Account> findAll() {
        return jdbcTemplate.query("select * from account",new BeanPropertyRowMapper<Account>(Account.class));
    }

    public Account findByName(String accountName) {
        List<Account> accounts = jdbcTemplate.query("select * from account where name=?",new BeanPropertyRowMapper<Account>(Account.class),accountName);
        if(accounts.isEmpty()) {return null;}
        if(accounts.size()>1){throw  new RuntimeException("结果集不唯一");}
        return accounts.get(0);
    }
}