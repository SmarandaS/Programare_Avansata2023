package homework;

import java.util.ArrayList;

/**
 * clasa problem contine 2 ArrayLists, una pentru locatii si una pentru drumuri, getteri pentru acestea, un constructor prin care
 * introducem locatiile de start si final ale problemei, functii pentru adaugare de locatii si drumuri, functie pentru verificarea
 * validitatii problemei si functie pentru verificarea existentei unui drum intre locatia de start si cea de final(functie care face verificarea in functie de ce
 * fel de drum avem intre locatii: drum de la locatie la ea insasi, drum direct, drum care daca exista este format din >=2 drumuri(caz in care este
 * apelata functia recursiva <i>searchRoad</i>))
 */
public class Problem {

    private ArrayList<Location> locations;
    private ArrayList<Road> roads;

    public ArrayList<Location> getLocations() {

        return locations;
    }

    public ArrayList<Road> getRoads() {
        return roads;
    }

    public Problem(Object start, Object finish) {  //constructorul problemei care adauga locatiile de start si finish in ArrayList ul de locatii
        locations = new ArrayList<Location>();
        roads = new ArrayList<Road>();
        if (start instanceof Airport) {
            locations.add((Airport) start);
        }
        if (start instanceof City) {
            locations.add((City) start);
        }
        if (start instanceof School) {
            locations.add((School) start);
        }
        if (start instanceof gasStation) {
            locations.add((gasStation) start);
        }

        if (finish instanceof Airport) {
            locations.add((Airport) finish);
        }
        if (finish instanceof City) {
            locations.add((City) finish);
        }
        if (finish instanceof School) {
            locations.add((School) finish);
        }
        if (finish instanceof gasStation) {
            locations.add((gasStation) finish);
        }


    }


    public void addLocation(Location location) {
        boolean add = true;
        for (int i = 0; i < locations.size(); i++) {
            if (location.equals(locations.get(i))) {
                System.out.println("This location cannot be added! " + location.getName() + " already exists!");
                add = false;
            }
        }
        if (add) {
            locations.add(location);
        }

    }

    public void addRoad(Road road) {
        boolean add = true;
        for (int i = 0; i < roads.size(); i++) {
            if (road.equals(roads.get(i))) {
                System.out.println("This road cannot be added! " + road.getName() + " already exists!");
                add = false;
            }
        }
        if (add) {
            roads.add(road);
        }

    }


    /**
     * această funcție verifică validitatea problemei: dacă nu există cel puțin 2 locații și 1 drum în problemă, nu este o instanță validă
     * dacă locațiile <i>start</i> și <i>finish</i> nu există pe cel puțin un drum, instanța nu este validă
     * dacă fiecare dintre locațiile de <i>start</i> și <i>finish</i> există pe cel puțin un drum și există >=1 drumuri și >=2 locații, aceasta este o instanță validă
     */
    public boolean isValid() {

        if (roads.get(0).equals(roads.get(1))) {        //daca locatia de start si cea de final sunt egale, exista "drum" (e drumul de la locatie la ea insasi, care exista intotdeauna)
            return true;
        }
        boolean startExist = false;
        boolean finishExist = false;

        if (locations.size() < 2 || roads.size() < 1) {
            return false;
        } else {


            for (int i = 0; i < roads.size(); i++) {
                if (roads.get(i).getStart().equals(locations.get(0)) || roads.get(i).getFinish().equals(locations.get(0))) {
                    startExist = true;
                }
                if (roads.get(i).getStart().equals(locations.get(1)) || roads.get(i).getFinish().equals(locations.get(1))) {
                    finishExist = true;
                }
            }


            if (startExist && finishExist) {
                return true;
            } else {
                return false;
            }

        }

    }

    /**
     * aceasta functie verifica daca e posibila o calatorie intre cele 2 locatii date odata cu crearea instantei problemei. Verifica cele 3 cazuri de baza
     * (instanta nu e valida, cautam drum de la o locatie la ea insasi, exista drum direct intre cele 2 locatii(drum care e dat in <i>roads</i>)), iar daca instanta
     * nu se incadreaza in acestea, inseamna ca problema este valida si cautam un drum de indirect intre locatii(format din >=2 drumuri din <i>roads</i>), deci vom apela
     * functia recursiva <i>searchRoad</i>
     *
     * @return
     */
    public boolean tripPossible() {
        if (!isValid()) {                               //daca problema nu e valida nu are rost verificarea existentei drumului
            return false;
        }
        if (locations.get(0).equals(locations.get(1)))  //daca locatia initiala si cea finala sunt egale, exista drum (drum de la o locatie la ea insasi)
            return true;
        for (int i = 0; i < roads.size(); i++) {        //daca avem un drum direct in lista intre locatia initiala si cea finala, avem drum
            if ((roads.get(i).getStart().equals(locations.get(0)) && roads.get(i).getFinish().equals(locations.get(1)))
                    || (roads.get(i).getStart().equals(locations.get(1)) && roads.get(i).getFinish().equals(locations.get(0)))) {
                return true;
            }
        }
        int visited[] = new int[locations.size()];


        return searchRoad(locations.get(0), locations.get(1), roads, visited);


    }

    /**
     * functia <i>searchRoad</i> este o functie recursiva ce are scopul de a determina daca exista sau nu o cale de a ajunge de la locatia de <i>current</i> la cea
     * <i>end</i>.Apelam aceasta functie din <i>tripPossible</i> cu current = locatia de start si end = locatia de final din instanta problemei.
     * <i>searchRoad</i> construieste un vector de locatii vizitate in cadrul cautarii prin drumuri si un ArrayList <i>connectedRoads</i> pentru fiecare drum "curent"
     * ce pastreaza drumurile pentru care acel drum se afla la un capat. Continuam sa apelam functia in ea insasi pana ajungem ca locatia curenta sa fie cea de end.
     * Daca nu ajungem acolo(nu returnam true si ajungem sa terminam de verificat toate drumurile), atunci inseamna ca nu exista un drum de la start la finish din instanta data
     *
     * @param current
     * @param end
     * @param roads
     * @param visited
     * @return
     */

    public boolean searchRoad(Location current, Location end, ArrayList<Road> roads, int visited[]) {
        for (int i = 0; i < locations.size(); i++) {
            if (locations.get(i).equals(current))
                visited[i] = 1;
        }

        if (current.equals(end)) {
            return true;
        }

        ArrayList<Road> connectedRoads = new ArrayList<>();
        for (int j = 0; j < roads.size(); j++) {
            if (roads.get(j).getStart().equals(current) || roads.get(j).getFinish().equals(current)) {
                connectedRoads.add(roads.get(j));
            }
        }

        for (Road road : connectedRoads) {
            Location dest = road.getStart();
            if (road.getStart().equals(current)) {
                dest = road.getFinish();
            }

            for (int i = 0; i < locations.size(); i++) {
                if (locations.get(i).equals(dest)) {
                    if (visited[i] == 0) {
                        if (searchRoad(dest, end, roads, visited)) {
                            return true;
                        }
                    }
                }
            }
        }

        return false;

    }


}
