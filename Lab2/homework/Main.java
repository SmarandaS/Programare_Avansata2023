package homework;

import java.util.ArrayList;

/**
 * clasa main poate cuprinde diverse instante de probleme, carora le afiseaza locatiile si drumurile, le verifica validitatea si
 * posibilitatea de a ajunge de la locatia de start la cea de final
 */
public class Main {
    public static void main(String[] args) {

        Airport HenryCoanda = new Airport("Henry Coanda", 44.570875797, 26.0843801116);
        School HenryMerry = new School("Henry Merry", 48.577205797, 27.0848131116);
        City Iasi = new City("Iasi", 47.158455, 27.601442);
        Airport aeroportCluj = new Airport("International Cluj", 45.159855, 21.601702);
        School UBB = new School("UBB", 45.159255, 21.603702);


        Highway A = new Highway("A", 500.0, UBB, HenryCoanda);
        Highway B = new Highway("B", 900.0, Iasi, HenryCoanda);
        Expressway C = new Expressway("C", 391.6, aeroportCluj, Iasi);
        localRoad D = new localRoad("D", 20.0, aeroportCluj, HenryMerry);


        Problem pb = new Problem(UBB, HenryMerry);          //aceasta instanta va fi valida si va avea drum posibil: UBB-HenryCoanda-Iasi-aeroportCluj-HenryMerry


        pb.addRoad(A);
        pb.addRoad(B);
        pb.addRoad(C);
        pb.addRoad(D);
        pb.addRoad(D);      //am incercat sa adaugam D de 2 ori, vom primi mesaj ca nu a putut fi adaugat a 2a oara

        pb.addLocation(HenryMerry);     //am adaugat deja locatia odata cu instanta pb, vom primi mesaj ca nu a putut fi adaugat a 2a oara
        pb.addLocation(HenryCoanda);
        pb.addLocation(aeroportCluj);
        pb.addLocation(Iasi);
        pb.addLocation(UBB);            //am adaugat deja locatia odata cu instanta pb, vom primi mesaj ca nu a putut fi adaugat a 2a oara


        for (int i = 0; i < pb.getLocations().size(); i++) {                        //afisam toate locatiile si drumurile instantei
            System.out.println("Location " + (i + 1) + " of the instance: " + pb.getLocations().get(i).getName());
        }
        for (int i = 0; i < pb.getRoads().size(); i++) {
            System.out.println("Road " + (i + 1) + " of the instance: " + pb.getRoads().get(i).getName() + ", with the speed limit " + pb.getRoads().get(i).getSpeedLimit());
        }


        System.out.println("Instance valid: " + pb.isValid());


        if (pb.tripPossible()) {
            StringBuilder sentence = new StringBuilder("The trip from ");
            sentence.append(pb.getLocations().get(0).getName()).append(" to ").append(pb.getLocations().get(1).getName()).append(" is possible.");
            System.out.println(sentence);
        } else {
            StringBuilder sentence = new StringBuilder("The trip from ");
            sentence.append(pb.getLocations().get(0).getName()).append(" to ").append(pb.getLocations().get(1).getName()).append(" is not possible.");
            System.out.println(sentence);
        }

        System.out.println("\n");

        City Bucuresti = new City("Bucuresti", 44.439663, 26.096306);
        City Bacau = new City("Bacau", 44.439663, 26.096306);
        gasStation Rompetrol = new gasStation("Rompetrol", 48.436363, 22.073206);
        School UniBuc = new School("Uni Buc", 44.436363, 26.073206);

        localRoad E = new localRoad("E", 5.0, UniBuc, Rompetrol);
        Expressway F = new Expressway("F", 500.0, Bacau, Bucuresti);

        Problem pb2 = new Problem(UniBuc, Bacau);               //aceasta instanta va fi valida, dar nu vor exista drumuri posibile

        pb2.addRoad(E);
        pb2.addRoad(F);

        pb2.addLocation(Bucuresti);
        pb2.addLocation(Bacau);             //am adaugat deja locatia odata cu instanta pb2, vom primi mesaj ca nu a putut fi adaugat a 2a oara
        pb2.addLocation(UniBuc);            //am adaugat deja locatia odata cu instanta pb2, vom primi mesaj ca nu a putut fi adaugat a 2a oara
        pb2.addLocation(Rompetrol);


        System.out.println("Instance valid: " + pb2.isValid());
        if (pb2.tripPossible()) {
            StringBuilder sentence = new StringBuilder("The trip from ");
            sentence.append(pb2.getLocations().get(0).getName()).append(" to ").append(pb2.getLocations().get(1).getName()).append(" is possible.");
            System.out.println(sentence);
        } else {
            StringBuilder sentence = new StringBuilder("The trip from ");
            sentence.append(pb2.getLocations().get(0).getName()).append(" to ").append(pb2.getLocations().get(1).getName()).append(" is not possible.");
            System.out.println(sentence);
        }


    }
}
