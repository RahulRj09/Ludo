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


    public Game(List<Player> players) {
        this.players = players;
        this.currentPlayerIndex = 0;
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

    public void play() {
        Player currentPlayer = players.get(currentPlayerIndex);
        currentPlayer.play();
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    static void add(Home home) {
        colors.add(home);
    }
    public boolean checkWinner() {
        winner();
        if (this.red == 1 || this.green == 1) {
            return true;
        }
        return false;
    }

    private void winner() {
        for (Home home : colors) {
            if (home.getColor().equals("Red")) {
                this.red += 1;
            }
            if (home.getColor().equals("Green")) {
                this.green += 1;
            }
        }
    }
}
