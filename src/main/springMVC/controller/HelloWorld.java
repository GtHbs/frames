package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author alone
 */
@Controller
public class HelloWorld {

    @RequestMapping("/hello")
    public String helloWorld() {
        return "success";
    }

    /**
     * 前端请求index.html页面,由于web.xml中重写了服务器的Default Servlet拦截路径
     * 所以会将该静态资源拦截下,将其当作请求路径在DispatcherServlet中查询,
     * 如果找到则直接处理
     * 否则返回404
     *
     * @return
     */
    @RequestMapping("/index.html")
    public String staticSource() {
        return "success";
    }

    /**
     * web.xml中配置了*.jsp会将服务器配置文件中的JspServlet重写,将其当作普通访问路径
     * 查找,如果转发路径后缀为.jsp则会404,无论找没找到
     *
     * @return
     */
    @RequestMapping("/index.jsp")
    public String staticJspSource() {
        return "success";
    }

    /**
     * 不会拼串
     *
     * @return
     */
    @RequestMapping("/forwards")
    public String forward() {
        return "forward:/redirect";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }
    @RequestMapping("/redirect")
    public String redirect() {
        return "redirect:/output.jsp";
    }
}
