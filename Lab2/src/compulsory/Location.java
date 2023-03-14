package compulsory;

/**
 * clasa Location, cu tip, nume, coordonata x si coordonata y contine setteri si getteri pentru acesti parametri, si trei constructori, diferentiati de numarul de parametri necesari
 */
public class Location {

    String name;
    locationType type;
    Double x;
    Double y;

    void setName(String name)
    {
        this.name = name;
    }
    public void setType(locationType type) {
        this.type = type;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }


    public String getName()
    {

        return name;
    }
    public locationType getType()
    {

        return type;
    }
    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }



    public Location()
    {

    }

    public Location(locationType type, String name, Double x, Double y)
    {
        this.type = type ;
        this.name = name ;
        this.x = x;
        this.y = y;
    }

    public Location(String name, Double x, Double y)
    {
        this.name = name ;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
}
