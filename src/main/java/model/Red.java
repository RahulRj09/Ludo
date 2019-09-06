package model;

import ludo.Token;

import java.util.Arrays;

public class Red extends Yard {
    public Red() {
        this.color = "Red";
        this.startingPosition = 0;
        this.endingPosition= 57;
        this.tokens = Arrays.asList(new Token(),new Token(),new Token(),new Token());
    }
}
