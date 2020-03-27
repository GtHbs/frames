package spring.ioc.test;

import org.junit.Test;
import org.springframework.context.ConfigurableApplicationContext;
import spring.ioc.service.BookService;
import spring.ioc.service.UserService;
import spring.ioc.utils.ApplicationContextUtils;

public class Test05 {
    private final String SOURCE_PATH = "spring/ioc/config/spring-ioc4.xml";
    ConfigurableApplicationContext context = (ConfigurableApplicationContext) ApplicationContextUtils.getClassPathXmlApplicationContext(SOURCE_PATH);

    @Test
    public void test01() {
        BookService bookService = (BookService) context.getBean("bookService");
        UserService userService = (UserService) context.getBean("userService");
        bookService.save();
        userService.save();
        /**
         * class spring.ioc.service.BookService
         */
        System.out.println(bookService.getClass());
        /**
         * spring.ioc.service.BaseService<spring.ioc.bean.Book>
         */
        System.out.println(bookService.getClass().getGenericSuperclass());
    }
}
