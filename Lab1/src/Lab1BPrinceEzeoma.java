//Prince Ezeoma - Student ID: 49327960
/**
 * This program extends Part A using a mouse interaction.
 * When the mouse hovers over the body of the barn it changes
 * the color of the barn to white. When the mouse is away
 * from the barn it returns to its original color.
 * Created on February 14th, 2026
 */
import processing.core.*;

public class Lab1BPrinceEzeoma extends PApplet {
    int barnX = 300;
    int barnY = 170;
    int barnW = 100;
    int barnH = 100;

    public static void main(String[] args){
        PApplet.main("Lab1BPrinceEzeoma");
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
