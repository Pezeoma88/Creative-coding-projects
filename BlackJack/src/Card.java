import processing.core.*;
public class Card {
    private int value;
    private String suit;
    private PImage cardImage;

    public Card(int x, String s) {
        value = x;
        suit = s;
    }

    public void loadMedia(PApplet p) {
        cardImage = p.loadImage("blackjackmedia" + System.getProperty("file.separator") +  suit + "-" + value + ".jpg");
    }

    public int getValue() {
        return value;
    }
    public void setValue(int x) {
        value = x;
    }

    public int getScoreValue() {
        int num = 0;
        if(value < 11)
            num = value;
        else
            num = 10;
        return num;
    }

    public void setScoreValue(int x) {
        value = x;
    }

    public String getSuit() {
        return suit;
    }
    public void setSuit(String s) {
        suit = s;
    }

    public void draw(PApplet p, int x, int y) {
        //p.fill(0);
        //p.textSize(20);
        //p.text(toString(), x,y);
        p.image(cardImage, x, y);

    }

    public String toString() {
        String s = "" + value;
        if(value == 11)
            s = "Jack";
        else if(value == 12)
            s = "Queen";
        else if(value == 13)
            s = "King";
        else if(value == 1)
            s = "Ace";
        return s + " of " + suit;
    }
}