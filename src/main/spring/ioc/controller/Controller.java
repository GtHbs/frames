package spring.ioc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import spring.ioc.dao.Dao;
import spring.ioc.service.Service;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author 李昭
 */
@SuppressWarnings("all")
@org.springframework.stereotype.Controller
@Scope("prototype")
public class Controller {

    /**
     * 使用@AutoWired注解,spring会自动将该属性装配
     * 原理:
     * 先按照类型在容器中寻找组件
     * (1),寻找到了且为一个直接装配
     * (2),没有找到抛出异常
     * (3),找到多个
     * 1),按照变量名作为id继续匹配
     * ①,如果找到多个与变量名匹配的组件,会抛出异常
     * ②,找到一个进行匹配
     * ③找到多个抛出异常
     * 2),没有找到与变量名匹配的组件直接抛出异常
     * AutoWired一定要装配上
     *
     * @AutoWired和@Resource的区别:前者更为强大为spring的注解,后者扩展性强,为jdk的注解
     */
    @Qualifier("service")
    @Autowired(required = false)
    private Service service;

    public void get() {
        service.get();
    }

    @Autowired
    private DataSource dataSource;

    public void testConnection() throws SQLException {
        System.out.println(dataSource.getConnection());
    }

    /**
     * 在方法上加入注解,方法的参数都会注入值
     * 只要类加载到容器中,被AutoWired标注的属性和方法都会实例化
     *
     * @param dao
     */
    @Autowired
    public void test(Dao dao, @Qualifier("serviceExtend") Service service) {
        System.out.println("method:");
        //dao.save();
    }
}
