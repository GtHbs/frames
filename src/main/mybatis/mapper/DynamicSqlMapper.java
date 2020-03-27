package mybatis.mapper;

import mybatis.bean.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface DynamicSqlMapper {

    List<Employee> getEmpByConditions(Employee employee);

    List<Employee> getEmpByConditionTrim(Employee employee);

    List<Employee> getEmpByConditionChoose(Employee employee);

    void updateEmp(Employee employee);

    List<Employee> getEmpByConditionIn(@Param("ids") List<Integer> ids);

    void batchInsert(@Param("employees") List<Employee> employees);

    List<Employee> testInnerParameter(Employee employee);
}
