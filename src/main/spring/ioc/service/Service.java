package spring.ioc.service;


import org.springframework.beans.factory.annotation.Autowired;
import spring.ioc.dao.Dao;

/**
 * @author 李昭
 */
@org.springframework.stereotype.Service
public class Service {

    @Autowired
    private Dao dao;

    public void get() {
        System.out.println("service");
        dao.save();
    }
}
