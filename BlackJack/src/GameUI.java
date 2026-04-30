import processing.core.*;

public class GameUI extends PApplet {

    private BlackJack theGame;

    public void settings() {
        size(1200,721);
    }

    public void setup() {
        theGame = new BlackJack();
        // theGame.newGame();
        theGame.loadMedia(this);
    }

    public void draw() {
        background(0,255,100);
        theGame.draw(this);
    }

    public void keyPressed() {
        //theGame.keyPressed(this,key);
    }

    public void mousePressed(){
        theGame.mousePressed(this, mouseX, mouseY);
    }

    public static void main(String[] args) {
        PApplet.main("GameUI");


        /*Deck theDeck = new Deck();
        theDeck.shuffle();
        Dealer theDealer = new Dealer();
        Player thePlayer = new Player();

        theDealer.deal(thePlayer,theDeck);
        theDealer.draw(theDeck);
        theDealer.deal(thePlayer,theDeck);
        theDealer.draw(theDeck);

        System.out.println(theDealer);
        System.out.println(thePlayer);
*/

        /*//Card c1 = new Card(1,"Spades");
        //Card c2 = new Card(1,"Hearts");

        //System.out.println(c1);
        //System.out.println(c2);

        Deck d = new Deck();
        System.out.println(d);

        System.out.println("Shuffling...");
        d.shuffle();
        System.out.println(d);

        System.out.println("Dealing 5 cards...");

        Card c1 = d.deal();
        Card c2 = d.deal();
        Card c3 = d.deal();
        Card c4 = d.deal();
        Card c5 = d.deal();

        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);
        System.out.println(c5);

        Hand player1Hand = new Hand();
        player1Hand.addCard(d.deal());
        Card c6 = d.deal();
        player1Hand.addCard(c6);


        Hand player2Hand = new Hand();
        player2Hand.addCard(d.deal());
        player2Hand.addCard(d.deal());

        System.out.println("Hand 1");
        System.out.println(player1Hand);
        System.out.println("Hand 2");
        System.out.println(player2Hand);
*/

    }
}


