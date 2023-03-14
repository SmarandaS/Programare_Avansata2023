package compulsory;

public class Main {

    /**
     * functia main contine declararile si afisarile catorva exemple de obiecte de tipul Road si Location
     * @param args
     */
    public static void main(String[] args) {

    Location universitate = new Location(locationType.school, "UAIC", 23.5, 30.6 );
    System.out.println("Univ se numeste: " + universitate.getName());

    Location c1 = new Location();
    c1.setName("Iași");
    c1.setType(locationType.city);
    c1.setX(0.0);
    c1.setY(0.0);
    System.out.println("The location is " + c1.name + " and it is a " + c1.type);

    Location c2 = new Location("Vaslui", 10.0, 20.0);
    System.out.println("The location is " + c2.name + " and its coordinates are " + c2.x + " and " + c2.y);


    Road r1 = new Road("D24", roadType.expressway, 123.5, 55);
    System.out.println("We have an " + r1.getType() + " called " + r1.getName() + ", that is " + r1.getLength() + " km long and has the speed limit " + r1.getSpeedLimit() + "km/h" );

    Road r2 = new Road();
    r2.setName("A1");
    r2.setLength(100.5);
    r2.setSpeedLimit(120);
    System.out.println("The speed limit on " + r2.name + " is " + r2.speedLimit);

    Road r3 = new Road("Independentei" , 2.0 , 60);
    System.out.println("The length of the " + r3.name + " road is " + r3.getLength() + " km");

    }
}