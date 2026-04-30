//Prince Ezeoma - Student ID: 49327960
/**
 * This class is the main UI for the slot machine.
 * it displays the slot machine background, token images, result text and current balance.
 * Handles mouse interaction and sound.
 * Created on April 20th, 2026
 */
import processing.core.PApplet;
import processing.core.PImage;
import processing.sound.SoundFile;

public class SlotsUI extends PApplet {
    private SlotMachine sm;
    private PImage backgroundImage;
    private PImage appleImage;
    private PImage bananaImage;
    private PImage grapesImage;
    private PImage pearImage;
    private SoundFile spinSound;
    private SoundFile win2Sound;
    private SoundFile win5Sound;
    private SoundFile voucherPrintSound;

    public static void main(String[] args) {
        PApplet.main("SlotsUI", args);
    }

    public void settings() {
        size(400, 400);
    }

    public void setup() {
        sm = new SlotMachine();
        backgroundImage = loadImage("SlotMachine.png");
        appleImage = loadImage("Apple.png");
        bananaImage = loadImage("Banana.png");
        grapesImage = loadImage("Grapes.png");
        pearImage = loadImage("Pear.png");

        spinSound = new processing.sound.SoundFile(this, "spin.wav");
        win2Sound = new processing.sound.SoundFile(this, "win2.wav");
        win5Sound = new processing.sound.SoundFile(this, "win5.wav");
        voucherPrintSound = new SoundFile(this, "voucherPrint.wav");
        sm.loadMedia(appleImage, bananaImage, grapesImage, pearImage);
        textAlign(LEFT, BASELINE);
    }

    public void draw() {
        background(255);
        image(backgroundImage, 0, 0, width, height);
        sm.draw(this);
    }

    public void mousePressed() {
        if (mouseX >= 0 && mouseX <= 170 && mouseY >= 320 && mouseY <= 450) {
            if (sm.getBalance() >= 5) {
                spinSound.play();
                sm.play(5);

                if (sm.getResult().equals("Won 2x")) {
                    win2Sound.play();
                } else if (sm.getResult().equals("Won 5x")) {
                    win5Sound.play();
                }
            }
        }
        else if (mouseX >= 170 && mouseX <= 310 && mouseY >= 320 && mouseY <= 450) {
            voucherPrintSound.play();
            sm.dispense();
        }
        else if (mouseX >= 310 && mouseX <= 500 && mouseY >= 320 && mouseY <= 450) {
            sm.insertMoney(20);
        }
    }
}