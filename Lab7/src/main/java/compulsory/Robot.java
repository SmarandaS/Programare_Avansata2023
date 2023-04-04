package compulsory;


import java.util.List;

import static java.lang.Thread.sleep;

/**
 * clasa Robot se ocupa de obiectele de tip robot, care vor avea threaduri individuale, prin urmare implementeaza metoda run, care trece prin
 * matricea nXn unde trebuie introduce tokenuri si introduce in celule nevizitate n tokenuri extrase din SharedMemory (unde avem n^3 tokenuri)
 */
public class Robot implements Runnable{

    private String name;
    int n=2;
    private boolean running=true;
    Exploration explore = new Exploration(n);
    public Robot(String name) {
        this.name = name;


    }

    public String getName() {
        return name;
    }

    public void run() {
        boolean viz ;
        do {
            viz= false;
            //System.out.println("Intru in run pentru " + this.getName() );
            int n = explore.getSize();
            //System.out.println("n este" + n );
            for (int row = 0; row < n; row++) {
                for (int col = 0; col < n; col++) {
                    //System.out.println("Intru in for pentru " + this.getName());
                    try {
                        if (explore.getMap().visit(row, col, this)) {

                            System.out.println("Vizitat");
                            System.out.println(viz);
                            viz = true;

                        } else {
                            System.out.println("Deja vizitat");
                        }
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }

            }

        } while (viz);
    }



}
