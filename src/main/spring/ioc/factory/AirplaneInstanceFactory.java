package spring.ioc.factory;

import spring.ioc.bean.Airplane;

/**
 * 飞机实例工厂
 */
public class AirplaneInstanceFactory {
    public AirplaneInstanceFactory() {}

    public Airplane getInstance(String commander) {
        System.out.println("instance factory");
        return new Airplane("空客","20",200,commander,"dsx");
    }
}
