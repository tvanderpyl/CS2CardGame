import javax.swing.*;
import java.awt.*;

public class Card {
    private String rank;
    private String suit;
    private int value;
    private Image image;

    public Card(String rank, String suit, int value, int index) {
        this.rank = rank;
        this.suit = suit;
        this.value = value;
        String string = "Images/" + index + ".png";
        image = new ImageIcon(string).getImage();
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
}
