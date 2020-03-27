package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * url可以写模糊的通配符
 * ?   能代替一个字符
 * *   能代替多个字符和一层路径
 * **  能代替多层路径
 * 从上到下优先级以此降低
 *
 * @author
 */
@Controller
public class VagueMatch {

    /**
     * 模糊和精确的情况下,精确优先
     *
     * @return
     */
    @RequestMapping("/ant?")
    public String ant() {
        return "success";
    }

    @RequestMapping("/ant*")
    public String ant02() {
        return "success";
    }

    /**
     * {id}为路径上的占位符,只能占一层路径
     *
     * @return
     */
    @RequestMapping(value = "/user/{id}")
    public String pathVariable(@PathVariable("id") String id) {
        System.out.println(id);
        return "success";
    }
}

