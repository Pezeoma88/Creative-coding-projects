//Prince Ezeoma - Student ID: 49327960
/**
 * This class handles the user input using keyPressed
 * controls like S: to spin the slot machine, D: to deposit $20
 * and C: to cash out the remaining balance which will print in the console.
 * Created on April 13th, 2026
 */
import processing.core.PApplet;
public class SlotsUI extends PApplet{
    private SlotMachine sm;

    public static void main(String[] args){
        PApplet.main("SlotsUI");
    }

    public void settings(){
        size(500, 700);
    }

    public void setup(){
        sm = new SlotMachine();
        textSize(28);
    }

    public void draw(){
        background(230);
        fill(0);
        textSize(40);
        text("Slot Machine", 120, 70);

        textSize(22);
        text("S: Spin", 80, 150);
        text("D: Deposit $20", 80, 190);
        text("C: Cash Out", 80, 230);

        sm.draw(this);
    }

    public void keyPressed(){
        System.out.println("Key pressed: " + key);

        if (key == 'd' || key == 'D'){
            sm.insertMoney(20);
        }
        else if (key == 's' || key == 'S'){
            if (sm.getBalance() >= 5){
                sm.play(5);
            }
        }
        else if (key == 'c' || key == 'C'){
            sm.dispense();
        }
    }
}