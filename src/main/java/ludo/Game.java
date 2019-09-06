package ludo;

import model.Home;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private int currentPlayerIndex;
    static private List<Home> colors = new ArrayList<>();
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private int yellow = 0;
    private int neededCoinForWinner = 4;

    public Game(List<Player> players) {
        this.players = players;
        this.currentPlayerIndex = 0;
    }

    public void play() {
        Player currentPlayer = players.get(currentPlayerIndex);
        currentPlayer.play();
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    static void add(Home home) {
        colors.add(home);
    }

    public boolean isRunning() {
        for (Player player : players) {
            if (checkWinner()) {
                System.out.println(player.home.getColor() + " Win");
                return false;
            }
        }
        return true;
    }

    public boolean checkWinner() {
        hasWon();
        boolean red = this.red == neededCoinForWinner;
        boolean green = this.green == neededCoinForWinner;
        boolean blue = this.blue == neededCoinForWinner;
        boolean yellow = this.yellow == neededCoinForWinner;
        if (red || green || blue || yellow) {
            return true;
        }
        return false;
    }

    private void hasWon() {
        for (Home home : colors) {
            switch (home.getColor()) {
                case "Red":
                    this.red += 1;
                    break;
                case "Green":
                    this.green += 1;
                    break;
                case "Blue":
                    this.blue += 1;
                    break;
                case "Yellow":
                    this.yellow += 1;
                    break;
            }
        }
    }
}
