package ludo;

public enum Color {
    RED(0), GREEN(13), YELLOW(26), BLUE(39);
    private int startingPosition;

    Color(int startingPosition) {
        this.startingPosition = startingPosition;
    }

    public int getStartingPosition() {
        return startingPosition;
    }
}
