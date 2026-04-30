//Prince Ezeoma - Student ID: 49327960
/**
 * This program represents the playingField object of a slot machine.
 * That contains three wheels and spins them and calculate the result
 * and draws the token images.
 * Created on April 21st, 2026
 */
import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

public class PlayingField {
    private int winMultiplier;
    private ArrayList<Wheel> wheels;
    private String result;

    private PImage appleImage;
    private PImage bananaImage;
    private PImage grapesImage;
    private PImage pearImage;

    public PlayingField(){
        winMultiplier = 0;
        result = "";

        wheels = new ArrayList<Wheel>();
        wheels.add(new Wheel());
        wheels.add(new Wheel());
        wheels.add(new Wheel());
    }

    public void loadMedia(PImage appleImage, PImage bananaImage, PImage grapesImage, PImage pearImage){
        this.appleImage = appleImage;
        this.bananaImage = bananaImage;
        this.grapesImage = grapesImage;
        this.pearImage = pearImage;

        for(Wheel w : wheels){
            w.loadMedia(appleImage, bananaImage, grapesImage, pearImage);
            w.spin();
        }
    }

    public int spin(int bet){
        for(Wheel w : wheels){
            w.spin();
        }

        String first = wheels.get(0).getSpunValue();
        String second = wheels.get(1).getSpunValue();
        String third = wheels.get(2).getSpunValue();

        if(first.equals(second) && second.equals(third)){
            winMultiplier = 5;
            result = "Won 5x";
        }
        else if(first.equals(second) || first.equals(third) || second.equals(third)){
            winMultiplier = 2;
            result = "Won 2x";
        }else{
            winMultiplier = 0;
            result = "No prize";
        }

        return bet * winMultiplier;
    }

    public String getResult(){
        return result;
    }

    public void draw(PApplet p){
        p.fill(0);
        p.textSize(18);
        p.text(result, 250, 150);

        wheels.get(0).draw(p, 90, 210, 50, 70);
        wheels.get(1).draw(p, 180, 210, 50, 70);
        wheels.get(2).draw(p, 270, 210, 50, 70);
    }

    public String toString(){
        String output = "";

        for(Wheel w : wheels){
            output += w.toString() + " ";
        }
        return output;
    }
}