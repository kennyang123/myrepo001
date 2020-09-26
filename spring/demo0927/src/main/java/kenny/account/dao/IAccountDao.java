package kenny.account.dao;

import kenny.account.domain.Account;

import java.util.List;

/**
 * @author 杨小平
 * @date 2020/9/26 6:22
 * @description TODO
 */
public interface IAccountDao {
    void save(Account account);

    void update(Account account);

    void delete(Integer accountId);

    Account findById(Integer accountId);

    List<Account> findAll();

    Account findByName(String source);
}
