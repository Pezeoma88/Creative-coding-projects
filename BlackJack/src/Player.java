import processing.core.*;
public class Player {
    private Hand myHand;
    private int yLocation;
    private int money;
    private boolean isHeld;
    private boolean isBusted;
    private PImage moneyImage;

    public Player() {
        myHand = new Hand();
        yLocation = 400;
        money = 1000;
        isHeld = false;
        isBusted = false;
    }

    public void loadMedia(PApplet p) {
        moneyImage = p.loadImage("blackjackmedia" + System.getProperty("file.separator") + "MoneyImage.png");
        moneyImage.resize(200, 50);
        myHand.loadMedia(p);
    }

    public void newGame() {
        //myHand = new Hand();
        myHand.newGame();
        isHeld = false;
        isBusted = false;
    }

    public void hold(){isHeld = true;}
    public boolean getHold(){return isHeld;}
    public void bust(){isBusted = true;}
    public boolean getBusted(){return isBusted;}

    public void addCard(Card c) {
        if (!isHeld && !isBusted)
            myHand.addCard(c);
        if (myHand.getTotal() > 21)
            bust();
    }

    public void winMoney(int x){
        money += x;
    }

    public void bet(int x){
        money -= x;
    }

    public int getTotal(){
        return myHand.getTotal();
    }

    public void draw(PApplet p, boolean gameEnded){
        myHand.draw(p, yLocation, false, gameEnded);
        p.image(moneyImage,50, 565);

        p.fill(0);
        p.textSize(25);
        String s = String.format("$ %, d", money);
        p.text(s,150, 600);

    }

    public String toString() {
        String s = "Player has:\n";
        s = s + myHand.toString();
        return s;
    }
}
