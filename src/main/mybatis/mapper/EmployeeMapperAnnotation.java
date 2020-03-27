package mybatis.mapper;


import mybatis.bean.Employee;
import org.apache.ibatis.annotations.Select;

public interface EmployeeMapperAnnotation {
    @Select("select * from employee where id = #{id}")
    Employee getEmpById(int id);
}
