import java.util.ArrayList;
import processing.core.*;
public class Hand {
    private ArrayList<Card> cards;
    private int total;
    private PImage cardBackImage;

    public Hand(){
        cards = new ArrayList<Card>();
    }

    public void newGame(){
       cards.clear();
       total = 0;
    }

    public void loadMedia(PApplet p) {
        cardBackImage =  p.loadImage("blackjackmedia" + System.getProperty("file.separator") + "Card-back.jpg");
    }
    public void setTotal(int x){
        total = x;
    }
    public int getTotal(){
        return total;
    }
    public int calculateTotal() {
        total = 0;
        boolean hasAce = false;
        for (int i = 0; i < cards.size(); i++) {
            Card c = cards.get(i);
            if(c.getScoreValue() == 1)
                hasAce = true;
            total = total + c.getScoreValue();
        }
        if (total < 12 && hasAce ==  true) {
            total += 10;
        }
        return total;
    }
    public void addCard(Card c){
        cards.add(c);
        calculateTotal();
    }
    public void draw(PApplet p, int yLoc, boolean isDealer, boolean gameEnded){
        int xLoc = 350;
        p.fill(0);
        p.textSize(20);

        if (cards.size() > 0) {
            if (isDealer) {
                if (!gameEnded)
                    //p.text("???", xLoc, yLoc);
                    p.image(cardBackImage, xLoc, yLoc);
                else
                    cards.get(0).draw(p,xLoc,yLoc);
                xLoc += 175;
            } else {

                cards.get(0).draw(p, xLoc, yLoc);
                xLoc += 175;
            }
        }

        for (int i = 1; i < cards.size(); i++){
            cards.get(i).draw(p, xLoc, yLoc);
            // p.println("X="+xLoc + " y="+yLoc);
            xLoc += 175;
        }
        //for testing
        //p.fill(255, 0, 0);
        //p.textSize(25);
        //p.text(total, 200, yLoc);

    }

    public String toString(){
        String s = "Hand contents: \n";
        for (int i = 0; i < cards.size(); i++){
            s += cards.get(i) + "\n";
        }
        s += "Total: " + total + "\n";
        return s;
    }
}
