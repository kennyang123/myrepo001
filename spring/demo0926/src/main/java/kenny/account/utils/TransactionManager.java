package kenny.account.utils;

import java.sql.SQLException;

/**
 * @author 杨小平
 * @date 2020/9/26 16:11
 * @description TODO
 */
public class TransactionManager {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void beginTransaction(){
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void commit(){
        try {
            connectionUtils.getConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void rollback(){
        try {
            connectionUtils.getConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void release(){
        try {
            connectionUtils.getConnection().close();
            connectionUtils.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}