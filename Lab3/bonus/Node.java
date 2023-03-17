package bonus;

import java.util.List;

/**
 * interfata node include un getter pentru nume si o metoda de get pentru vecinii nodurilor(nodurile cu care au relatii), de care
 * ne folosim in Network pentru a verifica existenta punctelor de articulatie
 */
public interface Node {
    public String getName();

    public List<Node> getNeighbours();


}
