package kenny.account.utils;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author 杨小平
 * @date 2020/9/26 6:28
 * @description TODO
 */
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Connection getConnection(){
        try{
            Connection connection = tl.get();
            if(connection==null){
                connection = dataSource.getConnection();
                tl.set(connection);
            }
            return  connection;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public void removeConnection(){
        tl.remove();
    }
}