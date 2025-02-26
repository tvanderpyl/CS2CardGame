import javax.swing.*;
import java.awt.*;

public class Card {
    private String rank;
    private String suit;
    private int value;
    private Image image;
    private GameViewer window;


    public Card(String rank, String suit, int value, int index, GameViewer window) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        // add the card image into the card
        String string = "Images/" + (index + 1) + ".png";
        image = new ImageIcon(string).getImage();
        this.window = window;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSuit() {
        return suit;
    }

    public void setSuit(String suit) {
        this.suit = suit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String toString() {
        return rank + " of " + suit;
    }

    public Image getImage(){
        return image;
    }

    public void draw(Graphics g){
        g.drawImage(image, 200, 100, window);
    }
}
