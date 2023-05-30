package compulsory;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


public class Analizeaza {

    private String description;
    Analizeaza(){

    }

    public static void afiseaza(){
        System.out.println("am afisat");
    }
    @Init
    public void testStaticMethod() {

        System.out.println("test");
    }
}
