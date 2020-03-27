package mybatis.mapper;

import mybatis.bean.Employee;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@SuppressWarnings("all")
public interface EmployeesMapper {

    List<Employee> getEmpByLikeName(String name);

    Map<String, Object> getEmpMatchToMap(Integer id);

    @MapKey("lastName") //指定map的key
    Map<Integer, Employee> getEmpByLastNameLike(String name);

    Employee getEmpById(Integer id);

    Employee getEmpAndDept(Integer id);

    Employee getEmpByIdStep(Integer id);

    List<Employee> getAllEmpById(@Param("dept_id") Integer id);


}
