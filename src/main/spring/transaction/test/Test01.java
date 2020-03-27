package spring.transaction.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import spring.transaction.bean.Employee;
import spring.transaction.dao.EmployeeDao;

import java.util.*;

/**
 * @author 李昭
 */
public class Test01 {

    ApplicationContext context = new ClassPathXmlApplicationContext("spring/transaction/config/context.xml");
    private JdbcTemplate template = context.getBean(JdbcTemplate.class);
    NamedParameterJdbcTemplate jdbcTemplate = context.getBean(NamedParameterJdbcTemplate.class);
    private EmployeeDao dao;

    @Test
    public void update() {
        String sql = "update employee set salary = ? where id = ?";
        int update = template.update(sql, 222.2, 1);
        System.out.println(update);
    }

    @Test
    public void batchInsert() {
        String sql = "insert into employee (name,salary) values(?,?)";
        //批量插入,list的长度就是插入条数
        List<Object[]> args = new ArrayList<>();
        args.add(new Object[]{"s",12.1});
        args.add(new Object[]{"e",22.1});
        args.add(new Object[]{"f",32.1});
        args.add(new Object[]{"2",42.1});
        args.add(new Object[]{"h",52.1});
        int[] ints = template.batchUpdate(sql, args);
        System.out.println(Arrays.asList(ints));
    }

    @Test
    public void select() {
       String sql = "select * from employee where id = ?";
        Employee employee = template.queryForObject(sql, new BeanPropertyRowMapper<>(Employee.class), 1);
        System.out.println(employee);
    }
    @Test
    public void selectList() {
        String sql = "select * from employee where salary > ?";
        List<Employee> list = template.query(sql, new BeanPropertyRowMapper<>(Employee.class), 20);
        System.out.println(list);
    }

    @Test
    public void selectMaxSalary() {
        String sql = "select max(salary) from employee";
        Double query = template.queryForObject(sql, Double.class);
        System.out.println(query);
    }

    @Test
    public void insertMap() {
        //使用具名参数
        String sql = "insert into employee(name,salary) values(:name,:salary)";
        Map<String,Object> map = new TreeMap<>();
        map.put("name","sss");
        map.put("salary",2678);
        int update = jdbcTemplate.update(sql, map);
        System.out.println(update);
    }

    @Test
    public void sqlMap() {
        String sql = "insert into employee(name,salary) values(:name,:salary)";
        Employee employee = new Employee("alone",299.2);
        int update = jdbcTemplate.update(sql, new BeanPropertySqlParameterSource(employee));
        System.out.println(update);
    }

    
}
