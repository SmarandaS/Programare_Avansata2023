package compulsory;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    @GetMapping
    public List<Player> getAllPlayers() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Ana", "#"));
        Player a = new Player();
        a.setName("Matei");
        a.setSymbol("$");
        players.add(a);
        return players;
    }
}

