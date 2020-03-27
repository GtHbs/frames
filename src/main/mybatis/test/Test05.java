package mybatis.test;

import mybatis.bean.Employee;
import mybatis.mapper.CacheMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author 李昭
 */
public class Test05 {

    /**
     * mybatis执行过程
     *
     * @throws IOException
     */
    @Test
    public void test01() throws IOException {
        /**
         * 1,根据全局配置文件获取SqlSessionFactory对象
         */
        String source = "mybatis/config/mybatis-config.xml";
        InputStream stream = Resources.getResourceAsStream(source);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(stream);
        /**
         * 2,根据SqlSessionFactory对象获取SqlSession会话对象
         */
        SqlSession session = factory.openSession();
        /**
         * 3,根据SqlSession获取Mapper代理对象
         */
        CacheMapper mapper = session.getMapper(CacheMapper.class);
        /**
         * 4,使用代理对象执行
         *      执行过程:
         *             (1)DefaultSqlSession获取Executor
         *             (2)Executor获取StatementHandler
         *             (3)StatementHandler用ParameterHandler处理参数,用ResultSetHandler处理结果数据
         *             (4)中间的类型转换使用TypeHandler进行处理
         */
        Employee employee = mapper.getEmpById(1);
        System.out.println(employee);
    }

}
