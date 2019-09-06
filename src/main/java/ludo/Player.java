package ludo;

import model.Yard;

import java.util.List;
import java.util.Scanner;

public class Player {
    Yard yard;
    private List<Token> tokens;
    private Dice dice;
    private int numberOfCoinsOut = -1;
    private Scanner scanner = new Scanner(System.in);

    public Player(Yard yard) {
        this.yard = yard;
        this.tokens = yard.getTokens();
        this.dice = new Dice();
    }

    public void moveACoin(int numberOnDice) {
        System.out.println("Which coin do you want to move?");
        int coinToMove = scanner.nextInt();
        int position = tokens.get(coinToMove).moveBy(numberOnDice);
        System.out.println(position);
        if (position >= yard.getEndingPosition()) {
            Game.add(yard);
        }
    }

    public void moveACoinOut() {
        numberOfCoinsOut++;
        tokens.get(numberOfCoinsOut).place(yard.getStartingPosition());
    }

    public void play() {
        int numberOnDice = dice.toss();
        int numberOfCoinsAtHome = getNumberOfCoinsAtHome();
        print(numberOnDice, numberOfCoinsAtHome);
        if (numberOnDice == 6 && numberOfCoinsAtHome == 4) {
            moveACoinOut();
        }

        if (numberOnDice == 6 && numberOfCoinsAtHome == 0) {
            moveACoin(numberOnDice);
        }

        if (numberOnDice == 6 && numberOfCoinsAtHome != 4) {
            System.out.println("What do you want to do?");
            System.out.println("1. Move existing coin");
            System.out.println("2. Take out a coin");
            Scanner scanner = new Scanner(System.in);
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                moveACoin(numberOnDice);
            } else {
                moveACoinOut();
            }
        } else if (numberOfCoinsAtHome != 4) {
            moveACoin(numberOnDice);
        }
    }

    private int getNumberOfCoinsAtHome() {
        int numberOfCoinsAtHome = 0;
        for (Token token : tokens) {
            if (token.isAtHome()) {
                numberOfCoinsAtHome++;
            }
        }
        return numberOfCoinsAtHome;
    }

    private void print(int numberOnDice, int numberOfCoinsAtHome) {
        System.out.println("Color " + yard.getColor() +
                " NumberOnDice " + numberOnDice +
                " numberOfCoinsAtHome " + numberOfCoinsAtHome);
    }
}
