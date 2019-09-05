package ludo;

import java.util.Arrays;

public class Yellow extends Home {
    public Yellow() {
        this.color = "Yellow";
        this.startingPosition = 13;
        this.endingPosition= 70;
        this.coins = Arrays.asList(new Coin(),new Coin(),new Coin(),new Coin());
    }
}
