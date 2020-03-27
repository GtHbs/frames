package mybatis.dataSource;

import mybatis.utils.DataSourceUtils;
import org.apache.ibatis.datasource.DataSourceFactory;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * 自定义数据源
 *
 * @author 李昭
 */
public class Druid implements DataSourceFactory {


    @Override
    public void setProperties(Properties props) {

    }

    @Override
    public DataSource getDataSource() {
        return DataSourceUtils.druidDataSource();
    }
}
