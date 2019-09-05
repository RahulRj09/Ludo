package ludo;

import java.util.ArrayList;
import java.util.List;

public class Winner {
    private List<Color> colors = new ArrayList<>();
    private int red = 0;
    private int green = 0;

    void add(Color color) {
        colors.add(color);
    }

    public boolean checkWinner() {
        winner();
        if (this.red == 1 || this.green == 1) {
            return true;
        }
        return false;
    }

    private void winner() {
        for (Color color : colors) {
            if (Color.RED == color) {
                this.red += 1;
            }
            if (Color.GREEN == color) {
                this.green += 1;
            }
        }
    }
}
