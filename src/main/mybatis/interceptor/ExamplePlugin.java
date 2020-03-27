package mybatis.interceptor;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 自定义实现插件
 *
 * @author: 李昭
 * @Date: 2020/3/22 15:58
 */
@Intercepts(@Signature(type = Executor.class, method = "update", args = {MappedStatement.class, Object.class}))
public class ExamplePlugin implements Interceptor {

    @Override
    public Object intercept(Invocation invocation) throws Throwable {
        /**
         * 被代理对象
         */
        Object target = invocation.getTarget();
        /**
         * 被代理方法
         */
        Method method = invocation.getMethod();
        /**
         * 参数
         */
        Object[] args = invocation.getArgs();
        /**
         * 方法拦截前执行
         */
        Object proceed = invocation.proceed();
        return proceed;
    }

    @Override
    public Object plugin(Object target) {
        return Plugin.wrap(target, this);
    }

    @Override
    public void setProperties(Properties properties) {

    }
}
