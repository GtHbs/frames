package springMVC.bean;

/**
 * @author
 */
public class Department {

    private String departmentName;
    private Integer id;

    public Department() {
    }

    public Department(String departmentName, Integer id) {
        this.departmentName = departmentName;
        this.id = id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Department{" +
                "departmentName='" + departmentName + '\'' +
                ", id=" + id +
                '}';
    }
}
