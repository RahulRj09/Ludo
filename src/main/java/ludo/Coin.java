package ludo;

public class Coin {
    int position = -1;

    public boolean isAtHome() {
        return position == -1;
    }

    public void place(int startingPosition) {
        position = startingPosition;
    }

    public void moveBy(int numberOnDice) {
        this.position += numberOnDice;
        System.out.println(this.position);
    }
}
