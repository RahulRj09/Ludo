package ludo;

import model.Yard;

import java.util.List;

public class Board {
    private List<Yard> yards;
    private List<Cell> cells;
    private Dice dice;

    public Board(List<Yard> yards, List<Cell> cells, Dice dice) {
        this.yards = yards;
        this.cells = cells;
        this.dice = dice;
    }

    public List<Cell> getCells() {
        return cells;
    }

    public Dice getDice() {
        return dice;
    }
}
