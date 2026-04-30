import processing.core.*;
public class Dealer {

    private Hand myHand;
    private int yLocation;
    private boolean isHeld;
    private boolean isBusted;

    public Dealer(){
        myHand = new Hand();
        //myHand.newGame();
        yLocation = 100;
        isHeld = false;
        isBusted = false;
    }

    public void hold(){isHeld = true;}
    public boolean getHold(){return isHeld;}
    public void bust(){isBusted = true;}
    public boolean getBusted(){return isBusted;}

    public void newGame() {
        //myHand = new Hand();
        myHand.newGame();
        isHeld = false;
        isBusted = false;
    }

    public void loadMedia(PApplet p) {
        myHand.loadMedia(p);
    }

    public void deal(Player p, Deck d){
        Card c = d.deal();
        p.addCard(c);
    }
    public void drawCard(Deck d){
        if (!isHeld && !isBusted) {
            Card c = d.deal();
            myHand.addCard(c);
        }
        if (myHand.getTotal() > 21)
            bust();
        else if (myHand.getTotal() >= 17)
            hold();
    }

    public int getTotal(){
        return myHand.getTotal();
    }

    public void draw(PApplet p, boolean gameEnded){
        myHand.draw(p,yLocation, true, gameEnded);
    }
    public String toString(){
        String s = "Dealer has: \n";
        s += myHand.toString();
        return s;
    }
}