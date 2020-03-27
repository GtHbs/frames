package mybatis.mapper;

import mybatis.bean.Employee;

public interface CacheMapper {

    Employee getEmpById(Integer id);
    void insertEmployee(Employee employee);
}


