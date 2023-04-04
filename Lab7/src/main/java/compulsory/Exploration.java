package compulsory;

import java.util.ArrayList;
import java.util.List;

/**
 * clasa Exploration contine metoda main si metoda start pentru threaduri pe care aceasta o apeleaza
 */
public class Exploration {

    int n;

    private  SharedMemory mem = new SharedMemory(n);
    private ExplorationMap map = new ExplorationMap(n);
    private List<Robot> robots = new ArrayList<>();

    public SharedMemory getMem() {
        return mem;
    }

    public ExplorationMap getMap() {
        return map;
    }

    public List<Robot> getRobots() {
        return robots;
    }

    public int getSize() {
        return n;
    }

    public Exploration(int n) {
        this.n = n;

        this.mem = new SharedMemory(n);
        this.map = new ExplorationMap(n);
        this.robots = new ArrayList<>();
    }

    public void addRobot(Robot robot){
        robots.add(robot);
    }

    public void start() {
        for (Robot robot : robots) {
            //System.out.println("Incepe robotul " + robot.getName());
           new Thread(robot).start();
            //System.out.println("Se termina robotul " + robot.getName());


        }
    }

    public static void main(String args[]) {

        Exploration explore = new Exploration(2);


        explore.addRobot(new Robot("Wall-E"));
        explore.addRobot(new Robot("R2D2"));
        explore.addRobot(new Robot("Optimus Prime"));
        System.out.println(explore.getSize());
        //System.out.println("Ajuns aici");
        explore.getMem().printTokens();
        explore.start();
        //System.out.println("Gata");
        if(Thread.activeCount()==0){
            System.out.println(explore.getMap().toString());
        }



    }

}
