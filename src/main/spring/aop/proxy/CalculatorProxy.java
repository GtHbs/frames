package spring.aop.proxy;

import spring.aop.bean.Calculator;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

@SuppressWarnings("all")
public class CalculatorProxy {

    public Calculator proxy(final Calculator calculator) {
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                Object invoke = null;
                try {
                    //LogUtils.logStart(method, args);
                    invoke = method.invoke(calculator, args);
                    System.out.println(method.getName() + "方法执行结果为:" + invoke);
                    //LogUtils.logEnd(method, invoke);
                } catch (Exception e) {
                    //LogUtils.logError(method, e);
                } finally {
                    //LogUtils.success(method);
                }
                return invoke;
            }
        };
        ClassLoader classLoader = calculator.getClass().getClassLoader();
        //之所以能产生动态代理,是因为代理对象和被代理对象都实现了同一接口
        Class<?>[] interfaces = calculator.getClass().getInterfaces();
        return (Calculator) Proxy.newProxyInstance(classLoader, interfaces, handler);
    }


}
