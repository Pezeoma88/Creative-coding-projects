//Prince Ezeoma - Student ID: 49327960
/**
 * This Program takes the contents from Version 1 and uses the same process
 * where the user rolls a die and tries to knock out the numbered titles.
 * But instead of showing the numbers and what to enter.
 * The user sees an image of a dice and clicks the mouse
 * to roll the die values from 1 to 6 and enters a number based on the dice image
 * of what number it landed on after it rolled.
 * Created on March 3rd, 2026
 */

import processing.core.PApplet;
import processing.core.PImage;

public class Lab2Version2PrinceEzeoma extends PApplet {

    PImage[] dieImages = new PImage[6];
    int[] playerValues = new int[6];
    int die = 0;
    boolean rolled = false;
    String message1 = "";
    String message2 = " Click anywhere to roll ";
    boolean gameOver = false;

    public static void main(String[] args){
        PApplet.main("Lab2Version2PrinceEzeoma");
    }

    public void settings() {
        size(600, 400);
    }

    public void setup(){
        textAlign(CENTER);
        textSize(20);

        for (int i = 0; i < 6; i++){
            dieImages[i] = loadImage("die" + (i + 1) + ".png");
            dieImages[i].resize(80, 80);
        }
    }

    public void draw(){
        if (gameOver) {
            background(255);
            fill(0);
            textAlign(CENTER, CENTER);
            textSize(60);
            text(" GAME OVER! ", width / 2, height / 2);
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
        textAlign(CENTER);
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
            image(dieImages[die - 1], width/2 - 40, 280);
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
            message1 = " Enter a tile # to knock out ";
            message2 = "";
        }
    }

    public void keyPressed(){
        if (rolled && !gameOver){
            int input = key - '0';

            if (input < 1 || input > 6){
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

