package bonus;

public class cycleGraph {

    /**
     * in metoda main umplem matricea de adiacenta dupa urmatoarea regula: in graful ciclic, numerotand nodurile in ordine
     * crescatoare, fiecare ii va avea ca vecini pe precendentul si pe urmatorul + "antecedentul" primului va fi ultimul
     * iar "urmatorul" ultimului va fi primul
     * dupa aflarea acestei matrice, in for-ul in care <i>pow</i> merge de la 0 la n-1 vom calcula puterile matrix^pow
     * dupa metoda clasica de inmultire a matricelor
     * @param args
     */
    public static void main(String[] args){

        if (args.length < 1) {
            System.out.println("Not enough arguments!");
            System.exit(-1);
        }

        int n = Integer.parseInt(args[0]) ;

        int [][] matrix = new int[n][n];


        for(int i=0 ; i<n ; i++) {        //pentru toate elementele grafului, vecinii din graf sunt elementele din stanga si dreapta din matricea de adiacenta
            for (int j = 0; j<n; j++) {
                if(j==i+1 || j==i-1)
                    matrix[i][j]=1;
                else
                    matrix[i][j]=0;

            }
        }
        matrix[0][n-1]=1;               //pentru primul nod, ultimul nod din graf ii este vecinul din stanga
        matrix[n-1][0]=1;               //pentru ultimul nod, primul nod din graf ii este vecinul din dreapta

        System.out.println("Matricea de adiacenta este:");
        for(int i=0 ; i<n ; i++) {
            for (int j = 0; j<n; j++) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.print("\n");
        }

        System.out.print("\n");


        int [][] power = matrix;

        for(int pow=0 ; pow<n-1 ; pow++)
        {
            int[][] temp = new int[n][n];

            for(int i =0 ; i<n ; i++)
                for(int j=0 ; j<n ; j++)
                    for(int k=0 ; k<n ; k++)
                    {
                        temp[i][j]+= power[i][k]*matrix[k][j];
                    }

            power = temp;

            System.out.println("Matricea la puterea " + (pow+2) + " este:");
            for(int i=0 ; i<n ; i++) {
                for (int j = 0; j<n; j++) {
                    System.out.print(temp[i][j] + " ");

                }
                System.out.print("\n");
            }
            System.out.print("\n");

        }

    }

}
