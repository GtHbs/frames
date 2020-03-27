package springMVC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

/**
 * 从服务端给客户端传送消息
 * 1,使用原生的HttpServletRequest和HttpSession
 * 2,在方法处传入Map,Model,或者ModelMap这些参数都会放在域中
 * spring会将上面三个map都转为BindingAwareModelMap,并且将所有的信息都保存在request域中
 * 3,可以将方法的返回值变为ModelAndView
 * 4,给session域中存放数据,采用@SessionAttribute注解,只能标注在类上
 *      value="msg"表示在其他map中存放数据时,也会给session中存放一份,value是key
 *      types会将指定的类型存放入session
 *      不过一般不使用,推荐使用原生的HttpSession
 * @author
 */
@SessionAttributes(value = {"msg"},types = {String.class})
@Controller
public class OutputController {

    @RequestMapping("/output")
    public String output(Map<String, Object> map) {
        map.put("msg", "alone");
        map.put("name","dsx");
        return "success";
    }

    @RequestMapping("/output2")
    public String output2(Model model) {
        model.addAttribute("msg", "dsx");
        return "success";
    }

    @RequestMapping("/output3")
    public String output3(ModelMap model) {
        model.addAttribute("msg", "dsx");
        return "success";
    }

    /**
     * 默认也是给request中存放数据
     *
     * @return
     */
    @RequestMapping("/modelAndView")
    public ModelAndView handle() {
        ModelAndView view = new ModelAndView();
        //设置返回视图名
        view.setViewName("success");
        view.addObject("msg", "李洁");
        return view;
    }
}
