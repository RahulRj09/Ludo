package ludo;

import model.Yard;

import java.util.List;
import java.util.Scanner;

public class Player {
    Yard yard;
    private List<Token> tokens;
    private int numberOfCoinsOut = -1;
    private Scanner scanner = new Scanner(System.in);
    final int TOTAL_TOKENS = 4;
    private int numberOnDice;

    public Player(Yard yard) {
        this.yard = yard;
        this.tokens = yard.getTokens();
    }

    public Token moveACoin(int coinToMove, int numberOnDice) {
        int i = numberOnDice + tokens.get(coinToMove).getPosition();
        if (i > yard.getEndingPosition()) {
            System.out.println("not valid move");
            if (yard.getNumberOfCoinsAtHome() < 3) {
                System.out.println("move other's coin");
                int userInput = takeInput();
                moveACoin(userInput, numberOnDice);
            }
        }
        if (i <= yard.getEndingPosition()) {
            int position = tokens.get(coinToMove).moveBy(numberOnDice);
            System.out.println(position);
            if (position == yard.getEndingPosition()) {
                Game.add(yard);
            }
        }
        printAllTokenPosition(tokens);
        return tokens.get(coinToMove);
    }

    private void printAllTokenPosition(List<Token> tokens) {
        for (int i = 0; i < tokens.size(); i++) {
            System.out.println("Token index " + i + " Token Position " + tokens.get(i).getPosition());

        }
    }

    public Token moveACoinOut() {
        numberOfCoinsOut++;
        tokens.get(numberOfCoinsOut).place(yard.getStartingPosition());
        return tokens.get(numberOfCoinsOut);
    }

    public Token play(Dice dice) {
        numberOnDice = dice.roll();
        int numberOfCoinsAtHome = yard.getNumberOfCoinsAtHome();
        print(numberOnDice, numberOfCoinsAtHome);
        if (numberOnDice == 6 && numberOfCoinsAtHome == TOTAL_TOKENS) {
            return moveACoinOut();
        }

        if (numberOnDice == 6 && numberOfCoinsAtHome == 0) {
            int coinToMove = takeInput();
            return moveACoin(coinToMove, numberOnDice);
        }

        if (numberOnDice == 6 && numberOfCoinsAtHome != TOTAL_TOKENS) {
            System.out.println("What do you want to do?");
            System.out.println("1. Move existing coin");
            System.out.println("2. Take out a coin");
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                int coinToMove = takeInput();
                return moveACoin(coinToMove, numberOnDice);
            } else {
                return moveACoinOut();
            }
        } else if (numberOfCoinsAtHome != TOTAL_TOKENS) {
            int coinToMove = takeInput();
            return moveACoin(coinToMove, numberOnDice);
        }
        return null;
    }


    private void print(int numberOnDice, int numberOfCoinsAtHome) {
        System.out.println("Color " + yard.getColor() +
                " NumberOnDice " + numberOnDice +
                " numberOfCoinsAtHome " + numberOfCoinsAtHome);
    }

    private int takeInput() {
        System.out.println("Which coin do you want to move?");
        return scanner.nextInt();
    }

    public int getNumberOnDice() {
        return numberOnDice;
    }
}
