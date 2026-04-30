import processing.core.PApplet;
import java.util.ArrayList;
import java.util.Random;

public class Deck {
    private int location;
    private ArrayList<Card> cards;

    public Deck() {
        location = 0;
        cards = new ArrayList<Card>();
        createCards();
    }

    public void loadMedia(PApplet p) {
        for (Card aCard : cards) {
            aCard.loadMedia(p);
            /* for (int i = 0; i < cards.size(); i++){
                cards.get(i).loadMedia(p);
            } */
        }
    }

    public void createCards() {
        String[] suits = {"Spades", "Clubs", "Hearts", "Diamonds"};
        for(int a = 0; a < 4; a++) {
            for (int i = 1; i <= 13; i++) {
                Card c = new Card(i, suits[a]);
                cards.add(c);
            }
        }
    }

    public int getLocation() {
        return location;
    }
    public void setLocation(int x) {
        location = x;
    }


    public void shuffle() {
        Random rand = new Random();
        for(int a = 1; a <= 1000; a++) {
            for (int i = 0; i < cards.size(); i++) {
                Card card1 = cards.get(i);
                int randomIndex = rand.nextInt(52);
                Card card2 = cards.get(randomIndex);
                cards.set(i, card2);
                cards.set(randomIndex, card1);
            }
        }
        location = 0;
    }

    public Card deal() {
        Card c = cards.get(location);
        location++;
        return c;
    }


    public String toString() {
        String s = "Deck at location " + location + "\n";
        for(int i = 0; i < cards.size() ; i++)
            s += cards.get(i) + "\n";
        return s;
    }
}
