package spring.transaction.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import spring.transaction.dao.BookDao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author 李昭
 */
@SuppressWarnings("all")
@Service("bookService")
public class BookService {

    @Autowired
    private BookDao bookDao;

    /**
     * 事务细节
     * 1,isolation
     * 2,noRollBackFor={ArithmeticException.class}:可以让原来回滚的异常不回滚
     * 3,noRollBackForClassName={"java.lang.ArithmeticException"}
     * 4,Propagation:事务的传播行为
     * (1)required:如果有事务在运行,当前方法就在此事务中运行,否则就创建一个新的事务
     * (2)required_new:如果有事务正在运行,就将其挂起,重启一个事务
     * 5,rollBackFor={"FileNotFoundException"}:可以让原来不回滚的异常回滚
     * 6,rollBackForClassName
     * 7,readOnly-boolean
     * 8,timeout-int(s):超时:事务超过时常后会自动回滚
     *
     * @param name
     * @param isbn
     */
    @Transactional(isolation=Isolation.READ_COMMITTED,timeout = 3, propagation = Propagation.REQUIRES_NEW)
    public void checkOut(String name, String isbn) {
        bookDao.updateStock(isbn, 1);
        /**
         * 运行时异常会回滚
         * 编译时异常不会回滚
         */
//        int i = 10 / 0;
//        new FileInputStream("sss");
        double price = bookDao.getPrice(isbn);
        bookDao.updateBalance(name, price);
    }

    @Transactional(readOnly = true, isolation = Isolation.READ_COMMITTED)
    public double readPrice(String isbn) {
        double price = bookDao.getPrice(isbn);
        return price;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updatePrice(String isbn, double price) {
        bookDao.updatePrice(isbn, price);
//        int i = 10 / 0;
    }

    /**
     * 本类方法调用相当于一个事务,并不会开启多个事务
     * 两个都会回滚
     * proxy.mutil()
     */
    @Transactional
    public void mutil() {
        checkOut("alone", "001");
        updatePrice("001", 200);
        int i = 10 / 0;
    }
}
