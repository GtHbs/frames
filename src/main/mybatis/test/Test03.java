package mybatis.test;

import mybatis.bean.Department;
import mybatis.bean.Employee;
import mybatis.mapper.DynamicSqlMapper;
import mybatis.utils.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 李昭
 */
public class Test03 {

    @Test
    public void test01() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
        Employee employee = new Employee(null,"%李%",'s',null);
        List<Employee> list = mapper.getEmpByConditions(employee);
        System.out.println(list);
    }

    @Test
    public void test02() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
        Employee employee = new Employee(null,"%李%",'s',null);
        List<Employee> list = mapper.getEmpByConditionTrim(employee);
        System.out.println(list);
    }
    @Test
    public void test03() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
        Employee employee = new Employee(null,"%李%",'s',null);
        List<Employee> list = mapper.getEmpByConditionChoose(employee);
        System.out.println(list);
    }

    @Test
    public void test04() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
        Employee employee = new Employee(3,"alone",'0',"alone@qq.com");
        mapper.updateEmp(employee);
        session.commit();
    }

    @Test
    public void test05() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        list.add(4);
        List<Employee> employees = mapper.getEmpByConditionIn(list);
        System.out.println(employees);
    }

    @Test
    public void testBatchInsert() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(null,"a",'1',"a.qq.com",new Department(1,"策划部")));
        employees.add(new Employee(null,"b",'0',"b.qq.com",new Department(2,"公关部")));
        employees.add(new Employee(null,"c",'1',"c.qq.com",new Department(1,"策划部")));
        employees.add(new Employee(null,"d",'0',"d.qq.com",new Department(2,"公关部")));
        mapper.batchInsert(employees);
        session.commit();
    }

    @Test
    public void testInnerParameter() {
        SqlSession session = SqlSessionFactoryUtils.getInstance().openSession();
        DynamicSqlMapper mapper = session.getMapper(DynamicSqlMapper.class);
        Employee employee = new Employee(null,"a",'1',null);
        List<Employee> employees = mapper.testInnerParameter(employee);
        //employees.forEach(System.out::println);
    }

}
