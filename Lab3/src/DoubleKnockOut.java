//Prince Ezeoma - Student ID: 49327960
/**
 * This program is a two player interactive game called Double Knock Out.
 * It takes two players taking turns rolling a die and trying to knock out
 * the numbered tiles 1-6 before the other player does.
 * Created on March 14th, 2026
 */

import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.*;

public class DoubleKnockOut extends PApplet {

    int gameState = 0;
    int[] player1 = new int[6];
    int[] player2 = new int[6];
    int currentPlayer = 1;
    int die = 0;
    boolean rolled = false;

    PImage[] dieImages = new PImage[6];
    PImage rollImage;

    SoundFile ClickSound;
    SoundFile DiceRoll;
    SoundFile ErrorSound;
    SoundFile WinSound;

    public static void main(String[] args){
        PApplet.main("DoubleKnockOut");
    }

    public void settings(){
        size(800,500);
    }

    public void setup(){
        textAlign(CENTER, CENTER);
        textSize(18);

        for(int i = 0; i < 6; i++){
            dieImages[i] = loadImage("die" + (i+1) + ".png");
            dieImages[i].resize(60,60);
        }

        rollImage = loadImage("dieClick.png");
        rollImage.resize(80,80);


        DiceRoll = new SoundFile(this, "DiceRoll.mp3");
        ErrorSound = new SoundFile(this, "Error.mp3");
        WinSound = new SoundFile(this, "WinSound.mp3");
        ClickSound = new SoundFile(this, "ClickSound.mp3");
    }

    public void draw(){

        if(gameState == 0){
            drawWelcome();
        }
        else if(gameState == 1){
            drawGame();
        }
        else{
            drawGameOver();
        }
    }

    void drawWelcome(){
        background(0);

        fill(255);
        textSize(40);
        text("Welcome to KnockOut!", width/2, height/2);

        textSize(20);
        text("Click to Start", width/2, height/2 + 50);
    }

    void drawGame(){
        background(240);

        fill(0);
        textSize(26);
        text("Double Knock Out", width/2, 40);

        textSize(16);

        if(currentPlayer == 1){
            fill(200,0,200);
        } else {
            fill(0);
        }
        text("• Player 1", 80, 100);

        if(currentPlayer == 2){
            fill(200,0,200);
        } else {
            fill(0);
        }
        text("• Player 2", 80, 250);
        drawBoard(player1, 120);
        drawBoard(player2, 270);

        if(!rolled){
            image(rollImage, width - 120, 150);
        } else {
            image(dieImages[die - 1], width - 120, 150);
        }
    }

    void drawBoard(int[] player, int y){

        for(int i = 0; i < 6; i++){

            if(player[i] == 0){
                fill(50,117,168);
            } else {
                fill(150);
            }

            rect(140 + i*80, y, 60, 80);

            fill(0);
            text(i+1, 170 + i*80, y + 40);
        }
    }

    void drawGameOver(){
        background(240);

        fill(0,255,150);
        rect(width/2 - 150, height/2 - 80, 300, 160);

        fill(0);
        textSize(28);

        int winner = (currentPlayer == 1) ? 2 : 1;

        text("Game Over!!", width/2, height/2 - 20);
        text("Player " + winner + " Wins!", width/2, height/2 + 30);
    }

    void rollDie(){
        die = (int) random(6) + 1;
    }

    public void mousePressed(){
        if(gameState == 0){
            gameState = 1;
            return;
        }

        if(gameState == 1){
            if(!rolled){
                if(mouseX > width - 120 && mouseX < width - 40 &&
                        mouseY > 150 && mouseY < 230){

                    rollDie();
                    DiceRoll.play();
                    rolled = true;
                    return;
                }
            }

            for(int i = 0; i < 6; i++){

                int x = 140 + i*80;
                int y = (currentPlayer == 1) ? 120 : 270;

                if(mouseX > x && mouseX < x+60 &&
                        mouseY > y && mouseY < y+80){

                    handleMove(i);
                }
            }
        }
    }

    void handleMove(int index){

        int[] player = (currentPlayer == 1) ? player1 : player2;
        if(index + 1 != die){
            ErrorSound.play();
            rolled = false;
            switchPlayer();
            return;
        }
        if(player[index] == 1){
            ErrorSound.play();
            rolled = false;
            switchPlayer();
            return;
        }
        player[index] = 1;
        ClickSound.play();

        if(checkWin(player)){
            WinSound.play();
            gameState = 2;
        }

        rolled = false;
        switchPlayer();
    }

    void switchPlayer(){
        currentPlayer = (currentPlayer == 1) ? 2 : 1;
    }

    boolean checkWin(int[] player){
        for(int i = 0; i < 6; i++){
            if(player[i] == 0){
                return false;
            }
        }
        return true;
    }
}