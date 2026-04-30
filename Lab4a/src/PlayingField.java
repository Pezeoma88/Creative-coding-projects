//Prince Ezeoma - Student ID: 49327960
/**
 * This program represents the playing field object of a slot machine.
 * It manages three wheel objects and spins them and calculates the result.
 * Created on March 28th, 2026
 */

import java.util.ArrayList;
public class PlayingField {
    private int winMultiplier = 0;
    private ArrayList<Wheel> wheels;

    public PlayingField() {
        wheels = new ArrayList<Wheel>();
        wheels.add(new Wheel());
        wheels.add(new Wheel());
        wheels.add(new Wheel());
    }

    public int spin(int betAmount) {
        winMultiplier = 0;

        Wheel w1 = wheels.get(0);
        Wheel w2 = wheels.get(1);
        Wheel w3 = wheels.get(2);
        w1.spin();
        w2.spin();
        w3.spin();
        if (w1.equals(new Token(w2.getSpunValue())) && w1.equals(new Token(w3.getSpunValue())))
            winMultiplier = 5;
        else if (w1.equals(new Token(w2.getSpunValue())) || w1.equals(new Token(w3.getSpunValue())) || w2.equals(new Token(w3.getSpunValue())))
            winMultiplier = 2;
        return betAmount * winMultiplier;
    }

    public String getResult() {
        if (winMultiplier == 2)
            return "Won 2x";
        else if (winMultiplier == 5)
            return "Won 5x";
        else
            return "No prize";
    }
    public String toString() {
        return getResult() + " " + wheels.get(0) + " " + wheels.get(1) + " " + wheels.get(2);
    }
}
