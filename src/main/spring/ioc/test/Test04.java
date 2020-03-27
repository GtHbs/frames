package spring.ioc.test;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import spring.ioc.utils.ApplicationContextUtils;

import java.sql.SQLException;

public class Test04 {
    private final String SOURCE_PATH = "spring/ioc/config/spring-ioc4.xml";
    ConfigurableApplicationContext context = (ConfigurableApplicationContext) ApplicationContextUtils.getClassPathXmlApplicationContext(SOURCE_PATH);
    @Test
    public void test() throws SQLException {
        //Controller controller = (Controller) context.getBean("controller");
    }
    @Test
    public void test02() {
//        Object car = context.getBean("car");
//        System.out.println(car);
    }
}
