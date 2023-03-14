package homework;

/**
 * Clasa ex2 are metoda main, ce implementeaza cerintele partii de <i>homework</i>. Prin rularea de la linia de comanda folosind
 * comenzile javac si java, putem introduce argumentul m din metoda main de la tastatura
 * Acesta este validat prin if ul care verifica existenta lui.
 * Cream matricea latina ce are drept elemente numerele de la 1 la m
 * Folosing StringBuilder, construim stringurile pentru elementele liniilor matricelor si afisam rezultatul
 * Repetam procesul pentru coloane
 * prin scaderea variabilelor initialTime si finalTime(care memoreaza system time la inceputul, respectiv finalul programului),
 * vom afla timpul de rulare al programului, care este unicul lucru afisat in cazul in care m>30000
 * compilam folosind comanda <i>javac homework\ex2.java</i> si rulam folosind <i>java homework.ex2 m</i> , unde m e dimensiunea matricei
 */
public class ex2 {

    public static void main(String[] args) {

        long initialTime = System.currentTimeMillis();

        if (args.length < 1) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }

        int m = Integer.parseInt(args[0]) ;

        int [][] a = new int[m][m];

        for(int j=0 ; j<m ; j++)
            a[0][j] = j+1;

        for(int i=1 ; i<m ; i++) {
            for (int j = 0; j<m; j++) {
                    a[i][j] = a[i - 1][(j +1)%m];

            }
        }

        for(int i=0 ; i<m ; i++) {

            StringBuilder line = new StringBuilder();

            for (int j = 0; j < m; j++) {
                line.append(Integer.toString(a[i][j]));
            }
            if(m<30000)
                System.out.println(line);
        }

        if(m<30000)
            System.out.print("\n");

        for(int j=0 ; j<m ; j++) {

            StringBuilder column = new StringBuilder();

            for (int i = 0; i < m; i++) {
                column.append(Integer.toString(a[i][j]));
            }

            if(m<30000)
                System.out.println(column);
        }

        long finalTime = System.currentTimeMillis();

        long programTime = finalTime - initialTime;

        if(m>30000)
            System.out.println("Program time in milliseconds is: " + programTime);

    }

}
