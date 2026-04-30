//Prince Ezeoma - Student ID: 49327960
/**
 * This program represents the MoneyHandler object
 * that tracks the player's balance and handles the money adding,
 * deducting and dispensing funds that displays the current balance.
 * Prints the voucher payout when the user cashes out.
 * Created on April 20th, 2026
 */
import processing.core.PApplet;
public class MoneyHandler {
    private int balance;

    public MoneyHandler(){
        balance = 0;
    }

    public void add(int amount){
        balance += amount;
    }

    public void deduct(int amount){
        balance -= amount;
    }

    public int getBalance(){
        return balance;
    }

    public void setBalance(int balance){
        this.balance = balance;
    }

    public void dispense(){
        printVoucher();
        balance = 0;
    }

    public void printVoucher(){
        System.out.println("---------------------------");
        System.out.println("VOUCHER");
        System.out.println("PAY OUT Balance: $ " + balance);
        System.out.println("---------------------------");
    }

    public void draw(PApplet p){
        p.fill(0);
        p.textSize(18);
        p.text("$ " + balance, 80, 150);
    }

    public String toString(){
        return "Balance: $ " + balance;
    }
}