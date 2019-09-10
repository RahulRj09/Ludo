package ludo;

import model.GreenYard;
import model.RedYard;

import java.util.Arrays;
import java.util.List;

public class LudoRunner {
    public static void main(String[] args) {
        List<Player> players = Arrays.asList(new Player(new RedYard()), new Player(new GreenYard()));
        Game game = new Game(players);
        while (game.isRunning()) {
            game.play();
            if (!game.isRunning()) {
                return;
            }
        }
    }
}
