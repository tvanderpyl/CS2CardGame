import java.util.ArrayList;

public class Game {
    private Deck deck;
    private Player pOne;
    private Player pTwo;

    public Game() {
        deck = new Deck();
        pOne = new Player("CPU");
        pTwo = new Player("JP", 100);
    }

    public void deal() {
        pOne.deal(deck);
        pTwo.deal(deck);
    }

    public static void instructions() {
        System.out.println("It's Blackjack Bruv");
    }

    public int val(ArrayList<Card> hand){
        int value = 0;
        for (int i = 0; i < hand.size(); i++) {
            value += hand.get(i).getValue();
        }
        return  value;
    }

    public void playGame() {
        deck.shuffle();
        this.deal();
        int valC = this.val(pOne.getHand());
        int valP = this.val(pTwo.getHand());
        System.out.println(valC);
        System.out.println(valP);
        System.out.println(pOne.toString());
        System.out.println(pTwo.toString());
    }

    public static void main(String[] args) {
        Game game = new Game();
        Game.instructions();
        game.playGame();
    }
}