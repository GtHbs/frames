package spring.amqp;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author: 李昭
 * @Date: 2020/3/18 21:05
 */
@Data
public class User implements Serializable {


    private static final long serialVersionUID = 4705520904577685387L;
    private String name;
    private Integer age;
}
