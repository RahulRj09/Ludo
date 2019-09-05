package ludo;

import model.Home;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Home> colors = new ArrayList<>();
    private int red = 0;
    private int green = 0;

    void add(Home home) {
        colors.add(home);
    }

    public boolean checkWinner() {
        winner();
        if (this.red == 1 || this.green == 1) {
            return true;
        }
        return false;
    }

    private void winner() {
        for (Home home : colors) {
            if (home.getColor().equals("Red")) {
                this.red += 1;
            }
            if (home.getColor().equals("Green")) {
                this.green += 1;
            }
        }
    }
}
