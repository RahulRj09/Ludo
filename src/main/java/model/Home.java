package model;

import ludo.Coin;

import java.util.List;

public class Home {
    List<Coin> coins;
    int startingPosition;
    int endingPosition;
    String color;

    public List<Coin> getCoins() {
        return coins;
    }

    public int getStartingPosition() {
        return startingPosition;
    }

    public int getEndingPosition() {
        return endingPosition;
    }

    public String getColor() {
        return color;
    }
}
