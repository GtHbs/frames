package mybatis.test;

import mybatis.bean.Employee;
import mybatis.mapper.EmployeeMapper;
import mybatis.utils.ResourceClose;
import mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李昭
 */
public class Test01 {


    @Test
    public void test02() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee emp = mapper.getEmpById(1);
        System.out.println(emp);
        ResourceClose.close(session);
    }


    @Test
    public void testInsert() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        Employee employee = new Employee("李洁", '0', "lj@qq.com");
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        mapper.addEmp(employee);
        System.out.println(employee);
        session.commit();
    }

    @Test
    public void testUpdate() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        Employee employee = new Employee(1, "李洁2", '0', "lj2@qq.com");
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        mapper.updateEmp(employee);
        session.commit();
    }

    @Test
    public void testDelete() {
        //默认的SQL session不会自动提交
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        mapper.delete(1);
        session.commit();
    }

    @Test
    public void testSelect() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession(true);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmpByIdAndName(2, "李洁");
        System.out.println(employee);
    }

    @Test
    public void testSelectMap() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession(true);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("id", 2);
        map.put("lastName", "李洁");
        Employee empByMap = mapper.getEmpByMap(map);
        System.out.println(empByMap);
    }

    @Test
    public void testSelectList() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession(true);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(1);
        Employee empByList = mapper.getEmpByList(list);
        System.out.println(empByList);
    }

    @Test
    public void test04() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession(true);
        EmployeeMapper mapper = session.getMapper(EmployeeMapper.class);
        Employee employee = new Employee(1, "李洁2", '0', null);
        Long emp = mapper.addEmp(employee);
        System.out.println(emp);
    }
}
