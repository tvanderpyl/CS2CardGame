import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private int cardsLeft;

    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
    Integer[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};

    public void deck(){
        for (int i = 0; i < 13; i++){
            for (int j = 0; j < 4; j++)
            {
                 deck.add(new Card(ranks[i], suits[j], values[i]));
            }
    }
}
