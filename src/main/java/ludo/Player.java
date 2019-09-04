package ludo;

import java.util.ArrayList;
import java.util.List;

public class Player {
    List<Coin> coins = new ArrayList<>();
    Color color;
    Dice dice;
    public Player(Color color) {
        this.color = color;
        for (int i = 0; i <=3 ; i++) {
            Coin coin = new Coin(i);
            this.coins.add(coin);
        }
    }

    public void play() {
        int numberOnDice = dice.toss();
    }
}
