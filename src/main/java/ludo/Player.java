package ludo;

import model.Home;

import java.util.List;
import java.util.Scanner;

public class Player {
    Home home;
    List<Coin> coins;
    private Dice dice;
    private Winner winner;
    private int numberOfCoinsOut = -1;
    private Scanner scanner = new Scanner(System.in);

    public Player(Home home) {
        this.home = home;
        this.coins = home.getCoins();
        this.dice = new Dice();
        this.winner = new Winner();
    }

    public void moveACoin(int numberOnDice) {
        System.out.println("Which coin do you want to move?");
        int coinToMove = scanner.nextInt();
        int position = coins.get(coinToMove).moveBy(numberOnDice);
        System.out.println(position);
        if (position >= home.getEndingPosition()) {
            winner.add(home);
        }
    }

    public void moveACoinOut() {
        numberOfCoinsOut++;
        coins.get(numberOfCoinsOut).place(home.getStartingPosition());
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
        System.out.println("Color " + home.getColor() + " NumberOnDice " + numberOnDice + " numberOfCoinsAtHome " + numberOfCoinsAtHome);
    }

    public boolean hasWon() {
        return winner.checkWinner();
    }
}
