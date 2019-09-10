package model;

import ludo.Token;

import java.util.Arrays;

public class RedYard extends Yard {
    public RedYard() {
        this.color = "Red";
        this.startingPosition = 0;
        this.endingPosition = 57;
        this.tokens = Arrays.asList(new Token(), new Token(), new Token(), new Token());
    }
}
