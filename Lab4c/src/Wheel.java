//Prince Ezeoma - Student ID: 49327960
/**
 * This program represents a slot machine wheel and randomly selects a
 * tokn when it spins and stores the result.
 * Created on April 13th, 2026
 */
import java.util.ArrayList;
import processing.core.PApplet;
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

    public void draw(PApplet p, int x, int y){
        p.fill(255);
        p.rect(x, y, 80, 80);

        p.fill(0);
        p.text(spunValue, x + 10, y + 50);
    }

    public String toString() {
        return spunValue;
    }
}
