package ludo;

import model.Yard;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private Board board;
    private List<Player> players;
    private int currentPlayerIndex;
    private static List<String> redYard = new ArrayList<>();
    private static List<String> greenYard = new ArrayList<>();
    private static List<String> blueYard = new ArrayList<>();
    private static List<String> yellowYard = new ArrayList<>();

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.currentPlayerIndex = 0;
    }

    public void play() {
        Player currentPlayer = players.get(currentPlayerIndex);
        Token token = currentPlayer.play(board.getDice());
        if (token != null && token.position > currentPlayer.yard.getStartingPosition()) {
            setPositionOnCell(currentPlayer, token);
            if (currentPlayer.getNumberOnDice() == 6) {
                Token token1 = currentPlayer.play(board.getDice());
                setPositionOnCell(currentPlayer, token1);
            }
        }
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    private void setPositionOnCell(Player currentPlayer, Token token) {
        int currentCellId = token.position - currentPlayer.yard.getStartingPosition();
        board.getCells().get(currentCellId).setTokens(token);
    }

    static void add(Yard yard) {
        if (yard.getColor().equals("Red")) {
            redYard.add(yard.getColor());
        }
        if (yard.getColor().equals("Green")) {
            greenYard.add(yard.getColor());
        }
        if (yard.getColor().equals("Blue")) {
            blueYard.add(yard.getColor());
        }
        if (yard.getColor().equals("Yellow")) {
            yellowYard.add(yard.getColor());
        }
    }

    public boolean isRunning() {
        return !checkWinner();
    }

    public boolean checkWinner() {
        int neededTokenForWinner = 2;
        boolean red = redYard.size() == neededTokenForWinner;
        boolean green = greenYard.size() == neededTokenForWinner;
        boolean yellow = yellowYard.size() == neededTokenForWinner;
        boolean blue = blueYard.size() == neededTokenForWinner;
        if (red || green || yellow || blue) {
            System.out.println("win");
            return true;
        }
        return false;
    }

}
