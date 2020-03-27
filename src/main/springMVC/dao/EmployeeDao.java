package springMVC.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import springMVC.bean.Department;
import springMVC.bean.Employee;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李昭
 */
@SuppressWarnings("all")
@Repository
public class EmployeeDao {

    private static Map<Integer, Employee> map = null;
    static {
        map = new HashMap<>();
        map.put(101,new Employee("a",101,"a@qq.com",1,new Date(),new Department("A",1)));
        map.put(102,new Employee("b",102,"b@qq.com",0,new Date(),new Department("B",2)));
        map.put(103,new Employee("c",103,"c@qq.com",1,new Date(),new Department("A",1)));
        map.put(104,new Employee("d",104,"d@qq.com",0,new Date(),new Department("B",2)));
        map.put(105,new Employee("e",105,"e@qq.com",1,new Date(),new Department("A",1)));
    }

    @Autowired
    private DepartmentDao departmentDao;

    private static Integer initId = 106;
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartment(employee.getDepartment().getId()));
        map.put(employee.getId(),employee);
    }

    public Collection<Employee> getAll() {
        return map.values();
    }
    public Employee get(Integer id) {
        return map.get(id);
    }
    public void delete(Integer id) {
        if (map.containsKey(id)) {
            map.remove(id);
        }
    }
}
