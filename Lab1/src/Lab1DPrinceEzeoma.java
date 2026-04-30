//Prince Ezeoma - Student ID: 49327960
/**
 * This program extends Part C using user interaction.
 * Just like in Part C it starts out dark and the sun doesn't move.
 * When clicking the sunrise animation starts.
 * Created on February 16th, 2026
 */

import processing.core.*;

public class Lab1DPrinceEzeoma extends PApplet {
    int barnX = 300;
    int barnY = 170;
    int barnW = 100;
    int barnH = 100;

    float sunY = 300;
    float sunSpeed = 0.5f;

    float skyR = 0;
    float skyG = 0;
    float skyB = 0;

    boolean startSunrise = false;

    public static void main(String[] args){
        PApplet.main("Lab1DPrinceEzeoma");
    }

    public void settings(){
        size(500,400);
    }

    public void setup(){
    }

    public void draw(){
      if (startSunrise) {
          SunSet();
          NewSky();
      }

        drawSky();
        drawSun();
        drawGrass();
        drawBarn();
        drawTree();
    }

    public void mouseClicked(){
        startSunrise = true;
    }

    void SunSet(){
        if (sunY > 0){
            sunY -= sunSpeed;
        }
    }

    void NewSky(){
        if(skyG < 206) skyG += 0.2f;
        if(skyB < 235) skyB += 0.25f;
    }

    void drawSky(){
        background(skyR,skyG,skyB);
    }
    void drawSun(){
        fill(255, 204,0);
        ellipse(80,sunY,80,80);
    }

    void drawGrass(){
        fill(34, 139, 34);
        rect(0,270,width, 150);
    }

    void drawBarn(){
        boolean mouseOverBarn =
                mouseX >= barnX &&
                        mouseX <= barnX + barnW &&
                        mouseY >= barnY &&
                        mouseY <= barnY + barnH;

        if (mouseOverBarn){
            fill(255);
        } else {
            fill(199, 109, 0);
        }
        rect(barnX,barnY,barnW, barnH);

        fill(31, 0, 0);
        triangle(290, 170,410,170, 350, 110);

        fill(139, 69, 19);
        rect(335,210, 30, 60);

        fill(173, 216, 230);
        rect(320, 185, 20, 20);

        fill(173, 216, 230);
        rect(360, 185, 20, 20);
    }

    void drawTree(){
        fill(101,67,33);
        rect(120,220,20,50);

        fill(0,128,0);
        ellipse(130,190,60,60);
    }
}
