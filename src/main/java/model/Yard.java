package model;

import ludo.Token;

import java.util.List;

public class Yard {
    List<Token> tokens;
    int startingPosition;
    int endingPosition;
    String color;

    public List<Token> getTokens() {
        return tokens;
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

    public int getNumberOfCoinsAtHome() {
        int numberOfCoinsAtHome = 0;
        for (Token token : tokens) {
            if (token.isAtHome()) {
                numberOfCoinsAtHome++;
            }
        }
        return numberOfCoinsAtHome;
    }

}
