package spring.ioc.factory;

import org.springframework.beans.factory.FactoryBean;
import spring.ioc.bean.Book;

/**
 * 实现了FactoryBean接口的类,Spring会自动为其创建实例
 * 在使用实现了FactoryBean接口生成组件时只有获取时才会创建,在ioc容器初始化时不会创建组件
 * 无论是单例还是原型
 */
public class FactoryBeanImpl implements FactoryBean<Book> {

    /**
     * 工厂
     *
     * @return
     * @throws Exception
     */
    @Override
    public Book getObject() throws Exception {
        Book book = new Book("Effective Java","kkk");
        System.out.println("Spring创建实例对象....");
        return book;
    }

    @Override
    public Class<?> getObjectType() {
        return Book.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
