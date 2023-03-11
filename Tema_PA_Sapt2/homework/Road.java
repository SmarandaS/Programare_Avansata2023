package homework;

import java.util.Objects;

/**
 * clasa abstracta Road, cu  limita de viteza, nume, lungime, locatiile care se afla la inceputul si la sfarsitul lui, contine setteri si getteri pentru acesti parametri, si doi constructori, diferentiati de numarul de parametri necesari
 * contine functii override pentru <i>toString</i> si <i>equals</> din clasa de baza <i>Object</i>
 */
public abstract class Road {

    String name;
    Double length;

    Location start;
    Location finish;

    int speedLimit;


    public void setName(String name) {
        this.name = name;
    }

    public void setLength(Double length) {
        this.length = length;
    }

    public void setStart(Location start) {
        this.start = start;
    }

    public void setFinish(Location finish) {
        this.finish = finish;
    }


    public String getName() {
        return name;
    }


    public Double getLength() {
        return length;
    }

    public Location getStart() {
        return start;
    }

    public Location getFinish() {
        return finish;
    }

    public int getSpeedLimit() {return speedLimit;}

    public Road() {

    }

    public Road(String name, Double length, Location start, Location finish) {
        this.name = name;
        this.length = length;
        this.start = start;
        this.finish = finish;

    }


    @Override
    public String toString() {
        return "Road{" +
                " name='" + name + '\'' +
                ", length=" + length +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road)) return false;
        Road road = (Road) o;
        return getName().equals(road.getName()) && getLength().equals(road.getLength()) && getStart().equals(road.getStart()) && getFinish().equals(road.getFinish());
    }


}
