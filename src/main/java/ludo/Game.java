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
        for (Player player : players) {
            if (player.hasWon()) {
                System.out.println(player.color+" Win");
                return false;
            }
        }
        return true;
    }

    public void play() {
        Player currentPlayer = players.get(currentPlayerIndex);
        currentPlayer.play();
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}
