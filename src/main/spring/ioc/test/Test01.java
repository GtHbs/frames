package spring.ioc.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import spring.ioc.bean.Car;
import spring.ioc.bean.Person;
import spring.ioc.utils.ApplicationContextUtils;

public class Test01 {

    private final String SOURCE_PATH = "spring/ioc/config/spring-ioc.xml";
    private ApplicationContext context = ApplicationContextUtils.getClassPathXmlApplicationContext(SOURCE_PATH);

    @Test
    public void getBeanById() {
        /**
         * applicationContext表示为ioc容器
         * 当前配置文件在类路径下,类路径开始为src
         */
        //根据组件的id获取对象
        Person person = (Person) context.getBean("person");
        System.out.println(person);
    }

    @Test
    public void getBeanByClassName() {
        Person person = context.getBean(Person.class);
        //也可以使用id和class一起获取组件
        Person bean = context.getBean("person", Person.class);
        System.out.println(person);
        System.out.println(bean == person);
    }

    @Test
    public void createBeanByConstructor() {
        Person dsx = (Person) context.getBean("dsx");
        System.out.println(dsx);
    }

    @Test
    public void createBeanByConstructorIndex() {
        Object alone = context.getBean("alone");
        System.out.println(alone);
    }

    @Test
    public void createBeanByPLabel() {
        Object lj = context.getBean("lj");
        System.out.println(lj);
    }

    @Test
    public void testParameter() {
        Object o = context.getBean("testParameter");
        System.out.println(o);
    }

    @Test
    public void testUtilCollection() {
        Person lr = (Person) context.getBean("lr");
        System.out.println(lr.getMaps());
    }

    @Test
    public void testParametersParam() {
        Person ouYang = (Person) context.getBean("ouYang");
        Car car = (Car) context.getBean("car");
        System.out.println(ouYang.getCar());
        System.out.println(car.getPrice());
    }
}
