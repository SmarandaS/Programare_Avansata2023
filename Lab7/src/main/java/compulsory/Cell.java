package compulsory;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * clasa Cell este wrapper pentru liste de Tokenuri. Matricea din ExplorationMap este o matrice ale carei celule sunt astfel de Cells
 */
public class Cell {

    private List<Token> tokens;
    Lock lock = new ReentrantLock();
    private boolean visited;

    public Cell() {

        this.tokens = new ArrayList<>();
        this.visited=false;
    }

    public boolean addTokens(List<Token> tokens)
    {
        if(lock.tryLock())
        {
            try {
                tokens.addAll(tokens);
                visited = true;

            } finally {
                lock.unlock();
            }
            return true;
        }
       return false;

    }



    public List<Token> getTokens() {
        return tokens;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "tokens=" + tokens +
                '}';
    }

    public void setVisitedTrue() {
        this.visited = true;
    }

    public boolean isVisited()
    {
        return visited;
    }
}
