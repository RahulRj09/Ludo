package ludo;


public class Cell {
    int id;
    Token token;

    public Cell(int id) {
        this.id = id;
    }

    public void setTokens(Token token) {
        this.token = token;
    }
}
