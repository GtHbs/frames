package mybatis.test;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import mybatis.bean.Employee;
import mybatis.mapper.EmployeeMapper;
import mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @Author: 李昭
 * @Date: 2020/3/14 20:17
 */
public class Test06 {

    @Test
    public void test() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession(true);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        PageHelper.startPage(1,3);
        List<Employee> employees = mapper.getEmployees();
        PageInfo<Employee> pageInfo = new PageInfo<>(employees);
        System.out.println(pageInfo);
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
