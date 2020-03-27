package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 李昭
 */
@RequestMapping("/interceptor")
@Controller
public class InterceptorController {

    /**
     * 拦截器执行顺序
     * 单个(无异常):
     *      pre handle
     *      test01
     *      post handle
     *      after completion
     * 单个(有异常):
     *      pre handle
     *      after completion
     * 多个:
     *      pre handle
     *      second preHandle
     *      test01
     *      second postHandle
     *      post handle
     *      second completion
     *      after completion
     * 多个(有异常):
     *      pre handle
     *      second preHandle
     *      second completion
     *      after completion
     * 和过滤器执行顺序相同,先配置先执行先进后出,已放行的拦截器afterCompletion方法都会执行
     * @return
     */
    @RequestMapping("/test01")
    public String test01() {
        int i = 10 / 0;
        System.out.println("test01");
        return "success";
    }
}
