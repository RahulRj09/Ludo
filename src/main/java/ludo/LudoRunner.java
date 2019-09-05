package ludo;

import java.util.Arrays;
import java.util.List;

public class LudoRunner {
    public static void main(String[] args) {
        List<Player> players = Arrays.asList(new Player(Color.RED), new Player(Color.GREEN));
        Game game = new Game(players);
        while (game.isRunning()) {
            game.play();
            if (!game.isRunning()) {
                return;
            }
        }

    }
}
