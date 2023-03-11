package homework;


/**
 * clasa abstracta Location, cu nume, coordonata x si coordonata y contine setteri si getteri pentru acesti parametri, si doi constructori, diferentiati de numarul de parametri necesari
 * contine functii override pentru <i>toString</i> si <i>equals</> din clasa de baza <i>Object</i>
 */
public abstract class Location {

    String name;

    Double x;
    Double y;

    void setName(String name) {
        this.name = name;
    }

    public void setX(Double x) {
        this.x = x;
    }

    public void setY(Double y) {
        this.y = y;
    }


    public String getName() {

        return name;
    }


    public Double getX() {
        return x;
    }

    public Double getY() {
        return y;
    }


    public Location() {

    }

    public Location(String name, Double x, Double y) {

        this.name = name;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location loc = (Location) o;
        return getName().equals(loc.getName()) && getX().equals(loc.getX()) && getY().equals(loc.getY());
    }
}




