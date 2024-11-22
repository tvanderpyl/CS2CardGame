import java.util.ArrayList;

public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int points;
    private int mun;

    public Player(String name) {
        points = 0;
        this.name = name;
        hand = new ArrayList<Card>();
    }

    public Player(String name, int mun) {
        points = 0;
        this.name = name;
        hand = new ArrayList<Card>();
        this.mun = mun;
    }

    public Player(String name, ArrayList<Card> hand) {
        points = 0;
        this.name = name;
        this.hand = hand;
    }

    public Player(String name, ArrayList<Card> hand, int mun){
        points = 0;
        this.name = name;
        this.hand = hand;
        this.mun = mun;
    }

    public void deal(Deck deck){
        hand.add(deck.deal());
        hand.add(deck.deal());
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {
        this.hand = hand;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public void addPoints(int add){
        points += add;
    }

    public void addCard(Card newCard){
        hand.add(newCard);
    }

    public String toString(){
        String ret = name + " has " + points + " points\n";
        for (int i = 0; i < hand.size(); i++) {
            ret = ret + hand.get(i);
            ret = ret + " ";
        }
        return ret;
    }
}

