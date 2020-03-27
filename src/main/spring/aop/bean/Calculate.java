package spring.aop.bean;

import org.springframework.stereotype.Service;

/**
 * @author 李昭
 */
@Service
public class Calculate implements Calculator {


    @Override
    public Integer add(int a, int b) {
        return a + b;
    }

    @Override
    public Integer sub(int a, int b) {
        return a - b;
    }

    @Override
    public Integer multi(int a, int b) {
        return a * b;
    }

    @Override
    public double div(int a, int b) {
        System.out.println("----------");
        return a / b;
    }
}
