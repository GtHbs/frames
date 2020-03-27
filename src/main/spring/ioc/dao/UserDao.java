package spring.ioc.dao;

import org.springframework.stereotype.Repository;
import spring.ioc.bean.User;

@Repository
public class UserDao extends BaseDao<User> {
    @Override
    public void save() {
        System.out.println("保存用户");
    }
}
