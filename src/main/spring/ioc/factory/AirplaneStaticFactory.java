package spring.ioc.factory;

import spring.ioc.bean.Airplane;

public class AirplaneStaticFactory {

    public static Airplane getInstance(String commander) {
        System.out.println("static factory...");
        return new Airplane("空客","20",200,commander,"dsx");
    }
}
