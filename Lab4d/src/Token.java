//Prince Ezeoma - Student ID: 49327960
/**
 * This program represents a token object for a slot machine.
 * Each token has a label that displays on the wheel.
 * Created on April 21st, 2026
 */
public class Token {
    private String label;

    public Token(String label){
        this.label = label;
    }

    public String getLabel(){
        return label;
    }

    public void setLabel(String label){
        this.label = label;
    }

    public String toString(){
        return label;
    }
}
