//Prince Ezeoma - Student ID: 49327960
/**
 * This program simulates a dice game where the user rolls a
 * die and knocks out the numbered tiles. The user clicks the mouse
 * to roll the die values from 1 to 6 and types a key to match the number.
 * The game continues until the user rolls the die and enters the number.
 * Created on February 27th, 2026
 */

import processing.core.PApplet;
public class Lab2Version1PrinceEzeoma extends PApplet {
    int[] playerValues = new int[6];
    int die = 0;
    boolean rolled = false;
    String message1 = " ";
    String message2 = " Click anywhere to roll ";
    boolean gameOver = false;

    public static void main(String[] args){
        PApplet.main("Lab2Version1PrinceEzeoma");
    }
    public void settings() {
        size(600, 400);
    }
    public void setup(){
        textAlign(CENTER);
        textSize(20);
    }
    public void draw(){
        if (gameOver) {
            background(255);
            fill(0);
            textSize(60);
            textAlign(CENTER, CENTER);
            text("GAME OVER!", width / 2, height / 2);

        } else {

            background(240);
            drawBoard();
       }
    }

    void rollDie(){
        die = (int) random(6) + 1;
    }

    void drawBoard(){
        fill(0);
        textSize(20);
        text(message1, width/2, 40);
        text(message2, width/2, 70);

        for (int i = 0; i<6; i++){
            if (playerValues[i] == 0){
                fill(0,120,255);
            } else {
                fill(150);
            }
            rect(80 + i * 80, 150, 60, 100);

            fill(0);
            text(i + 1, 110 + i * 80, 210);
        }
        if (rolled){
            textSize(40);
            fill(0);
            text(die, width/2, 330);
        }
    }

    void checkForWinner(){
        boolean allKnockedOut = true;
        for (int i = 0; i < 6; i++){
            if (playerValues[i] == 0){
                allKnockedOut = false;
            }
        }
        if (allKnockedOut){
            gameOver = true;
        }
    }
    public void mousePressed(){
        if (!rolled && !gameOver){
            rollDie();
            rolled = true;
            message1 = " Enter a title # to knock out ";
            message2 = " ";
        }
    }
    public void keyPressed(){
        if (rolled && !gameOver){
            int input = key - '0';
            if (input < 0 || input > 6){
                message1 = " Invalid input! ";
                return;
            }
            if (input != die){
                message1 = " Invalid selection ";
                return;
            }
            if (playerValues[input - 1] == 1){
                message1 = input + " already knocked out ";
                rolled = false;
                message2 = " Click anywhere to roll ";
                return;
            }
            playerValues[input - 1] = 1;
            message1 = input + " knocked out ";
            message2 = " Click anywhere to roll ";
            rolled = false;
            checkForWinner();
        }
    }
}
