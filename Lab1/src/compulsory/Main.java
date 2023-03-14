package compulsory;

/**
     * Clasa main implementeaza cerintele din partea <i>compulsory</i> a temei pentru Lab 1
     * Am declarat intai stringul de limbaje
     * Am generat numarul random n si l-am afisat pentru a vedea valoarea lui initiala
     * Am aplicat calculele cerute asupra numarului si am afisat noua lui valoare
     * Am calculat cifra de control a numarului, asa cum ne este ceruta in tema
     * Am afisat propozitia ceruta, avand pe ultima pozitie elementul din stringul declarat initial de pe pozitia valorii cifrei de control
     * @param args
     */

public class Main {

    
    public static void main(String[] args) {

        //System.out.println("Hello world!\n");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"} ;

        int n = (int) (Math.random() * 1_000_000);

        System.out.println("The initial value of n is: " + n);
        n = (n *3 + Integer.parseInt("10101",2) + Integer.parseInt("FF",16)) * 6;

        System.out.println("The new value of n is: " + n);

        int result = 0;

        while(n > 9)
        {
            result=0;
            while(n!=0)
            {
                result += n % 10;
                n /= 10;
            }
            n=result;


        }
        System.out.println("The result is: " + result);
        System.out.println("Willy-nilly, this semester I will learn " + languages[result]);

    }







}



