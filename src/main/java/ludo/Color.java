package ludo;

public enum Color {
    RED(0, 57), GREEN(13, 70), YELLOW(26, 83), BLUE(39, 96);
    private int startingPosition;
    private int endingPosition;

    Color(int startingPosition, int endingPosition) {
        this.startingPosition = startingPosition;
        this.endingPosition = endingPosition;
    }

    public int getEndingPosition() {
        return endingPosition;
    }

    public int getStartingPosition() {
        return startingPosition;
    }
}
