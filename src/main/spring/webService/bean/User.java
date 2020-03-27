package spring.webService.bean;

import lombok.Data;

import java.util.List;

/**
 * @Author: 李昭
 * @Date: 2020/3/9 19:33
 */
@Data
public class User {
    private Integer id;
    private String username;
    private String city;
    private List<Car> cars;

}
