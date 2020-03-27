package mybatis.test;

import mybatis.bean.Department;
import mybatis.bean.Employee;
import mybatis.mapper.DepartmentMapper;
import mybatis.mapper.EmployeesMapper;
import mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

/**
 * @author 李昭
 */
public class Test02 {

    @Test
    public void test01() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession(true);
        EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
        /**
         * 模糊查询一定要在代码内进行字符串匹配
         */
        List<Employee> employees = mapper.getEmpByLikeName("%李%");
        System.out.println(employees);
    }

    @Test
    public void test02() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
        Map<String, Object> map = mapper.getEmpMatchToMap(2);
        System.out.println(map);
    }
    @Test
    public void test03() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
        Map<Integer, Employee> map = mapper.getEmpByLastNameLike("%李%");
        System.out.println(map);
    }

    @Test
    public void test04() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
        Employee empById = mapper.getEmpById(1);
        System.out.println(empById);
    }

    @Test
    public void test05() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
        Employee employee = mapper.getEmpAndDept(2);
        System.out.println(employee);
    }
    @Test
    public void test06() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department dept = mapper.getDeptById(2);
        System.out.println(dept);
    }

    @Test
    public void test07() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        EmployeesMapper mapper = session.getMapper(EmployeesMapper.class);
        Employee employee = mapper.getEmpByIdStep(2);
        System.out.println(employee.getDepartment());
    }

    @Test
    public void test08() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department dept = mapper.getAllEmpAndDept(1);
        System.out.println(dept);
    }

    @Test
    public void test09() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        DepartmentMapper mapper = session.getMapper(DepartmentMapper.class);
        Department dept = mapper.getAllEmpByAssociation(1);
        System.out.println(dept);
    }
}
