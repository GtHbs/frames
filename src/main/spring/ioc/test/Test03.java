package spring.ioc.test;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import spring.ioc.controller.Controller;
import spring.ioc.bean.Person;
import spring.ioc.utils.ApplicationContextUtils;

public class Test03 {
    private final String SOURCE_PATH = "spring/ioc/config/spring-ioc3.xml";
    ConfigurableApplicationContext context = (ConfigurableApplicationContext) ApplicationContextUtils.getClassPathXmlApplicationContext(SOURCE_PATH);

    @Test
    public void testAutoWired() {
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }
    @Test
    public void testSPEL() {
        Object bean = context.getBean("spelPerson");
        System.out.println(bean);
    }

    @Test
    public void testAnnotation() {
        Controller controller = (Controller) context.getBean("first");
        Controller controller2 = (Controller) context.getBean("first");
        System.out.println(controller == controller2);
        Object dao = context.getBean("dao");
        System.out.println(dao);
//        Object service = context.getBean("service");
//        System.out.println(service);
    }
}
