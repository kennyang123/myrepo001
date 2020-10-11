package kenny.account.domain;

import java.util.List;

/**
 * @author 杨小平
 * @date 2020/9/30 5:46
 * @description TODO
 */
public class User {
    private String userName;
    private int age;
    private List<Account> accountList;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    @Override
    public String toString() {
        return "User{" +
                "userName='" + userName + '\'' +
                ", age=" + age +
                ", accountList=" + accountList +
                '}';
    }
}