package kenny.account.utils;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;

/**
 * @author 杨小平
 * @date 2020/9/26 6:28
 * @description TODO
 */
@Component(value="connectionUtils")
public class ConnectionUtils {
    private ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
    @Resource(name="dataSource")
    private DataSource dataSource;

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