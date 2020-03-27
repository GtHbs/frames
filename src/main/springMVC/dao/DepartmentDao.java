package springMVC.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import springMVC.bean.Department;
import springMVC.bean.Employee;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 李昭
 */
@SuppressWarnings("all")
@Repository
public class DepartmentDao {
    private static Map<Integer, Department> map = null;
    static {
        map = new HashMap<>();
        map.put(101,new Department("A",101));
        map.put(102,new Department("B",102));
    }
    @Autowired
    private EmployeeDao employeeDao;

    public Department getDepartment(Integer id) {
        Department department = map.get(id);
        return department;
    }

    public Collection<Department> getAll() {
        return map.values();
    }
    public Department get(Integer id) {
        return map.get(id);
    }
    public void delete(Integer id) {
        map.remove(id);
    }
}
