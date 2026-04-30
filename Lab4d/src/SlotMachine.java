//Prince Ezeoma - Student ID: 49327960
/**
 * This program represents the slotMachine object
 * that takes the PlayingField and MoneyHandler classes to manages the spinning,
 * winnings, cash out and displays the balance.
 * Created on April 20th, 2026
 */
import processing.core.PApplet;
import processing.core.PImage;

public class SlotMachine{
    private MoneyHandler theMoney;
    private PlayingField playingField;

    public SlotMachine(){
        theMoney = new MoneyHandler();
        playingField = new PlayingField();
    }

    public void loadMedia(PImage appleImage, PImage bananaImage, PImage grapesImage, PImage pearImage){
        playingField.loadMedia(appleImage, bananaImage, grapesImage, pearImage);
    }

    public void insertMoney(int amount){
        theMoney.add(amount);
    }

    public void dispense(){
        theMoney.dispense();
    }

    public int getBalance(){
        return theMoney.getBalance();
    }

    public String getResult(){
        return playingField.getResult();
    }

    public void play(int bet){
        theMoney.deduct(bet);
        int winnings = playingField.spin(bet);
        theMoney.add(winnings);
    }

    public void draw(PApplet p){
        playingField.draw(p);
        theMoney.draw(p);
    }
}