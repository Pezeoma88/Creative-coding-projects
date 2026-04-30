//Prince Ezeoma - Student ID: 49327960
/**
 *This program draws a simple farm scene using Prcoessing library.
 * The scene includes a sun, sky, grass, barn with a roof,
 * door, windows and a tree.
 * Created on February 12th, 2026
 */

import processing.core.*;

public class Lab1APrinceEzeoma extends PApplet {

    public static void main(String[] args){
        PApplet.main("Lab1APrinceEzeoma");
    }

    public void settings(){
        size(500,400);
    }

    public void setup(){
    }

    public void draw(){
        drawSky();
        drawSun();
        drawGrass();
        drawBarn();
        drawTree();
    }

    void drawSky(){
        background(135,206,235);
    }

    void drawSun(){
        fill(255, 204,0);
        ellipse(80,80,80,80);
    }

    void drawGrass(){
        fill(34, 139, 34);
        rect(0,270,width, 150);
    }

    void drawBarn(){
        fill(199,109,0);
        rect(300, 170, 100, 100);

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
