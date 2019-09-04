package ludo;

import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Player> players = new ArrayList<>();

    public Game(List<Player> players) {
        this.players = players;
    }

    public boolean isRunning() {
        return true;
    }
}
