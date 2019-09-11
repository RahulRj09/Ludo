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
        yards.add(yard);
    }

    public boolean isRunning() {
        return !checkWinner();
    }

    public boolean checkWinner() {
        tokenCounter();
        int neededTokenForWinner = 1;
        boolean red = this.red == neededTokenForWinner;
        boolean green = this.green == neededTokenForWinner;
        boolean blue = this.blue == neededTokenForWinner;
        boolean yellow = this.yellow == neededTokenForWinner;
        if (red || green || blue || yellow) {
            System.out.println("win");
            return true;
        }
        return false;
    }

    private void tokenCounter() {
        for (Yard yard : yards) {
            if ("Red".equals(yard.getColor())) {
                this.red += 1;
            } else if ("Green".equals(yard.getColor())) {
                this.green += 1;
            } else if ("Blue".equals(yard.getColor())) {
                this.blue += 1;
            } else if ("Yellow".equals(yard.getColor())) {
                this.yellow += 1;
            }
        }
    }
}
