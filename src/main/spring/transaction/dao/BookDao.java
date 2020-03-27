package spring.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author 李昭
 */
@Repository
public class BookDao {

    @Qualifier("template")
    @Autowired
    JdbcTemplate template;
    /**
     * 减余额
     */
    public void updateBalance(String name,double balance) {
        String sql = "update account set balance = balance - ? where name = ?";
        template.update(sql,balance,name);
    }


    public double getPrice(String isbn) {
        String sql = "select price from book where isbn = ?";
        double price = template.queryForObject(sql, Double.class, isbn);
        return price;
    }


    public void updateStock(String isbn,int count) {
        String sql = "update book_stock set stock = stock - ? where isbn = ?";
        template.update(sql,count,isbn);
    }


    public void updatePrice(String isbn,double price) {
        String sql = "update book set price = ? where isbn = ?";
        template.update(sql,price,isbn);
    }
}
