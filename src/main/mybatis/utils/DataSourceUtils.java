package mybatis.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.apache.commons.dbcp.BasicDataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 获取数据源
 *
 * @author 李昭
 */
public class DataSourceUtils {

    public static void main(String[] args) {
        DataSource dataSource = DBCPDataSource();
        System.out.println(dataSource);
    }

    private volatile static DataSource instance;

    /**
     * Alibaba druid数据源
     *
     * @return
     */
    public static DataSource druidDataSource() {
        if (instance != null) {
            return instance;
        }
        synchronized (DataSource.class) {
            if (instance == null) {
                Properties properties = new Properties();
                try {
                    properties.load(Thread.currentThread().getContextClassLoader().
                            getResourceAsStream("mybatis/config/dbcp.properties"));
                    instance = DruidDataSourceFactory.createDataSource(properties);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return instance;
    }

    public static DataSource DBCPDataSource() {
        if (instance != null) {
            return instance;
        }
        synchronized (DataSource.class) {
            Properties properties = new Properties();
            try {
                properties.load(Thread.currentThread().getContextClassLoader().
                        getResourceAsStream("spring/config/dbcp.properties"));
                instance = BasicDataSourceFactory.createDataSource(properties);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return instance;
    }
}
