//Prince Ezeoma - Student ID: 49327960
/**
 * This program represents the playingField object of a slot machine.
 * That contains three wheels and spins them and calculate the results.
 * Created on April 13th, 2026
 */
import processing.core.PApplet;
import java.util.ArrayList;

public class PlayingField{
    private int winMultiplier;
    private ArrayList<Wheel> wheels;
    private String result;

    public PlayingField(){
        winMultiplier = 0;
        result = "";
        wheels = new ArrayList<Wheel>();

        wheels.add(new Wheel());
        wheels.add(new Wheel());
        wheels.add(new Wheel());
    }

    public int spin(int bet){
        for (Wheel w : wheels){
            w.spin();
        }

        String first = wheels.get(0).getSpunValue();
        String second = wheels.get(1).getSpunValue();
        String third = wheels.get(2).getSpunValue();

        if (first.equals(second) && second.equals(third)){
            winMultiplier = 3;
            result = "Won 3x";
        }
        else if (first.equals(second) || first.equals(third) || second.equals(third)){
            winMultiplier = 2;
            result = "Won 2x";
        } else{
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
        p.textSize(28);

        if (!wheels.get(0).getSpunValue().equals("")){
            p.text(wheels.get(0).getSpunValue(), 110, 430);
            p.text(wheels.get(1).getSpunValue(), 230, 430);
            p.text(wheels.get(2).getSpunValue(), 360, 430);

            p.textSize(24);
            p.text(result, 110, 510);
        }
    }

    public String toString(){
        String output = "";

        for (Wheel w : wheels){
            output += w.toString() + " ";
        }

        return output;
    }
}