package model;

import ludo.Coin;

import java.util.Arrays;

public class Green extends Home {
    public Green() {
        this.color = "Green";
        this.startingPosition = 0;
        this.endingPosition = 57;
        this.coins = Arrays.asList(new Coin(), new Coin(), new Coin(), new Coin());
    }
}
