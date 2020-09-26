package kenny.account.utils;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author 杨小平
 * @date 2020/9/26 16:11
 * @description TODO
 */
@Component(value = "transactionManager")
@Aspect
@EnableAspectJAutoProxy
public class TransactionManager {
    @Resource(name = "connectionUtils")
    private ConnectionUtils connectionUtils;

    @Pointcut("execution(* kenny.account.service.impl.AccountServiceImpl.*(..))")
    private void pt1(){};

    @Before("pt1()")
    public void beginTransaction(){
        try {
            connectionUtils.getConnection().setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @AfterReturning("pt1()")
    public void commit(){
        try {
            connectionUtils.getConnection().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @AfterThrowing("pt1()")
    public void rollback(){
        try {
            connectionUtils.getConnection().rollback();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @After("pt1()")
    public void release(){
        try {
            connectionUtils.getConnection().close();
            connectionUtils.removeConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   // @Around("pt1()")
    public Object around(ProceedingJoinPoint pjp) throws Exception {
        Object rtValue=null;
        Object[] parms = pjp.getArgs();
        try {
            connectionUtils.getConnection().setAutoCommit(false);
            rtValue= pjp.proceed(parms);
            connectionUtils.getConnection().commit();
            return rtValue;
        } catch (Throwable e) {
            connectionUtils.getConnection().rollback();
        }finally {
            connectionUtils.getConnection().close();
            connectionUtils.removeConnection();
        }
        return  null;
    }
}