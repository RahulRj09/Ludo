package ludo;

import model.GreenYard;
import model.RedYard;
import model.Yard;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LudoRunner {
    public static void main(String[] args) {
        List<Yard> yards = new ArrayList<>();
        RedYard redYard = new RedYard();
        GreenYard greenYard = new GreenYard();
        yards.add(redYard);
        yards.add(greenYard);

        List<Cell> cells = new ArrayList<>();
        for (int i = 0; i < 72 ; i++) {
            Cell cell = new Cell(i);
            cells.add(cell);
        }

        Dice dice = new Dice();

        Board board = new Board(yards,cells,dice);
        List<Player> players = Arrays.asList(new Player(redYard), new Player(greenYard));
        Game game = new Game(players);
        while (game.isRunning()) {
            game.play();
            if (!game.isRunning()) {
                return;
            }
        }
    }
}
