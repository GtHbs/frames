package spring.ioc.dao;

import org.springframework.stereotype.Repository;
import spring.ioc.bean.Book;

@Repository
public class BookDao extends BaseDao<Book> {

    @Override
    public void save() {
        System.out.println("保存图书");
    }
}
