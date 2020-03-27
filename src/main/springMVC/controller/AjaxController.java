package springMVC.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import springMVC.bean.Employee;
import springMVC.dao.EmployeeDao;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;

/**
 * @author 李昭
 */
@RequestMapping("/ajax")
@Controller
public class AjaxController {

    @Autowired
    EmployeeDao employeeDao;


    /**
     * 添加该注解会将对象封装为json返回给前端页面
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getAll")
    public Collection<Employee> getAll() {
        return employeeDao.getAll();
    }

    /**
     * 可以获得请求头
     *
     * @param body
     * @return
     */
    @RequestMapping("/requestBody")
    public String testRequestBody(HttpEntity<String> body) {
        System.out.println(body);
        return "success";
    }

    @ResponseBody
    @RequestMapping("/jsonData")
    public String jsonData(@RequestBody Employee msg) {
        System.out.println(msg);
        //将返回值封装为json返回
        return "success";
    }

    /**
     * 响应体中类型
     *
     * @return
     */
    //@ResponseBody
    @RequestMapping("/responseEntity")
    public ResponseEntity<String> entity() {
        /**
         * 参数类型:
         *      1,body返回值
         *      2,响应头
         *      3,响应码
         */
        String body = "<h1>success</h1>";
        MultiValueMap<String, String> map = new HttpHeaders();
        map.set("Set-Cookie", "username");
        ResponseEntity<String> entity = new ResponseEntity<String>(body, map, HttpStatus.OK);
        return entity;
    }

    @RequestMapping("/download")
    public ResponseEntity<byte[]> download(HttpServletRequest request) throws Exception {
        FileInputStream stream = new FileInputStream("C:\\Users\\李昭\\Desktop\\a.txt");
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        stream.close();
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Disposition","attachment;filename=jquery.js");
        ResponseEntity<byte[]> entity = new ResponseEntity<>(bytes, headers, HttpStatus.OK);
        return entity;
    }

    /**
     * 多文件上传
     * @param model
     * @param name
     * @param files
     * @return
     */
    @RequestMapping("/multiUpload")
    public String MultiUpload(Model model, @RequestParam(value = "name",required = false)String name,
                         @RequestParam("photo") MultipartFile[] files) {
        try {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    System.out.println(file.getOriginalFilename());
                    file.transferTo(new File("E:\\"+file.getOriginalFilename()));
                }
            }
            model.addAttribute("msg","success");
        } catch (Exception e) {
            model.addAttribute("msg","failure");
        }
        return "forward:/upload.jsp";
    }
}
