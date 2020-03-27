package spring.transaction.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.ioc.bean.Book;
import spring.transaction.service.BookService;
import spring.transaction.service.MultiService;

import java.io.FileNotFoundException;

/**
 * @author 李昭
 */
public class Test02 {


    ApplicationContext context =
            new ClassPathXmlApplicationContext("spring/transaction/config/context.xml");

    BookService service = context.getBean(BookService.class);
    MultiService multiService = context.getBean(MultiService.class);
    @Test
    public void test01() throws FileNotFoundException {
        //service.checkOut("alone","001");
        //class spring.transaction.service.BookService$$EnhancerBySpringCGLIB$$c4e8b604
        System.out.println(service.getClass());
    }

    @Test
    public void test02() {
        service.mutil();
    }
}
