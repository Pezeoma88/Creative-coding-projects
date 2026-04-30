import processing.core.*;
public class BlackJack {
    private Deck theDeck;
    private Player thePlayer;
    private Dealer theDealer;
    private int betAmount = 10;
    private boolean gameStarted = false;
    private boolean gameEnded = false;
    private String result = " ";
    private PImage tableImage;
    private PImage dealButton;
    private PImage hitButton;
    private PImage holdButton;


    public BlackJack() {
        theDeck = new Deck();
        thePlayer = new Player();
        theDealer = new Dealer();
    }

    public void loadMedia(PApplet p) {
        tableImage = p.loadImage("blackjackmedia" + System.getProperty("file.separator") + "BlackjackTable.png");
        dealButton = p.loadImage("blackjackmedia" + System.getProperty("file.separator") + "DealButton.png");
        hitButton = p.loadImage("blackjackmedia" + System.getProperty("file.separator") + "HitButton.png");
        holdButton = p.loadImage("blackjackmedia" + System.getProperty("file.separator") + "HoldButton.png");
        dealButton.resize(200, 80);
        hitButton.resize(200, 80);
        holdButton.resize(200, 80);
        theDeck.loadMedia(p);
        thePlayer.loadMedia(p);
        theDealer.loadMedia(p);
    }

    public void newGame() {
        result = "";
        theDeck.shuffle();
        //gameStarted = true;
        gameEnded = false;
        thePlayer.bet(betAmount);
        theDeck.shuffle();
        thePlayer.newGame();
        theDealer.newGame();
        for(int i = 1; i <= 2; i++) {
            theDealer.deal(thePlayer,theDeck);
            theDealer.drawCard(theDeck);
        }
        checkForBlackJack();
    }

    public void draw(PApplet p) {
        p.image(tableImage, 0,0);
        if (!gameStarted || gameEnded)
            p.image(dealButton,50, 75);
        else {
            p.image(hitButton,50, 400);
            p.image(holdButton,50, 480);
        }

        thePlayer.draw(p, gameEnded);
        theDealer.draw(p, gameEnded);
        //drawMenu(p);
        p.fill(0);
        p.textSize(25);
        p.text(result,200, 650);
    }

    public void drawMenu(PApplet p) {
        p.fill(0);
        p.textSize(25);
        if (!gameStarted || gameEnded) {
            p.text("N: New Game", 50, 100);
        } else {
            p.text("H: Hit", 50, 150);
            p.text("O: Hold", 50, 200);
        }

    }

    public void hit() {
        if (thePlayer.getHold() == false)
            theDealer.deal(thePlayer,theDeck);
        if (theDealer.getHold() == false && theDealer.getBusted() == false)
            theDealer.drawCard(theDeck);
        checkForWinner();
    }

    public void hold() {
        thePlayer.hold();
        while(theDealer.getHold() == false && theDealer.getBusted() == false)
            theDealer.drawCard(theDeck);
        checkForWinner();
    }

    public void checkForBlackJack() {
        if (thePlayer.getTotal() == 21 && theDealer.getTotal() == 21) {
            endGame("Push (tie) - both Blackjack");
        } else if (thePlayer.getTotal() == 21) {
            thePlayer.winMoney(betAmount * 3);
            endGame("Player won with Blackjack");
        } else if (theDealer.getTotal() == 21) {
            endGame("Dealer won with Blackjack");
        }
    }
    public void endGame(String s) {
        result = s;
        gameEnded = true;
        gameStarted = false;
    }

    public void checkForWinner() {
        if (thePlayer.getBusted() && theDealer.getBusted()) {
            thePlayer.winMoney(betAmount);
            endGame("Tie both busted");

        } else if (theDealer.getBusted()) {
            thePlayer.winMoney(betAmount * 2);
            endGame("Dealer busted -  player won");

        } else if (thePlayer.getBusted()) {
            gameEnded = true;
            endGame("Player busted - dealer won");

        } else if (thePlayer.getHold() && theDealer.getHold()) {
            int playerValue = thePlayer.getTotal();
            int dealerValue = theDealer.getTotal();
            if (playerValue == dealerValue) {
                thePlayer.winMoney(betAmount);
                endGame("Push(tie)");
            } else if (playerValue > dealerValue) {
                thePlayer.winMoney(betAmount * 2);
                endGame("Player won");
            } else if (playerValue > dealerValue) {
                endGame("Player lost");
            }
        }
    }

    public void mousePressed(PApplet p, int x, int y) {
        //button is 200x80;
        //located at 50,75

        //hit 50, 400 hold 50, 480 size is 200x80

        if (x >= 50 && x <= 250 && y >= 75 && y <= 155){
            if (!gameStarted || gameEnded) {
                gameStarted = true;
                newGame();
            }
        }
        //hit button
        if (x >= 50 && x <= 250 && y >= 400 && y <= 480){
            hit();
            //hold button
            if (x >= 50 && x <= 250 && y >= 480 && y <= 560){
                hold();
            }
        }
    }

    public void keyPressed(PApplet p, char c) {
        p.println("Game started" + gameStarted);
        p.println("Game ended" + gameEnded);

        if (gameStarted)
            if (c == 'n' || c == 'N' && (!gameStarted || gameEnded))
                gameStarted = true;
                newGame();
        if (c == 'h' || c == 'H')
            hit();
        if (c == 'o' || c == 'O')
            hold();
    }

    public String toString() {
        return "The game";
    }
}
