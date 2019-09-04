package ludo;

import java.util.List;

public class Game {
    List<Player> players;
    int currentPlayerIndex;
    public Game(List<Player> players) {
        this.players = players;
        this.currentPlayerIndex = 0;
    }

    public boolean isRunning() {
        return true;
    }

    public void play() {
    Player currentPlayer = players.get(currentPlayerIndex);
    currentPlayer.play();
    }
}
