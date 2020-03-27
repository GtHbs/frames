package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import springMVC.bean.Book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author
 */
@Controller
public class ParamController {

    /**
     * 默认:要获取url后面的参数,必须和方法形参名称相同
     * 使用@RequestParam注解可以指定后台传参名称相当于request.getParameter();
     *
     * @param username
     * @return
     */
    @RequestMapping("/param")
    public String getParam(@RequestParam("name") String username) {
        System.out.println(username);
        return "success";
    }

    /**
     * 获取请求头数据
     * required:boolean
     * defaultValue:
     * value
     *
     * @param agent
     * @return
     */
    @RequestMapping("/getHeader")
    public String header(@RequestHeader("User-Agent") String agent,
                         @CookieValue("JSESSIONID") String value) {
        System.out.println(agent);
        System.out.println(value);
        return "success";
    }

    /**
     * @param book
     * @return
     */
    @RequestMapping("/books")
    public String books(Book book) {
        System.out.println(book);
        return "success";
    }

    @RequestMapping("/setAttribute")
    public String webOrdinary(HttpSession session, HttpServletRequest request) {
        session.setAttribute("sessionAttribute", "session");
        request.setAttribute("requestAttribute", "request");
        return "success";
    }
}
