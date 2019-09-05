package ludo;

import java.util.Arrays;

public class Red extends Home {
    public Red() {
        this.color = "Red";
        this.startingPosition = 0;
        this.endingPosition= 57;
        this.coins = Arrays.asList(new Coin(),new Coin(),new Coin(),new Coin());
    }
}
