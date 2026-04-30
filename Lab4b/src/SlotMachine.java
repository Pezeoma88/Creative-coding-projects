//Prince Ezeoma - Student ID: 49327960
/**
 * This program represents the slotMachine object.
 * it takes the Playfield and MoneyHandler classes to
 * manage the game, bets, wins, and balance displays
 * Created on April 9th, 2026
 */
public class SlotMachine {
    private MoneyHandler theMoney;
    private PlayingField playingField;

    public SlotMachine(){
        theMoney = new MoneyHandler();
        playingField = new PlayingField();
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

    public void draw(){
        playingField.draw();
        theMoney.draw();
    }
}