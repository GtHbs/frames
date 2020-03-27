package mybatis.mapper;

import mybatis.bean.Department;

public interface DepartmentMapper {
    Department getDeptById(Integer id);

    Department getAllEmpAndDept(Integer id);

    Department getAllEmpByAssociation(Integer id);
}
