package compulsory;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * clasa SharedMemory se ocupa de obiectul SharedMemory ce va contine cele n^3 tokenuri care vor putea fi extrase de catre Roboti pentru a fi plasate
 * in matrice
 */

public class SharedMemory {
    private final List<Token> tokens = new ArrayList<>();
    Lock lock = new ReentrantLock();
    public SharedMemory(int n) {
        for(int i=1 ; i<=n*n*n  ; i++)
        {
            tokens.add(new Token(i));
        }
        Collections.shuffle(tokens);
    }
    public synchronized List<Token> extractTokens(int howMany) throws InterruptedException {

        List<Token> extracted = new ArrayList<>();
        lock.lock();
        try {


            for (int i = 0; i < howMany; i++) {
                if (tokens.isEmpty()) {
                    System.out.println("E goala");
                    break;
                }
                extracted.add(tokens.remove(0));
            }

        } finally {
            lock.unlock();
        }
        return extracted;
    }

    public void printTokens(){
        for(int i=0 ; i< tokens.size() ; i++)
            System.out.println(tokens.get(i).getNumber());
    }

    public void insertTokens(List<Token> toks){
        lock.lock();
        try {

            tokens.addAll(toks);
        }
        finally
        {
            lock.unlock();
        }

    }


    @Override
    public String toString() {
        return "SharedMemory{" +
                "tokens=" + tokens +
                '}';
    }
}
