package spring.aop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.aop.bean.Calculate;
import spring.aop.bean.Calculator;

/**
 * @author 李昭
 */
public class Test01 {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring/aop/config/applicationContext.xml");

    /**
     * 使用jdk的动态代理
     */
    @Test
    public void testUseJdkProxy() {
        Calculator contextBean = context.getBean(Calculator.class);
        System.out.println(contextBean.getClass());
        Calculator bean = context.getBean(Calculator.class);
        System.out.println(bean.getClass());
        //使用jdk动态代理时,获取的bean一定要以接口强转
        Calculator calculate = (Calculator) context.getBean("calculate");
        //class com.sun.proxy.$Proxy18
        System.out.println(calculate.getClass());
    }

    /**
     * 使用cglib动态代理时,需要在配置文件中配置proxy-target-class="true"
     */
    @Test
    public void testCglibProxy() {
        Calculate calculate = (Calculate) context.getBean("calculate");
        //class spring.aop.bean.Calculate$$EnhancerBySpringCGLIB$$70461d28
        System.out.println(calculate.getClass());
    }

    @Test
    public void test() {
        Calculator calculate = context.getBean(Calculator.class);
        calculate.div(1,0);
    }

}
