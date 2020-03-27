package mybatis.mapper;

import mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * dao接口
 *
 * @author 李昭
 */
public interface EmployeeMapper {

    Employee getEmpById(Integer id);

    /**
     * 对于根据多个字段查询
     * 1,#{}参数使用{0},{1}...来填充
     * 2,在方法参数上加入param注解,指定参数名
     * 3,使用map封装
     *
     * @param id
     * @param name
     * @return
     */
    Employee getEmpByIdAndName(@Param("id") Integer id, @Param("lastName") String name);

    Employee getEmpByMap(Map<String, Object> map);

    Employee getEmpByList(List<Integer> list);

    Long addEmp(Employee employee);

    boolean updateEmp(Employee employee);

    Long delete(int id);

    List<Employee> getEmployees();
}
