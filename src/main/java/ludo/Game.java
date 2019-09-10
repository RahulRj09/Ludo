package ludo;

import model.Yard;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    static private List<Yard> yards = new ArrayList<>();
    private int red = 0;
    private int green = 0;
    private int blue = 0;
    private int yellow = 0;

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.currentPlayerIndex = 0;
    }

    public void play() {
        Player currentPlayer = players.get(currentPlayerIndex);
        Token token = currentPlayer.play(board.getDice());
        if(token != null && token.position > currentPlayer.yard.getStartingPosition()){
            System.out.println(token.getPosition());
        }
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    static void add(Yard yard) {
        yards.add(yard);
    }

    public boolean isRunning() {
        return !checkWinner();
    }

    public boolean checkWinner() {
        String winner = tokenCounter();
        int neededTokenForWinner = 1;
        boolean red = this.red == neededTokenForWinner;
        boolean green = this.green == neededTokenForWinner;
        boolean blue = this.blue == neededTokenForWinner;
        boolean yellow = this.yellow == neededTokenForWinner;
        if (red || green || blue || yellow) {
            System.out.println(winner);
            return true;
        }
        return false;
    }

    private String tokenCounter() {
        for (Yard yard : yards) {
            switch (yard.getColor()) {
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
                default:
                    throw new IllegalStateException("Unexpected value: " + yard.getColor());
            }
            return yard.getColor();
        }
        return null;
    }
}
