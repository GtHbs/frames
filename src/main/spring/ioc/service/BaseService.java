package spring.ioc.service;

import org.springframework.beans.factory.annotation.Autowired;
import spring.ioc.dao.BaseDao;

public abstract class BaseService<T> {

    @Autowired
    BaseDao<T> dao;

    public void save() {
        dao.save();
    }
}
