package kenny.account.service;

import kenny.account.domain.Account;

import java.util.List;

/**
 * @author 杨小平
 * @date 2020/9/26 6:10
 * @description TODO
 */
public interface IAccountService {
    void saveAccount(Account account);
    void updateAccount(Account account);
    void deleteAccountById(Integer accountId);
    Account findAccountById(Integer accountId);
    List<Account> findAllAccount();
    void transfer(String source,String dest,Float money);
}
