package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author
 */
@RequestMapping("/request")
@Controller
public class RequestMappingHandler {

    /**
     * method:限定请求方式,默认是什么方式都接收
     * GET,HEAD,POST,PUT,PATCH,DELETE,OPTIONS,TRACE
     * consumers:
     * produces:
     *
     * @return
     */
    @RequestMapping(value = "handle", method = RequestMethod.POST)
    public String handle() {
        return "success";
    }

    /**
     * params:规定请求参数,如果没带直接404
     *        params={"username"}必须携带username
     *        params={"!username"}必须不携带username
     *        params={"username=123"}必须携带username,且值为123
     *        params={"username!=123"}必须携带username,且值不为123
     *        params={"username!=123","pwd","!age"}全部必须满足
     *
     * @return
     */
    @RequestMapping(value = "/params", params = {"username"})
    public String params() {
        return "success";
    }

    /**
     * headers:请求头
     * User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64)
     *             AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.87 Safari/537.36
     * Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:73.0) Gecko/20100101 Firefox/73.0
     *             规定只能火狐浏览器访问
     * @return
     */
    @RequestMapping(value = "/headers",headers = {"User-Agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:73.0) Gecko/20100101 Firefox/73.0"})
    public String headers() {
        System.out.println("chrome");
        return "success";
    }
}
