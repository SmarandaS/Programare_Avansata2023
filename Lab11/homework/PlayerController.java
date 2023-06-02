package homework;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private List<Player> players = new ArrayList<>();

    @GetMapping
    public List<Player> getAllPlayers() {
        //List<Player> players = new ArrayList<>();
        players.add(new Player("Ana", "#"));
        Player a = new Player();
        a.setName("Matei");
        a.setSymbol("$");
        players.add(a);
        return players;
    }

    @PostMapping
    public ResponseEntity<String> addPlayer(@RequestBody Player player) {
        players.add(player);

        return ResponseEntity.status(HttpStatus.CREATED).body("Player added successfully");
    }

    @PutMapping("/{symbol}")
    public ResponseEntity<String> updatePlayerName(@PathVariable("symbol") String symbol, @RequestBody Player updatedPlayer) {
        Player player = getPlayerBySymbol(symbol);
        if (player != null) {
            player.setName(updatedPlayer.getName());
            return ResponseEntity.ok("Player name updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{symbol}")
    public ResponseEntity<String> deletePlayer(@PathVariable("symbol") String symbol) {
        Player player = getPlayerBySymbol(symbol);
        if (player != null) {
            players.remove(player);
            return ResponseEntity.ok("Player deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    private Player getPlayerBySymbol(String symbol) {
        for (Player player : players) {
            if (player.getSymbol().equals(symbol)) {
                return player;
            }
        }
        return null;
    }
}

