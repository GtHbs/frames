package mybatis.test;

import mybatis.bean.Department;
import mybatis.bean.Employee;
import mybatis.mapper.CacheMapper;
import mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author 李昭
 */
public class Test04 {

    /**
     * 两级缓存
     *      1,本地缓存:与数据库同一次会话查询到的数据会放在本地缓存中
     *                 也成为sqlSession级别的缓存,一直是开启的
     *                 失效情况:
     *                      (1)sqlSession不同
     *                      (2)sqlSession相同但是查询条件不同
     *                      (3)在上次查询之后进行增删改操作
     *                      (4)手动清除缓存
     *      2,全局缓存:基于namespace的缓存,一个mapper文件对应一个缓存
     *                工作机制:一级缓存查询到的内容在一级缓存关闭之后会被放在二级缓存
     *                步骤:
     *                     (1)开启全部缓存cacheEnabled=true
     *                     (2)在mapper文件中配置使用二级缓存<cache></cache>
     *                     (3)使用二级缓存的对象需要实现序列化接口
     */
    @Test
    public void test01() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        CacheMapper mapper = session.getMapper(CacheMapper.class);
        Employee employee = mapper.getEmpById(1);
        /**
         * 中间插入一次后会消除上次查询的缓存
         */
//        Employee employee2 = new Employee(null,"aaa",'1',"aaa",null);
//        mapper.insertEmployee(employee2);
        session.clearCache();       //清除缓存,只会清除一级缓存
        Employee employee1 = mapper.getEmpById(1);      //第二此查询是从缓存中直接拿的数据
        System.out.println(employee == employee1);  //true
        session.commit();
//        SqlSession session1 = SqlSessionFactoryUtils.getInstance().openSession();
//        CacheMapper mapper1 = session1.getMapper(CacheMapper.class);
//        Employee employee2 = mapper1.getEmpById(1);
//        System.out.println(employee2 == employee1);
//        Employee employee2 = mapper.getEmpById(2);
//        System.out.println(employee1 == employee2);
    }

    @Test
    public void cache() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        CacheMapper mapper = session.getMapper(CacheMapper.class);
        Employee employee = mapper.getEmpById(2);
        session.clearCache();
        Employee employee1 = mapper.getEmpById(2);
        System.out.println(employee == employee1);
    }


    @Test
    public void testCacheTwo() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        CacheMapper mapper = session.getMapper(CacheMapper.class);
        Employee employee = mapper.getEmpById(2);
//        session.commit();
        session.close();
        SqlSession session2 = SqlSessionFactoryUtils.getInstance().openSession();
        CacheMapper mapper2 = session2.getMapper(CacheMapper.class);
        Employee employee2 = mapper2.getEmpById(2);
        System.out.println(employee == employee2);
    }
}
