package ludo;

import java.util.Random;

public class Dice {
    public int toss() {
        return new Random().nextInt(6)+1;
    }
}
