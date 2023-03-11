package homework;

/**
 * subclasa <i>City</i> a clasei <i>Location</i>, adauga populatia
 */
public class City extends Location{
    int population;

    public void setPopulation(int population) {
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }


    public City(String name, Double x, Double y) {
        super(name, x, y);
    }
}
