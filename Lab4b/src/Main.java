//Prince Ezeoma - Student ID: 49327960
/**
 * This program simulates a slot machine game with 10 spins.
 * If the winner wins multiple times the balance will increase
 * and if the winner loses the balance decreases.
 * It checks the balances of each spin and displays
 * the last remaining amount for the voucher pay out.
 * Created on April 6th, 2026
 */
public class Main {
    public static void main(String[] args) {
        SlotMachine sm = new SlotMachine();
        int bet = 5;
        int balance = 100;
        sm.insertMoney(balance);
        for(int i = 1; i <= 10; i++ ) {
            System.out.println(" Balance: $" + sm.getBalance());
            System.out.println(" Spinning with $" + bet + " bet");
            sm.play(bet);
            System.out.println(sm.getResult());
            sm.draw();
            System.out.println();
        }
        sm.dispense();
    }
}
