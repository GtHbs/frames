package mybatis.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取会话工厂
 *
 * @author 李昭
 */
public class SqlSessionFactoryUtils {

    private static volatile SqlSessionFactory instance;

    private SqlSessionFactoryUtils() {}

    public static SqlSessionFactory getInstance() {
        if (instance != null) {
            return instance;
        }
        synchronized (SqlSessionFactory.class) {
            if (instance == null) {
                String resource = "mybatis/config/mybatis-config.xml";
                try {
                    InputStream stream = Resources.getResourceAsStream(resource);
                    instance = new SqlSessionFactoryBuilder().build(stream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }

}
