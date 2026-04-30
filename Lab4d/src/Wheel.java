//Prince Ezeoma - Student ID: 49327960
/**
 * This program represents a slot machine wheel and randomly selects a
 * token when it spins and matches the token image.
 * Created on April 21st, 2026
 */
import processing.core.PApplet;
import processing.core.PImage;
import java.util.ArrayList;

public class Wheel {
    private String spunValue;
    private ArrayList<Token> tokens;

    private PImage appleImage;
    private PImage bananaImage;
    private PImage grapesImage;
    private PImage pearImage;

    public Wheel(){
        spunValue = "";
        tokens = new ArrayList<Token>();

        tokens.add(new Token("Apple"));
        tokens.add(new Token("Banana"));
        tokens.add(new Token("Grapes"));
        tokens.add(new Token("Pear"));
    }

    public void loadMedia(PImage appleImage, PImage bananaImage, PImage grapesImage, PImage pearImage){
        this.appleImage = appleImage;
        this.bananaImage = bananaImage;
        this.grapesImage = grapesImage;
        this.pearImage = pearImage;
    }

    public String getSpunValue(){
        return spunValue;
    }

    public void setSpunValue(String spunValue){
        this.spunValue = spunValue;
    }

    public String spin(){
        int randomIndex = (int)(Math.random() * tokens.size());
        spunValue = tokens.get(randomIndex).getLabel();
        return spunValue;
    }

    public boolean equals(Token other){
        return spunValue.equals(other.getLabel());
    }

    public void draw(PApplet p, int x, int y, int w, int h){
        if(spunValue.equals("Apple")){
            p.image(appleImage, x, y, w, h);
        }
        else if(spunValue.equals("Banana")){
            p.image(bananaImage, x, y, w, h);
        }
        else if(spunValue.equals("Grapes")){
            p.image(grapesImage, x, y, w, h);
        }
        else if(spunValue.equals("Pear")){
            p.image(pearImage, x, y, w, h);
        }
    }

    public String toString(){
        return spunValue;
    }
}
