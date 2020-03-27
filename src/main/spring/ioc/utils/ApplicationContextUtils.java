package spring.ioc.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextUtils {
    public static ApplicationContext getClassPathXmlApplicationContext(String path) {
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        return context;
    }
}
