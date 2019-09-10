package model;

import ludo.Token;

import java.util.Arrays;

public class BlueYard extends Yard {
    public BlueYard() {
        this.color = "Blue";
        this.startingPosition = 39;
        this.endingPosition= 96;
        this.tokens = Arrays.asList(new Token(),new Token(),new Token(),new Token());
    }
}
