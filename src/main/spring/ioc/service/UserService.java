package spring.ioc.service;

import org.springframework.stereotype.Service;
import spring.ioc.bean.User;

/**
 * 泛型依赖注入
 *      实现类继承的抽象类会指定泛型类型,在抽象类中有指定的抽象dao根据实现类指定的泛型类型进行注入
 *   userService extends baseService<user> --> baseService<user> --> baseDao<user>进行注入
 */
@Service
public class UserService extends BaseService<User> {
}
