package spring.ioc.bean;


public class Airplane {
    private String engine;
    private String wingLength;
    private Integer capacity;
    private String commander;
    private String viceCommander;

    public Airplane() {
    }

    public Airplane(String commander) {
        this.commander = commander;
    }

    public Airplane(String engine, String wingLength, Integer capacity, String commander, String viceCommander) {
        this.engine = engine;
        this.wingLength = wingLength;
        this.capacity = capacity;
        this.commander = commander;
        this.viceCommander = viceCommander;
    }

    @Override
    public String toString() {
        return "Airplane{" +
                "engine='" + engine + '\'' +
                ", wingLength='" + wingLength + '\'' +
                ", capacity=" + capacity +
                ", commander='" + commander + '\'' +
                ", viceCommander='" + viceCommander + '\'' +
                '}';
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public String getWingLength() {
        return wingLength;
    }

    public void setWingLength(String wingLength) {
        this.wingLength = wingLength;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getCommander() {
        return commander;
    }

    public void setCommander(String commander) {
        this.commander = commander;
    }

    public String getViceCommander() {
        return viceCommander;
    }

    public void setViceCommander(String viceCommander) {
        this.viceCommander = viceCommander;
    }
}
