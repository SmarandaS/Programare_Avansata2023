package compulsory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * clasa ExplorationMap se ocupa de matricea initial goala ce va fi vizitata de catre Roboti si in celulele careia vor fi introduse Tokenurile din
 * SharedMemory
 */
public class ExplorationMap {


    private final Cell[][] matrix;

    public ExplorationMap(int n) {

        this.matrix = new Cell[n][n];
    }

    public Cell getCell(int i, int j)
    {
        return matrix[i][j];
    }


    public boolean visit(int col, int row, Robot robot) throws InterruptedException {

        System.out.println(col + " " + row);
        //System.out.println("Intrat in visit");

        {
            //System.out.println("Intrat in sincr");
            Cell c = this.getCell(row,col);
            if(c != null && !c.isVisited())
            {
                //System.out.println("Intru in vizitare");
               List<Token> l = robot.explore.getMem().extractTokens(robot.explore.getSize());

                if(robot.explore.getMap().getCell(row,col).addTokens(l))
                {
                    System.out.println("Celula " + row + " " + col + " a fost vizitata de " + robot.getName());
                    System.out.println("Extragere si adaugare cu succes!");
                    robot.explore.getMap().getCell(row,col).setVisitedTrue();
                    return true;
                }
                robot.explore.getMem().insertTokens(l);
            }
        }
        return false;

    }
    public int getSize()
    {
        return matrix.length* matrix.length;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i=0 ; i<this.matrix.length ; i++)
            for(int j=0 ; j<this.matrix.length ; j++)
            {
                String s = (matrix[i][j] != null)?
                        matrix[i][j].toString():
                        ".";
                sb.append(s);
                sb.append(" ");
            }
        return sb.toString();
    }
}
