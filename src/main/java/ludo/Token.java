package ludo;

public class Token {
    int position = -1;

    public boolean isAtHome() {
        return position == -1;
    }

    public void place(int startingPosition) {
        position = startingPosition;
    }

    public int moveBy(int numberOnDice) {
        this.position += numberOnDice;
        return this.position;
    }

    public int getPosition() {
        return position;
    }
}
