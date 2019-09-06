package model;

import ludo.Token;

import java.util.Arrays;

public class Yellow extends Home {
    public Yellow() {
        this.color = "Yellow";
        this.startingPosition = 13;
        this.endingPosition= 70;
        this.tokens = Arrays.asList(new Token(),new Token(),new Token(),new Token());
    }
}
