package spring.ioc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import spring.ioc.dao.Dao;
import spring.ioc.service.Service;

/**
 * @author 李昭
 */
@org.springframework.stereotype.Service
public class ServiceExtend extends Service {
    @Autowired
    private Dao dao;

    @Override
    public void get() {
        System.out.println("service extend get");
    }
}
