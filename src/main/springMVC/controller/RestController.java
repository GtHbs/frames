package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author
 */
@Controller
public class RestController {

    @RequestMapping(value = "/book/{id}",method = RequestMethod.GET)
    public String getBook(@PathVariable("id")String id) {
        System.out.println("查询"+id);
        return "success";
    }

    @RequestMapping(value = "/book",method = RequestMethod.POST)
    public String addBook() {
        System.out.println("添加");
        return "success";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.DELETE)
    public String deleteBook(@PathVariable("id") String id) {
        System.out.println("删除"+id);
        return "success";
    }

    @RequestMapping(value = "/book/{id}",method = RequestMethod.PUT)
    public String update(@PathVariable("id")String id) {
        System.out.println("更新"+id);
        return "success";
    }

}
