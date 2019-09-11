package ludo;


public class Cell {
    private int id;
    private Token token;

    public Cell(int id) {
        this.id = id;
    }

    public void setTokens(Token token) {
        this.token = token;
    }
}
