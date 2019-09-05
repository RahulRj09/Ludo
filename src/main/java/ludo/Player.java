package ludo;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Player {
    private List<Coin> coins;
    Color color;
    private Dice dice;
    private Winner winner;
    private int numberOfCoinsOut = -1;
    private Scanner scanner = new Scanner(System.in);

    public Player(Color color) {
        this.color = color;
        this.coins = Arrays.asList(new Coin(), new Coin(), new Coin(), new Coin());
        this.dice = new Dice();
        this.winner = new Winner();
    }

    public void moveACoin(int numberOnDice) {
        System.out.println("Which coin do you want to move?");
        int coinToMove = scanner.nextInt();
        int position = coins.get(coinToMove).moveBy(numberOnDice);
        System.out.println(position);
        if (position >= color.getEndingPosition()) {
            winner.add(color);
        }
    }

    public void moveACoinOut() {
        numberOfCoinsOut++;
        coins.get(numberOfCoinsOut).place(color.getStartingPosition());
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
        for (Coin coin : coins) {
            if (coin.isAtHome()) {
                numberOfCoinsAtHome++;
            }
        }
        return numberOfCoinsAtHome;
    }

    private void print(int numberOnDice, int numberOfCoinsAtHome) {
        System.out.println("Color " + color + " NumberOnDice " + numberOnDice + " numberOfCoinsAtHome " + numberOfCoinsAtHome);
    }

    public boolean hasWon() {
        return winner.checkWinner();
    }
}
