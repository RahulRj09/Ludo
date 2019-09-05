package ludo;

import java.util.Arrays;

public class Blue extends Home {
    public Blue() {
        this.color = "Blue";
        this.startingPosition = 39;
        this.endingPosition= 96;
        this.coins = Arrays.asList(new Coin(),new Coin(),new Coin(),new Coin());
    }
}
