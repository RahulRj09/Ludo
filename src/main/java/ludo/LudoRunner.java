package ludo;

import model.Green;
import model.Red;

import java.util.Arrays;
import java.util.List;

public class LudoRunner {
    public static void main(String[] args) {
        List<Player> players = Arrays.asList(new Player(new Red()),new Player(new Green()));
        Game game = new Game(players);
        while (game.isRunning()) {
            game.play();
            if (!game.isRunning()) {
                return;
            }
        }
    }
}
