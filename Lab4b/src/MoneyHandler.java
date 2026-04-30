//Prince Ezeoma - Student ID: 49327960
/**
 * This program represents the MoneyHandler object.
 * it tracks the player's balance and handles the money adding,
 * deducting and dispensing funds and printing the voucher payout.
 * Created on April 9th, 2026
 */
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
        System.out.println(" VOUCHER");
        System.out.println(" PAY OUT Balance: $ " + balance);
        System.out.println("---------------------------");
    }

    public void draw(){
        System.out.println(toString());
    }

    public String toString(){
        return " Balance: $ " + balance;
    }
}