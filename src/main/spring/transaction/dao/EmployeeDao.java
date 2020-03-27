package spring.transaction.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import spring.transaction.bean.Employee;

/**
 * @author 李昭
 */
public class EmployeeDao {

    @Qualifier("template")
    @Autowired
    JdbcTemplate jdbcTemplate;

    public void save(Employee employee) {
        String sql = "insert into employee(name,salary) values(?,?)";
        jdbcTemplate.update(sql,employee.getName(),employee.getSalary());
    }
}
