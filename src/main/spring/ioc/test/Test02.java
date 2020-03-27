package spring.ioc.test;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import spring.ioc.bean.Airplane;
import spring.ioc.bean.Person;
import spring.ioc.utils.ApplicationContextUtils;

import javax.sql.DataSource;
//import java.time.Period;

public class Test02 {
    private final String SOURCE_PATH = "spring/ioc/config/spring-ioc2.xml";
    ConfigurableApplicationContext context = (ConfigurableApplicationContext) ApplicationContextUtils.getClassPathXmlApplicationContext(SOURCE_PATH);

    @Test
    public void testExtends() {
        Person person = (Person) context.getBean("parentPerson");
        System.out.println(person);
    }

    @Test
    public void testScope() {
       // Person scope = (Person) context.getBean("testBeanScope");
       // Person scope2 = (Person) context.getBean("testBeanScope");

    }

    @Test
    public void testStaticFactory() {
        Airplane airplane = (Airplane) context.getBean("staticFactory");
        System.out.println(airplane);
    }

    @Test
    public void testInstanceFactory() {
        //该组件实例是实例工厂创建出来的,并非使用反射创建
        Airplane airplane = (Airplane) context.getBean("airplane");
        System.out.println(airplane);
    }

    @Test
    public void testFactoryBean() {
        Object bean = context.getBean("factoryBean");
        System.out.println(bean);
    }

    /**
     * 对于单实例,在容器创建时调用init方法,在容器关闭时调用destroy方法
     * 对于多实例,在创建组件的时候调用init方法,不会调用destroy方法
     *
     * book将要初始化了...Book{bookName='null', author='null'}    前置处理器
     * init
     * book已被销毁Book{bookName='null', author='null'}
     * Book{bookName='null', author='null'}                      后置处理器
     * destroy
     * 无论是否有初始化方法,后置处理器都会默认其有
     */
    @Test
    public void testLifecycle() {
        Object book = context.getBean("book");
        System.out.println(book);
        context.close();
    }

    @Test
    public void getDataSource() {
        Object source = context.getBean("dataSource");
        System.out.println(source);
    }

    @Test
    public void getDruidDataSource() {
        DataSource bean = (DataSource) context.getBean("dataSource");
        System.out.println(bean);
    }
}
