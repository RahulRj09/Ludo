package ludo;

import model.Yard;

import java.util.List;
import java.util.Scanner;

public class Player {
    private Yard yard;
    private List<Token> tokens;
    private Dice dice;
    private int numberOfCoinsOut = -1;
    private Scanner scanner = new Scanner(System.in);

    public Player(Yard yard) {
        this.yard = yard;
        this.tokens = yard.getTokens();
        this.dice = new Dice();
    }

    public void moveACoin(int coinToMove, int numberOnDice) {
        int i = numberOnDice + tokens.get(coinToMove).getPosition();
        if (i > yard.getEndingPosition()) {
            System.out.println("not valid move");
            if (getNumberOfCoinsAtHome() < 3) {
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
            if (numberOnDice == 6) {
                play();
            }
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
            int coinToMove = takeInput();
            moveACoin(coinToMove, numberOnDice);
        }

        if (numberOnDice == 6 && numberOfCoinsAtHome != 4) {
            System.out.println("What do you want to do?");
            System.out.println("1. Move existing coin");
            System.out.println("2. Take out a coin");
            int userChoice = scanner.nextInt();
            if (userChoice == 1) {
                int coinToMove = takeInput();
                moveACoin(coinToMove, numberOnDice);
            } else {
                moveACoinOut();
            }
        } else if (numberOfCoinsAtHome != 4) {
            int coinToMove = takeInput();
            moveACoin(coinToMove, numberOnDice);
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

    private int takeInput() {
        System.out.println("Which coin do you want to move?");
        return scanner.nextInt();
    }
}
