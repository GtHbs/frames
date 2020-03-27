package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import springMVC.bean.Department;
import springMVC.bean.Employee;
import springMVC.dao.DepartmentDao;
import springMVC.dao.EmployeeDao;

import javax.validation.Valid;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 李昭
 */
@SuppressWarnings("all")
@RequestMapping("/crud")
@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;


    @RequestMapping("/add")
    public String add(Model model) {
        Collection<Department> all = departmentDao.getAll();
        model.addAttribute("departments",all);
        model.addAttribute("employee",new Employee());
        return "add";
    }

    @RequestMapping("/edit/{id}")
    public String edit(@PathVariable("id") Integer id,Model model) {
        Employee employee = employeeDao.get(id);
        model.addAttribute("employee",employee);
        return "edit";
    }

    @RequestMapping(value = "/employee",method = RequestMethod.POST)
    public String addEmployee(@Valid Employee employee, BindingResult result,Model model) {
        if (result.hasErrors()) {
            List<FieldError> errors = result.getFieldErrors();
            Map<String,Object> map = new HashMap<>();
            for (FieldError error : errors) {
                map.put(error.getField(),error.getDefaultMessage());
            }
            model.addAttribute("errors",map);
            return "add";
        } else {
            employeeDao.save(employee);
            return "redirect:/crud/employee";
        }
    }

    @RequestMapping(value = "/employee",method = RequestMethod.GET)
    public String employees(Model model) {
        Collection<Employee> all = employeeDao.getAll();
        model.addAttribute("emps",all);
        return "list";
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.PUT)
    public String editEmployee(@ModelAttribute("employee") Employee employee) {
        employeeDao.save(employee);
        return "redirect:/crud/employee";
    }

    @ModelAttribute
    public void getEmp(@RequestParam(value = "id",required = false)Integer id, Model model) {
        if (id != null) {
            Employee employee = employeeDao.get(id);
            model.addAttribute("employee",employee);
        }
        model.addAttribute("departments",departmentDao.getAll());
    }

    @RequestMapping(value = "/employee/{id}",method = RequestMethod.DELETE)
    public String delete(@PathVariable("id")Integer id) {
        employeeDao.delete(id);
        return "redirect:/crud/employee";
    }


}
