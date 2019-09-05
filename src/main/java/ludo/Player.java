package ludo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Player {
    List<Coin> coins = new ArrayList<>();
    Color color;
    Dice dice;
    private int numberOfCoinsOut = -1;

    public Player(Color color) {
        this.color = color;
        for (int i = 0; i <= 3; i++) { // todo find alternative way of this
            Coin coin = new Coin();
            this.coins.add(coin);
        }
        dice = new Dice();
    }

    public void moveACoin(int numberOnDice) {
        System.out.println("Which coin do you want to move?");
        Scanner scanner = new Scanner(System.in);
        int coinToMove = scanner.nextInt();
        coins.get(coinToMove).moveBy(numberOnDice);
    }

    public void moveACoinOut() {
        numberOfCoinsOut++;
        coins.get(numberOfCoinsOut).place(color.getStartingPosition());
    }

    public void play() {
        int numberOnDice = dice.toss();
        int numberOfCoinsAtHome = 0;
        for (Coin coin : coins) {
            if (coin.isAtHome()) {
                numberOfCoinsAtHome++;
            }
        }
        System.out.println("Color "+color+" NumberOnDice "+numberOnDice+" numberOfCoinsAtHome "+numberOfCoinsAtHome);
        if (numberOnDice == 6 && numberOfCoinsAtHome == 4) {
            moveACoinOut();
        }

        if (numberOnDice == 6 && numberOfCoinsAtHome == 0) {
            moveACoin(numberOnDice);
        }

        if (numberOnDice == 6 && numberOfCoinsAtHome !=4) {
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
        }else if(numberOfCoinsAtHome !=4){
            moveACoin(numberOnDice);
        }
    }

}
