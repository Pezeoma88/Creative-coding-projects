//Prince Ezeoma - Student ID: 49327960
/**
 * This program simulates a slot machine game with 10 spins.
 * It checks the balance and displays the result after each spin.
 * If the winner wins multiple times the balance will increase
 * and if the winner loses the balance decreases.
 * Created on March 28th, 2026
 */

public class Main {
    public static void main(String[] args) {
        int bet = 5;
        int balance = 100;
        PlayingField pf = new PlayingField();
        for (int i = 1; i <= 10; i++){
            System.out.println("Spin #" + i + ": Balance: $" + balance + " $"  + bet + " bet...");
            int result = pf.spin(bet);
            balance += result - bet;
            System.out.println(pf + " Added: " + result + " New Balance: " + balance + "\n");
        }
    }
}
