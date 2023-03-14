package compulsory;

/**
 * clasa Road, cu tip, nume, lungime si limita de viteza contine setteri si getteri pentru acesti parametri, si trei constructori, diferentiati de numarul de parametri necesari
 */
public class Road {

    roadType type;
    String name;
    Double length;
    int speedLimit;

    public void setName(String name) {
        this.name = name;
    }
    public void setType(roadType type) {
        this.type = type;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }


    public String getName() {
        return name;
    }
    public roadType getType()
    {
        return type;
    }
    public Double getLength() {
        return length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }



    public Road()
    {

    }
    public Road(String name, roadType type, Double length, int speedLimit)
    {
        this.name = name;
        this.type = type ;
        this.length = length ;
        this.speedLimit = speedLimit;
    }

    public Road(String name, Double length, int speedLimit)
    {
        this.name = name ;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", name='" + name + '\'' +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                '}';
    }
}
