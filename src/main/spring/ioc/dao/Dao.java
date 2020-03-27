package spring.ioc.dao;

import org.springframework.stereotype.Repository;

/**
 * @author 李昭
 */
@Repository
public class Dao {
    public Dao() {
        System.out.println("Dao constructor...");
    }

    public void save() {
        System.out.println("Dao save");
    }
}
