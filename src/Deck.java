import java.util.ArrayList;

public class Deck {
    private ArrayList<Card> deck;
    private int cardsLeft;

    public void deck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};
        int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10};
        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                deck.add(new Card(ranks[i], suits[j], values[i]));
                cardsLeft =  52;
            }
        }
    }

    public Deck(String[] ranks, String[] suits, int[] values){
        cardsLeft = 0;
        for (int i = 0; i < ranks.length; i++){
            for (int j = 0; j < suits.length; j++){
                deck.add(new Card(ranks[i], suits[j], values[i]));
                cardsLeft++;
            }
        }
    }

    public boolean isEmpty(){
        if (deck.isEmpty()){
            return true;
        }
        return false;
    }

    public int getCardsLeft() {
        return cardsLeft;
    }

    public Card deal(){
        if (deck.isEmpty()){
            return null;
        }
        cardsLeft--;
        return deck.get(cardsLeft + 1);
    }

    public void shuffle(){
        cardsLeft = deck.size();
        for (int i = deck.size(); i > 0; i--){
            int a = i;
            int b = int(Math.random() * deck.size());
            int temp = a;
            a = b;
            b = temp;
        }
    }
}
