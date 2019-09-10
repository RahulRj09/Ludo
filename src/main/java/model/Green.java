package model;

import ludo.Token;

import java.util.Arrays;

public class Green extends Yard {
    public Green() {
        this.color = "Green";
        this.startingPosition = 26;
        this.endingPosition = 83;
        this.tokens = Arrays.asList(new Token(), new Token(), new Token(), new Token());
    }
}
