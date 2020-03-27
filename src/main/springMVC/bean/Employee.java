package springMVC.bean;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Past;
import java.util.Date;

/**
 * @author
 */
@Component
public class Employee {
    @Length(min = 6,max = 10,message = "名字长度不对")
    @NotEmpty(message = "不能为空")
    private String name;
    private Integer id;
    @Email(message = "邮件格式不正确")
    private String email;

    private Integer gender;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Past
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;
    private Department department;

    public Employee() {
    }

    public Employee(String name, Integer id, String email, Integer gender, Date birth, Department department) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.gender = gender;
        this.birth = birth;
        this.department = department;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Employee(String name, Integer id, String email, Integer gender, Department department) {
        this.name = name;
        this.id = id;
        this.email = email;
        this.gender = gender;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", email='" + email + '\'' +
                ", gender=" + gender +
                ", birth=" + birth +
                ", department=" + department +
                '}';
    }
}
