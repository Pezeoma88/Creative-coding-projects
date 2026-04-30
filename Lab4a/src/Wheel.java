//Prince Ezeoma - Student ID: 49327960
/**
 * This program represents a wheel object for the slop machine.
 * Each wheel has an ArrayList of tokens and can be spun to a random token.
 * Created on March 29th, 2026
 */

import java.util.ArrayList;
public class Wheel {
    private String spunValue = " ";
    private ArrayList<Token> tokens;

    public Wheel() {
        tokens = new ArrayList<Token>();
        tokens.add(new Token(" Apple "));
        tokens.add(new Token(" Banana "));
        tokens.add(new Token(" Pear "));
        tokens.add(new Token(" Grapes "));
    }

    public String getSpunValue() {
        return spunValue;
    }

    public void setSpunValue(String spunValue) {
        this.spunValue = spunValue;
    }

    public String spin() {
        int randomIndex = (int)(Math.random() * 4);
        spunValue = tokens.get(randomIndex).getLabel();
        return spunValue;
    }

    public boolean equals(Token t) {
        return spunValue.equals(t.getLabel());
    }

    public String toString() {
        return spunValue;
    }
}
